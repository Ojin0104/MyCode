import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek15989숫자더하기 {

    static int T;
    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        T=Integer.parseInt(stringTokenizer.nextToken());

        int[] dp=new int[10001];
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=4;
        for(int i=5;i<10001;i++){
            dp[i]=dp[i-1]+1;
            if(i%2==0)
                dp[i]++;
            if(i%3==0)
                dp[i]++;
            if(i%6==0)
                dp[i]--;


        }
        int n;
        for(int i=0;i<T;i++){

            stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            n=Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(dp[n]);

        }
    }
}
