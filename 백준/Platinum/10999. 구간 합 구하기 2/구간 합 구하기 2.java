import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int K;
    static long[] tree;
    static long[] lazy;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N=Integer.parseInt(stringTokenizer.nextToken());
        M=Integer.parseInt(stringTokenizer.nextToken());
        K=Integer.parseInt(stringTokenizer.nextToken());

        //init tree초기화하는부분
        init(bufferedReader);
        StringBuilder stringBuilder = new StringBuilder();

        for(int i=0;i<M+K;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int option=Integer.parseInt(stringTokenizer.nextToken());
            int left=Integer.parseInt(stringTokenizer.nextToken());
            int right=Integer.parseInt(stringTokenizer.nextToken());

            if(option==1){
                long diff=Long.parseLong(stringTokenizer.nextToken());
                update(1,1,tree.length/2,left,right,diff);
            }else{
                stringBuilder.append(sum(1,1,tree.length/2,left,right)+"\n");
            }

        }
        System.out.println(stringBuilder);
    }

    static void init(BufferedReader bufferedReader) throws IOException {
        int size=1;
        while(size<N){
            size*=2;
        }

        tree=new long[2*size];
        lazy=new long[2*size];

        //leaf노드 설정
        for(int i=0;i<N;i++){
            tree[size+i]=Long.parseLong(bufferedReader.readLine());
        }

        //뒤에서부터 leaf노드 더해줌
        for(int i=size-1;i>=1;i--){
            tree[i]=tree[i*2]+tree[i*2+1];
        }

    }

    static void update(int node,int start,int end,int queryLeft, int queryRight,long diff){
        update_lazy(node,start,end);
        if(queryLeft>end||queryRight<start) return;//범위 아예 x

        if(start>=queryLeft&&end<=queryRight){//범위에 포함될때
            tree[node]+=(end-start+1)*diff;
            if(start!=end){
                lazy[node*2]+=diff;
                lazy[node*2+1]+=diff;
            }
            return;
        }
        update(node*2,start,(start+end)/2,queryLeft,queryRight,diff);
        update(node*2+1,(start+end)/2+1,end,queryLeft,queryRight,diff);
        tree[node]=tree[node*2]+tree[node*2+1];


    }

    static long sum(int node,int start,int end,int queryLeft,int right){
        update_lazy(node,start,end);
        if(queryLeft>end||right<start)return 0;//범위벗어남
        if(queryLeft<=start&&end<=right) return tree[node];
        int mid=(start+end)/2;
        return sum(node*2,start,mid,queryLeft,right)+sum(node*2+1,mid+1,end,queryLeft,right);
    }

    static void update_lazy(int node,int start, int end){
        if(lazy[node]!=0){
            tree[node]+=(end-start+1)*lazy[node];
            if(start!=end){
                lazy[node*2]+=lazy[node];
                lazy[node*2+1]+=lazy[node];
            }
            lazy[node]=0;
        }
    }



}
