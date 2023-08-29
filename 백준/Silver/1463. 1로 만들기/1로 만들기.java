import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 영진
 * 1.dp[i]  정수 N이 i가 되었을때 최솟값 
 *
 */
public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		//dp[N]=1;
		for(int idx=N-1;idx>=1;idx--) {
			dp[idx]=Integer.MAX_VALUE;
			if(idx*2<=N) {//인덱스 범위 체크
				dp[idx]=dp[idx*2]+1;
			}
			
			if(idx*3<=N) {//인덱스 범위 체크
				dp[idx]=Math.min(dp[idx*3]+1, dp[idx]);
			}
			
			dp[idx]=Math.min(dp[idx], dp[idx+1]+1);
		}
		
		System.out.println(dp[1]);
	}
	
}
