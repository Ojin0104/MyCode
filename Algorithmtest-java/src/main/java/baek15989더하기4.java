import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek15989더하기4 {

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int T=Integer.parseInt(st.nextToken());
        int[][] dp=new int[10001][3];
        dp[1][0]=1;
        dp[2][0]=1;
        dp[2][1]=1;
        dp[3][0]=1;
        dp[3][1]=1;
        dp[3][2]=1;

        for(int i=4;i<10001;i++){
            dp[i][0]=dp[i-1][0];
            dp[i][1]=dp[i-2][0]+dp[i-2][1];
            dp[i][2]=dp[i-3][0]+dp[i-3][1]+dp[i-3][2];
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){

            st=new StringTokenizer(br.readLine());

            int n=Integer.parseInt(st.nextToken());
            sb.append(dp[n][0]+dp[n][1]+dp[n][2]+"\n");

        }
        System.out.println(sb.toString());
    }
}
