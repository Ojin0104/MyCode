import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static  void main(String[] args) throws IOException {

    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st=new StringTokenizer(br.readLine());

    int n=Integer.parseInt(st.nextToken());
    int k=Integer.parseInt(st.nextToken());
    int[] coin=new int[n];
    for(int i=0;i<n;i++){
        coin[i]=Integer.parseInt(br.readLine());
    }
    int[] dp=new int[k+1];

    Arrays.fill(dp,Integer.MAX_VALUE-10000);
    dp[0]=0;
    Arrays.sort(coin);
    for(int i=0;i<n;i++){
        for(int j=coin[i];j<k+1;j++){
            dp[j]=Math.min(dp[j],dp[j-coin[i]]+1);
        }
    }
    if(dp[k]==Integer.MAX_VALUE-10000)dp[k]=-1;
    System.out.println(dp[k]);
}
}