import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2579계단오르기 {
    //do[i][j] j번째 계단에 i칸만큼 올라올때 최대값

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n=Integer.parseInt(stringTokenizer.nextToken());
        int[] stairs=new int[n+1];
        for(int i=1;i<n+1;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            stairs[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        int[][] dp=new int[n+1][3];
        dp[1][1]=stairs[1];
        dp[1][2]=stairs[1];

        for(int i=2;i<n+1;i++){//0은 1이 첫번째 1은 1이 두번째


            dp[i][1]=dp[i-1][2]+stairs[i];
            dp[i][2]=Math.max(Math.max(dp[i-2][1],dp[i-2][2]),dp[i-2][0])+stairs[i];

        }

        System.out.println(Math.max(dp[n][1],dp[n][2]));
    }

}
