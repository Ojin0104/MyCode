import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1. bfs로 진행(도착지점에 도착한 가장 빠른 시점을 찾는 문제이므로 찾자마자 return)
 * 2. 점프횟수가 남아있다면 대각선 방향으로 점프해주는 로직 + 점프횟수 상관없이 4방향 탐색하는 로직
 * 3. int형의 check배열을 사용하여 방문을 체크해준다 -> check배열안에는 해당 지점에 도착했을때 남아있는 점프횟수를 기록한다.
 * 4. 다음번에 같은 지점에 방문을 할때 점프횟수가 같거나 작다면 que에 추가하지 않는다. (같거나 작은 점프횟수라면 이전에 도착한 경로보다 돌아왔다는 뜻)
 * 5. 도착지점 찾자마자 바로 return
 *
 */
public class Main {
	static int K;
	static int W;
	static int H;
	static int[] dr = { 1, 0, -1, 0 };//4방향 탐색
	static int[] dc = { 0, 1, 0, -1 };
	static int[] ddr = { 1, 1, -1, -1 };//대각선탐색
	static int[] ddc = { 1, -1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[][] map = new int[H][W];

		for (int row = 0; row < H; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < W; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = bfs(map);

		System.out.println(answer);
	}

	static int bfs(int[][] map) {
		ArrayDeque<Status> que = new ArrayDeque<>();
		int[][] check = new int[H][W];
		for (int row = 0; row < H; row++) {// 점프가 없는경우도 갱신할 수 있어야 하므로 처음에 -1로 초기화
			Arrays.fill(check[row], -1);
		}
		que.add(new Status(0, 0, 0, K));

		while (!que.isEmpty()) {

			Status now = que.pollFirst();

			if (now.row == H - 1 && now.col == W - 1)
				return now.times;

			//점프탐색
			if (now.jump > 0) {
				for (int dir = 0; dir < 4; dir++) {//대각선 4방향으로 bfs진행
					
					
					int next_r = now.row + ddr[dir] * 2;
					int next_c = now.col + ddc[dir];

					if (next_r >= 0 && next_c >= 0 && next_r < H && next_c < W && map[next_r][next_c] == 0) {// 범위포함 
						
						if (check[next_r][next_c] < now.jump - 1) {//점프를 해서 해당위치에 도착하는 것이므로 -1 을 추가로해준다.
							que.addLast(new Status(next_r, next_c, now.times + 1, now.jump - 1));
							check[next_r][next_c] = now.jump - 1;
						}
						
					}

					next_r = now.row + ddr[dir];
					next_c = now.col + ddc[dir] * 2;
					
					if (next_r >= 0 && next_c >= 0 && next_r < H && next_c < W && map[next_r][next_c] == 0) {// 범위포함
						
						if (check[next_r][next_c] < now.jump - 1) {//점프 남은 횟수가 많을시
							que.addLast(new Status(next_r, next_c, now.times + 1, now.jump - 1));
							check[next_r][next_c] = now.jump - 1;
						}
						
					}

				}
			}

			//4방향 탐색
			for (int dir = 0; dir < 4; dir++) {
				int next_r = now.row + dr[dir];
				int next_c = now.col + dc[dir];

				if (next_r >= 0 && next_c >= 0 && next_r < H && next_c < W && map[next_r][next_c] == 0) {// 범위포함
					
					if (check[next_r][next_c] < now.jump) {//점프 남은 횟수가 많을시
						que.addLast(new Status(next_r, next_c, now.times + 1, now.jump));
						check[next_r][next_c] = now.jump;
					}
					
				}
			}

		}

		return -1;

	}

	static class Status {
		int row;
		int col;
		int times;//움직인 횟수
		int jump;// 점프 남은 횟수

		public Status(int row, int col, int times, int jump) {
			this.row = row;
			this.col = col;
			this.times = times;
			this.jump = jump;
		}
	}
}
