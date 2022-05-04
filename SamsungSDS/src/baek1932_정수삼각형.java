import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1932_정수삼각형 {
    static int[][] dp;
    static int[][] triangle;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        dp=new int[n+1][n+1];
        triangle=new int[n+1][n+1];
        StringTokenizer st;
        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
               // System.out.println(j);
                triangle[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=n;i++){

            for(int j=1;j<=i;j++){
                dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+triangle[i][j];
              //  System.out.print(dp[i][j]);
            }
           // System.out.println();
        }
        int max=0;
        for(int i=1;i<dp[n].length;i++){
            if(max<dp[n][i])max=dp[n][i];
        }
        System.out.println(max);

    }
}
