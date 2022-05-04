package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14501퇴사 {
    static int N;
    static int[] time;
    static int[] money;
    static int[] dp;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader((System.in)));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        time=new int[N];
        money=new int[N];
        dp=new int[N+1];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            money[i]=Integer.parseInt(st.nextToken());


        }
        for(int i=N-1;i>=0;i--){
            if(i+time[i]>N){
                if(i!=N-1)
                dp[i]=dp[i+1];
            }else{
                dp[i]=Math.max(dp[i+1],money[i]+dp[i+time[i]]);
            }
        }
        System.out.println(dp[0]);
    }
}
