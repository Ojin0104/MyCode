import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author SSAFY
 *  1.알파벳 대문자는 총 26개 이므로 26사이즈의 배열을 만들어 체크를 한다.
 *  2.dfs를 통해 이동할 수 있을때 까지 칸을 계산한다.
 *  3.dp 까지 사용해야하나
 */
public class Main {
	static boolean[] alpha = new boolean[26];
	static int answer = 0;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int R;
	static int C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		char[][] map = new char[R][C];

		for (int row = 0; row < R; row++) {
			String line = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = line.charAt(col);
			}
		}
		alpha[map[0][0] - 'A'] = true;
		dfs(map, 0, 0, 1);

		System.out.println(answer);
	}

	static void dfs(char[][] map, int row, int col, int count) {
		answer = Math.max(count, answer);

		for (int dir = 0; dir < 4; dir++) {
			int next_r = row + dr[dir];
			int next_c = col + dc[dir];

			if (next_r < 0 || next_c < 0 || next_r >= R || next_c >= C)
				continue;

			if (alpha[map[next_r][next_c] - 'A'])
				continue;

			alpha[map[next_r][next_c] - 'A'] = true;
			dfs(map, next_r, next_c, count + 1);
			alpha[map[next_r][next_c] - 'A'] = false;
		}
	}
}
