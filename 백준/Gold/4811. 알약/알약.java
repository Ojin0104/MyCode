import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        BigInteger[][] dp=new BigInteger[61][61];
        for(int i=0;i<61;i++){
            dp[0][i]=new BigInteger("0");
        }
        for(int i=0;i<61;i++){
            dp[i][0]=new BigInteger("1");
        }

        for(int i=1;i<61;i++){
            for(int j=1;j<61;j++){
                dp[i][j]=dp[i-1][j-1].add(dp[i-1][j]);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(true){
            int num=Integer.parseInt(br.readLine());
            if(num==0){
                System.out.println(sb);
                return;
            }

            sb.append(dp[num*2][num].divide(new BigInteger(String.valueOf(num+1)))+" ");


        }

    }

}
