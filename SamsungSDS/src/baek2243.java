import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2243 {//platinum 사탕상자
    static int n;
    static int A;
    static int B;
    static int C;
    static int N=1000000;
    static int S=1;
    static int result;
    static int[] tree;
    public static void main(String args[]) throws IOException {

        //1. 입력 부분 작성
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());

        while(S<N){
            S*=2;
        }
        tree=new int[2*S];
        StringTokenizer st;

        //2. index tree top-down방식으로 init, query, insert 구현

        for(int i=0; i<n;i++){
            st=new StringTokenizer(br.readLine());
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            if(st.hasMoreElements())
                C=Integer.parseInt(st.nextToken());
            ///입력 끝

            if(A==1){
                //1 일땐 query
                int index=query(1,S,1,B);
               // System.out.println(query(1,B)-S+1);
                update(1,S,1,index,-1);
                System.out.println(index);
            }else{
                //2일땐 update
                update(1,S,1,(int)B,C);
            }

        }


    }
static void update(int left,int right,int node,int target,long diff){
    if (target<left||target>right){//포함안되는 값 그냥 리턴
        return ;
    }else{//포함된다면 그 노드값 diff만큼 변경해주고 반 나눠서 자식노드 들어감
        tree[node]+=diff;
        //System.out.println(node);
        //System.out.println("node "+tree[node]);
        if(left!=right){//left,right같아지면 리프노드이므로 그냥 RETURN
            int mid=(left+right)/2;
            update(mid+1,right,node*2+1,target,diff);
            update(left,mid,node*2,target,diff);
        }
    }
}

static int query(int left,int right,int node,int count){
        if(left==right){
            return left;
        }
        int mid=(left+right)/2;

        if(tree[node*2]>=count){
            return query(left,mid,node*2,count);
        }
        else{
            return query(mid+1,right,node*2+1,count-tree[node*2]);

        }
}
//static int query(int node,long th){//이건 내가짠ㅋ드 위에는 짜준거 위에가 더빠르긴함
//
//        if(node>=S)//리프노드라면 해당 노드 몇번째 인지 출력하고 사탕 갯수 -1해줌
//        {if(th<=tree[node]){
//            result=node;
//            update(1,S,1,result-S+1,-1);
//            //System.out.println("result"+ (result-S+1));
//        return result;
//        }else{
//            th-=tree[node];
//            result=query(node+1,th);
//          //  System.out.println("result"+ (result-S+1));
//
//        }
//        } else if(th>tree[node]){//왼쪽포함안 되면 오른쪽
//            th-=tree[node];
//            result=query(node+1,th);
//
//        }else{//값 포함될 경우 왼쪽부터
//            result=query(2*node,th);
//
//        }
//
//return result;
//}
}
