import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2042 {

    static int N;
    static int M;
    static int K;
    static long[] nums;
    static int S;
    static long[] tree;
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        nums=new long[N];
        for(int i=0;i<N;i++){
            nums[i]=Long.parseLong(br.readLine());
        }
        S=1;
        while(S<N){
            S*=2;
        }
       //1 System.out.println(S);
        tree=new long[2*S];

        init();
        for(int i=0;i<M+K;i++){
            int func;
            long a;
            long b;
            st=new StringTokenizer(br.readLine());
            func=Integer.parseInt(st.nextToken());
            a=Long.parseLong(st.nextToken());
            b=Long.parseLong(st.nextToken());

            if(func==1){
                //update
                long diff=b-tree[S+(int)a-1];

                update(1,S,1,(int)a,diff);

            }else if(func==2){
                //query
                System.out.println(query(1,S,1,(int)a,(int)b));
            }
        }
    }
    static void init(){
        //leaf 값 넣기
        for(int i=0;i<N;i++){
            tree[S+i]=nums[i];
        }
        //내부 노드 값 넣기(뒤에서부터
        for(int i=S-1;i>0;i--){
            tree[i]=tree[2*i]+tree[2*i+1];
        }
    }
    static void update(int left,int right,int node,int target,long diff) {//left right는 1~S범위 준다고생각
        //범위안에있으면 추가
        if (target > right || target < left||node>=tree.length) {
            return;
            }
         else {

        tree[node] += diff;
        if(left!=right){
            int mid=(left+right)/2;
            update(mid+1,right,node*2+1,target,diff);
            update(left,mid,node*2,target,diff);

        }
    }}
    static long query(int left,int right,int node,int queryleft,int queryright) {

        //범위밖의값
        if (right < queryleft || left > queryright||node>=tree.length) {
            return 0;
        }
        //범위안의값

        else if (left >= queryleft && right <= queryright) {

            return tree[node];
        }
        //범위겹쳐 자식노드가야함
        else{
            int mid=(left+right)/2;
            long leftquery=query(left,mid,node*2,queryleft,queryright);
            long rightquery=query(mid+1,right,node*2+1,queryleft,queryright);
            return leftquery+rightquery;
        }


    }
}
class nodes{
    int left;
    int right;
    int node;

    nodes(int l,int r,int n){
        this.left=l;
        this.right=r;
        this.node=n;

    }
}