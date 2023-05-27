
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static int[] in,post,index;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        in=new int[N];
        post=new int[N];
        index=new int[N+1];

        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            in[i]=Integer.parseInt(st.nextToken());
            index[in[i]]=i;
        }

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            post[i]=Integer.parseInt(st.nextToken());
        }

        devideHalf(0,N-1,0,N-1);

        System.out.println(sb);




    }
    static void devideHalf(int in_start, int in_end,int post_start,int post_end){
        if(in_start>in_end||post_start>post_end)return;
        int root=post[post_end];

        sb.append(root+" ");


        devideHalf(in_start,index[root]-1,post_start,post_start+index[root]-in_start-1);
        devideHalf(index[root]+1,in_end,post_start+index[root]-in_start,post_end-1);
    }
}
