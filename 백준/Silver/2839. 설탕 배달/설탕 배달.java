import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 영진 
 * 1. dp사용하여 설탕 N킬로일떄 가장작은 봉지 구함
 * 2. 해당 kilogram의 -3 또는 -5인 지점보다 1개 많은 봉지를 사용하므로 
 * 3. 점화식 dp[kilo] = Math.min(dp[kilo-3],dp[kilo-5])+1; 이된다.
 * 4. setDp로 5kilo까지의 값을 설정한다.
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine());

		int vinyl = 0;
		int sugarkilo = sugar;

		int[] dp = new int[sugar + 1];
		setDp(dp);

		for (int kilo = 6; kilo <= sugar; kilo++) {
			dp[kilo] = Math.min(dp[kilo - 3], dp[kilo - 5]) + 1;
		}

		if (dp[sugar] >= 2000) {
			System.out.println(-1);
		} else {
			System.out.println(dp[sugar]);
		}

	}

	static void setDp(int[] dp) {// 최대 N이 5000 이므로 3으로 나눠도 최대 약1666개 까지 밖에안됨 -> 2000으로 못가져가는 경우 체크
		dp[0] = 2000;
		dp[1] = 2000;
		dp[2] = 2000;
		dp[3] = 1;
		if (dp.length > 4)
			dp[4] = 2000;
		if (dp.length > 5)
			dp[5] = 1;
	}
}
