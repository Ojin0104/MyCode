package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek10844쉬운계단수 {
    static int N;
    static long[][] DP;
    static long result;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        DP=new long[N+1][10];
        for(int i=1;i<10;i++){
            DP[1][i]=1;
        }
        for(int i=2;i<N+1;i++){
            for(int j=0;j<10;j++){
                if(j-1<0)DP[i][j]=DP[i-1][j+1];
                else if(j+1>9)DP[i][j]=DP[i-1][j-1];
                else{
                DP[i][j]=(DP[i-1][j-1]+DP[i-1][j+1]);}
               // System.out.println(DP[i][j]);
                DP[i][j]%=1000000000;
            }

        }
        for(int i=0;i<10;i++){
            result+=DP[N][i];
        }
        System.out.println(result%1000000000);
    }

}
