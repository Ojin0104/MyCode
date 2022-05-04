package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2156포도주 {
    static int n;
    static int[] num;
    static int[][] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
       num=new int[n];

        dp=new int[n][3];
        for(int i=0;i<n;i++){
           num[i]=Integer.parseInt(br.readLine());
        }
        dp[0][0]=0;
        dp[0][1]=num[0];
        dp[0][2]=0;
        if(n>1) {
            dp[1][0] = dp[0][1];
            dp[1][1] = num[1];
            dp[1][2] = dp[0][1] + num[1];
        }
        for(int i=2;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],Math.max(dp[i-1][1],dp[i-1][2]));
            dp[i][1]=dp[i-1][0]+num[i];
            dp[i][2]=dp[i-1][1]+num[i];
        }
        System.out.println(Math.max(Math.max(dp[n-1][0],dp[n-1][1]),dp[n-1][2]));
    }
}
