import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());
        
        int[][] dp=new int[K+1][N+1];
        dp[1][1]=1;
        for(int i=1;i<=K;i++){
            for(int j=1;j<=N;j++){
                if(j==1) {
                    dp[i][j] = i;
                    continue;
                }
                dp[i][j]=(dp[i-1][j]+dp[i][j-1])%1000000000;

            }
        }
        System.out.println(dp[K][N]);

    }
}