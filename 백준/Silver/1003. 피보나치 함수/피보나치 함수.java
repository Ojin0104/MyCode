import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(bufferedReader.readLine());
        long[][] dp=new long[41][2];
        dp[0][0]=1L;
        dp[1][1]=1L;
        for(int i=2;i<41;i++){
            dp[i][0]=dp[i-1][0]+dp[i-2][0];
            dp[i][1]=dp[i-1][1]+dp[i-2][1];
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<N;i++){
            int num=Integer.parseInt(bufferedReader.readLine());
            stringBuilder.append(dp[num][0]+" "+dp[num][1]+"\n");
        }
        System.out.println(stringBuilder);


    }
}
