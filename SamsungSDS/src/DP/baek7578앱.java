package DP;

import java.io.*;
import java.util.StringTokenizer;

public class baek7578앱 {
    static int N;
    static int M;
    static int[] bytes;
    static int[] costs;
    static int[][] DP;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());//필요한 메모리용량
        bytes=new int[N];
        costs=new int[N];

        int sum=0;//총 비용
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            bytes[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            costs[i]=Integer.parseInt(st.nextToken());
            sum+=costs[i];
        }
        DP=new int[N][sum+1];
        int answer=0;
        for(int i=0;i<N;i++){

            for(int j=0;j<sum+1;j++){//j가비용
                if (i == 0) {
                    if(j>=costs[i])DP[i][j]=bytes[i];
                }else{
                if(j>=costs[i]) {
                    DP[i][j] = Math.max(DP[i - 1][j], bytes[i] + DP[i - 1][j - costs[i]]);
                } else{
                    DP[i][j]=DP[i-1][j];

                    }}

                if(DP[i][j]>=M&&i==N-1){
                    answer=j;
                    break;
                }
                }
            }

bw.write(answer);
        bw.flush();
        bw.close();
    }
}
