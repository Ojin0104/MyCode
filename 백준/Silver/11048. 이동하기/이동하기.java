import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1. 방향이 오른쪽아래 로 진행되므로
 * 2. 행 열을 반복하여 해당셀의 위  왼쪽 중 가장 큰값을 더한다.
 * 3. 각 위치의 사탕은 양수개이므로 굳이 왼쪽대각선의 값을고려할 필요가없다.
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[N+1][M+1];

		
		for(int row=1;row<=N;row++) {
			for(int col =1; col<=M;col++) {
				dp[row][col]=Math.max(dp[row-1][col], dp[row][col-1])+map[row-1][col-1];;
				
			}
		}
		System.out.println(dp[N][M]);

	}
}
