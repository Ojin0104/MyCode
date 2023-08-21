import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/**
 * 
 * @author 영진 
 * 1. 각 셀 마다 bfs를 진행해줌 
 * 2. 방문한 위치 check배열로 표시해 다시 방문 하지 못하게 함 
 * 3. 먼저 색약이 아닌 경우 진행후 R을 모두G로 바꾸고 색약인경우 진행
 *
 */
public class Main {
	static char[][] map;
	static boolean[][] check;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		map = new char[N][N];
		check = new boolean[N][N];
		for (int row = 0; row < N; row++) {
			String line = br.readLine();
			for (int col = 0; col < N; col++) {
				map[row][col] = line.charAt(col);
			}
		}
		int answer = 0;
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (check[row][col])//이미 방문했을 경우 continue
					continue;
				check[row][col] = true;
				bfs(row, col);
				answer++;
			}
		}
		sb.append(answer + " ");

		// 초기화
		answer = 0;
		check = new boolean[N][N];

		// 적록색맹인경우 빨간색을 초록색으로
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (map[row][col] == 'R')
					map[row][col] = 'G';
			}
		}

		for (int row = 0; row < N; row++) {
			for (int col = 0; col < N; col++) {
				if (check[row][col])
					continue;
				check[row][col] = true;
				bfs(row, col);
				answer++;
			}
		}

		sb.append(answer);
		System.out.println(sb);
	}

	static void bfs(int row, int col) {
		ArrayDeque<int[]> que = new ArrayDeque<>();
		que.add(new int[] { row, col });

		char nowColor = map[row][col];

		while (!que.isEmpty()) {
			int[] now = que.pollFirst();

			for (int dir = 0; dir < 4; dir++) {
				int next_r = now[0] + dr[dir];
				int next_c = now[1] + dc[dir];

				if (next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)
					continue;//범위 벗어나는 경우
				if (check[next_r][next_c])
					continue; // 이미 탐색된 곳
				
				if (map[next_r][next_c] == nowColor) {//같은 색깔 범위일 경우 방문체크 해주고 큐에 추가
					que.addLast(new int[] { next_r, next_c });
					check[next_r][next_c] = true;
				}
			}
		}
	}
}
