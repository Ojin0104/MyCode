import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1.MCN을 구하는 문제 
 * 2.dp (파스칼삼각형을 사용한다)
 */
public class Main {
	static int answer = 0;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			dp = new int[M + 1][N + 1];//MCN 까지 배열생성
			findPascal(N, M);
			sb.append(dp[M][N] + "\n");
		}
		System.out.println(sb);
	}

	static void findPascal(int N, int M) {
		dp[0][0]=1;
		for (int row = 1; row <= M; row++) {
			dp[row][0] = 1;
			for (int col = 1; col <= Math.min(N, row); col++) {//N보다 큰 열은 사용하지 않으므로 굳이 연산하지 않는다.
				dp[row][col] = dp[row - 1][col] + dp[row - 1][col - 1];
			}
		}
	}
}
