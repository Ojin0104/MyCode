import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(bufferedReader.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            StringTokenizer stringTokenizer =new StringTokenizer(bufferedReader.readLine());

            int N=Integer.parseInt(stringTokenizer.nextToken());
            int M=Integer.parseInt(stringTokenizer.nextToken());
            int[][] dp=new int[M+1][N+1];
            dp[0][0]=1;

            for(int j=1;j<=M;j++){
                for(int k=0;k<=N;k++){
                    if (dp[j][k] == 0) {
                        dp[j][k]=dp[j-1][k];
                    }
                    for(int z=1;z<=3;z++){
                        if(k+z<N+1){
                            dp[j][k+z]=(dp[j-1][k]+dp[j][k+z])%1000000009;
                        }
                    }
                }
            }
            sb.append(dp[M][N]+"\n");


        }
        System.out.println(sb);
    }
}
