import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int answer=0;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		long[] dp = new long[N+1];
		long[] num = new long[N+1];
		
		dp[0]=1;
		if(N>=2)
			dp[2]=3;
		for(int index=4; index<=N;index+=2) {
			dp[index]= dp[index-2]*dp[2]+(dp[index-2]-dp[index-4]);
			
			
		}
		
		System.out.println(dp[N]);
	}
}