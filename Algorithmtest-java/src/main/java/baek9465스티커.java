import java.io.*;
import java.util.StringTokenizer;

public class baek9465스티커 {
    //dp[i][j] i번째행에 j열스티커 떼는경우에 최대값
    //i=0이면 둘다안땜

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int t=Integer.parseInt(stringTokenizer.nextToken());
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<t;i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());

            int[][] dp = new int[3][n];
            int[][] map=new int[3][n];

            for(int j=1;j<=2;j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int k=0;k<n;k++) {
                    map[j][k]=Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            dp[0][0]=0;
            dp[1][0]=map[1][0];
            dp[2][0]=map[2][0];
            for(int j=1;j<n;j++){
                dp[0][j]=Math.max(dp[2][j-1],dp[1][j-1]);
                dp[1][j]=Math.max(dp[0][j-1],dp[2][j-1])+map[1][j];
                dp[2][j]=Math.max(dp[0][j-1],dp[1][j-1])+map[2][j];
            }
            bufferedWriter.write(Math.max(dp[0][n-1],Math.max(dp[1][n-1],dp[2][n-1]))+"\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
