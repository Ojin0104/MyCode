package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek12865평범한배낭 {
    static int N;
    static int K;
    static int[][] item;
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        item=new int[N][2];
        dp=new int[N][K+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            item[i][0]=Integer.parseInt(st.nextToken());
            item[i][1]=Integer.parseInt(st.nextToken());

        }


        for(int i=1;i<N;i++){

            for(int j=0;j<K+1;j++){
                dp[i][j]=dp[i-1][j];
               if(j>=item[i][0]){
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-item[i][0]]+item[i][1]);}

           //     System.out.print(dp[i][j]+" ");
            }
          //  System.out.println();
        }


        System.out.println(dp[N-1][K]);
    }

}
