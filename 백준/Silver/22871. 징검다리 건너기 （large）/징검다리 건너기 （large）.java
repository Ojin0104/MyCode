import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int [] stones;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());


        stones = new int[N];
        dp= new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            dp[i] = Long.MAX_VALUE;
        }
        dp[0]=0;

        for(int i =1;i<N;i++){
            for(int j =0;j<i;j++){
                long power = Math.max(dp[j],(long)(i-j)*(1+Math.abs(stones[i]-stones[j])));
                dp[i] = Math.min(dp[i],power);
            }
        }

        System.out.print(dp[N-1]);
    }

}
