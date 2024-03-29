import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(System.in));

        int N= Integer.parseInt(bufferedReader.readLine());
        int[][] dp =new int[3][N+1];
        dp[1][1]=1;
        if(N>=2) {
            dp[2][2] = 1;
            dp[0][2] = 1;
            dp[1][2] = 1;
        }
        for(int i =3;i<=N;i++){
            dp[0][i] = (dp[0][i-2]+dp[1][i-2]+dp[2][i-2])%10007;
            dp[1][i] = (dp[0][i-1]+dp[1][i-1]+dp[2][i-1])%10007;
            dp[2][i] = (dp[0][i-2]+dp[1][i-2]+dp[2][i-2])%10007;
        }

        System.out.println((dp[0][N]+dp[1][N]+dp[2][N])%10007);
    }
}
