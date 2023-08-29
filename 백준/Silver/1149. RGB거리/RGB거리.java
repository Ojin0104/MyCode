
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1. dp[i][j] = i번째 집 j색깔 칠하는 최소값
 * 2. dp[i][빨강]=dp[i-1][초록],dp[i-1][파랑]중 작은값 + map[i][빨강]
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][3];
		int[][] dp = new int[N][3];
		for (int idx = 0; idx < N; idx++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			map[idx][0] = Integer.parseInt(st.nextToken());
			map[idx][1] = Integer.parseInt(st.nextToken());
			map[idx][2] = Integer.parseInt(st.nextToken());
		}
		dp[0][0] = map[0][0];
		dp[0][1] = map[0][1];
		dp[0][2] = map[0][2];

		for (int idx = 1; idx < N; idx++) {// 0부터 빨강,초록,파랑
			// 빨간색고르는 경우
			dp[idx][0] = Math.min(dp[idx - 1][1], dp[idx - 1][2]) + map[idx][0];
			// 초록
			dp[idx][1] = Math.min(dp[idx - 1][0], dp[idx - 1][2]) + map[idx][1];
			// 파랑
			dp[idx][2] = Math.min(dp[idx - 1][0], dp[idx - 1][1]) + map[idx][2];

		}
		System.out.println(findMin(dp[N - 1]));
	}

	static int findMin(int[] arr) {// 배열중 최소값찾아줌
		int min = Integer.MAX_VALUE;
		for (int num : arr) {
			min = Math.min(num, min);
		}

		return min;
	}
}
