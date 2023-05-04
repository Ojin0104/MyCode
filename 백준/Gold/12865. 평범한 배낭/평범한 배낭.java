import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] item;
    static int[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        item=new int[N+1][2];
        dp=new int[K+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            item[i][0]=Integer.parseInt(st.nextToken());
            item[i][1]=Integer.parseInt(st.nextToken());

        }


        for(int i=1;i<N+1;i++){

            for(int j=K;j-item[i-1][0]>=0;j--){
                
               
                dp[j]=Math.max(dp[j],dp[j-item[i-1][0]]+item[i-1][1]);

           //     System.out.print(dp[i][j]+" ");
            }
          //  System.out.println();
        }


        System.out.println(dp[K]);
    }

}