import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        BigInteger[][] dp=new BigInteger[N+1][M+1];
        for(int i=0;i<N+1;i++){
            for(int j=0;j<M+1;j++){
                dp[i][j]=new BigInteger("0");
            }
        }
        dp[0][0]=new BigInteger("1");
        dp[0][1]=new BigInteger("0");
        for(int i=1;i<N+1;i++){
            for(int j=0;j<M+1;j++){
                if(j==0)dp[i][j]=new BigInteger("1");
                else{
                    dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
                }
            }
        }
        System.out.println(dp[N][M]);


    }
}
