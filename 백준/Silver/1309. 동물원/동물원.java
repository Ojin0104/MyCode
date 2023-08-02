import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int[] dp=new int[N];
		
		if(N<=1) {
			System.out.println(3);
			return;
		}
		dp[0]=3;
		
		dp[1]=7;
		
		
		for(int index=2;index<N;index++) {
			dp[index]=(dp[index-2]+dp[index-1]*2)%9901;
		}
		
		System.out.println(dp[N-1]);
	}
}