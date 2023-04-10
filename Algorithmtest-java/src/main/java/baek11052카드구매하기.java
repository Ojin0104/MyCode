import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class baek11052카드구매하기 {

    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(bufferedReader.readLine());
        int[] dp=new int[N+1];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for(int i=1;i<N+1;i++){
            dp[i]=Integer.parseInt(stringTokenizer.nextToken());
        }
        for(int i=0;i<N+1;i++){
            for(int j=0;j<i;j++){
                dp[i]=Math.max(dp[i],dp[i-j]+dp[j]);
            }
        }

        System.out.println(dp[N]);




    }
}
