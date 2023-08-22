import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1. CCTV클래스와 CCTV배열을 만들어 각 CCTV의 회전 경우의 수를 따져 dfs를 사용한다.
 * 2. dfs를 새로 들어갈떄마다 new map으로 새로운 map을 만들고 CCTV의 type에 맞게 "#"을 넣는다.
 * 3. 모든 CCTV를 기준으로 #을 표시했을때 0의 수를 체크하고 min변수에 저장한다.
 */
public class Main {
	static int min = Integer.MAX_VALUE;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int num = 0;
	static ArrayList<CCTV> cctvs;

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
		cctvs = new ArrayList<CCTV>();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(bufferedReader.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if (map[row][col] != 0 && map[row][col] != 6) {
					num++;
					cctvs.add(new CCTV(row, col, map[row][col]));
				}
			}
		}
		
		dfs(map, 0);
		System.out.println(min);
	}

	static void dfs(int[][] map, int count) {
		if (count == num) {
			int answer = 0;
			for (int row = 0; row < map.length; row++) {
				for (int col = 0; col < map[0].length; col++) {

					if (map[row][col] == 0) {
						answer++;
					}
				}
			}

			min = Math.min(min, answer);

			return;
		}

		CCTV now = cctvs.get(count);
		for (int idx = 0; idx < 4; idx++) {
			int[][] newmap = copyMap(map);
			if (now.type == 2 && idx >= 2) {
				return;
			} else if (now.type == 5 && idx >= 1) {
				return;
			}
			fillMap(newmap, now, idx);
			dfs(newmap, count + 1);
		}
	}

	static void fillMap(int[][] newmap, CCTV now, int dir) {

		if (now.type == 1) {//한쪽방향 # 표시
			int r = now.r;
			int c = now.c;
			while (true) {

				if (r + dr[dir] < 0 || c + dc[dir] < 0 || r + dr[dir] >= newmap.length
						|| c + dc[dir] >= newmap[0].length)
					break;
				if (newmap[r + dr[dir]][c + dc[dir]] == 6)
					break;
				if (newmap[r + dr[dir]][c + dc[dir]] == 0)
					newmap[r + dr[dir]][c + dc[dir]] = now.type;
				r = r + dr[dir];
				c = c + dc[dir];
			}
		} else if (now.type == 2) {//가로는가로 세로는 세로 끼리 방향 잡아서 #표시
			for (int i = 0; i < 2; i++) {

				int d = (dir + 2 * i) % 4;
				int r = now.r;
				int c = now.c;
				while (true) {
					if (r + dr[d] < 0 || c + dc[d] < 0 || r + dr[d] >= newmap.length || c + dc[d] >= newmap[0].length)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 6)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 0)
						newmap[r + dr[d]][c + dc[d]] = now.type;
					r = r + dr[d];
					c = c + dc[d];
				}

			}
		} else if (now.type == 3) {//붙어있는 dir 두개를 잡고  #표시
			for (int i = 0; i < 2; i++) {
				int d = (dir + i) % 4;
				int r = now.r;
				int c = now.c;
				while (true) {
					if (r + dr[d] < 0 || c + dc[d] < 0 || r + dr[d] >= newmap.length || c + dc[d] >= newmap[0].length)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 6)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 0)
						newmap[r + dr[d]][c + dc[d]] = now.type;
					r = r + dr[d];
					c = c + dc[d];
				}
			}
		} else if (now.type == 4) {//3방향에 #표시
			for (int i = 0; i < 3; i++) {
				int d = (dir + i) % 4;
				int r = now.r;
				int c = now.c;
				while (true) {
					if (r + dr[d] < 0 || c + dc[d] < 0 || r + dr[d] >= newmap.length || c + dc[d] >= newmap[0].length)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 6)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 0)
						newmap[r + dr[d]][c + dc[d]] = now.type;
					r = r + dr[d];
					c = c + dc[d];
				}
			}
		} else if (now.type == 5) {//한번에 4방향 모두 #표시
			for (int i = 0; i < 4; i++) {
				int d = (dir + i) % 4;
				int r = now.r;
				int c = now.c;
				while (true) {
					if (r + dr[d] < 0 || c + dc[d] < 0 || r + dr[d] >= newmap.length || c + dc[d] >= newmap[0].length)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 6)
						break;
					if (newmap[r + dr[d]][c + dc[d]] == 0)
						newmap[r + dr[d]][c + dc[d]] = now.type;
					r = r + dr[d];
					c = c + dc[d];
				}
			}
		}

	}

	static int[][] copyMap(int[][] map) {
		int[][] newmap = new int[map.length][map[0].length];
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				newmap[row][col] = map[row][col];
			}
		}
		return newmap;
	}

	static class CCTV {
		int r;
		int c;
		int type;

		public CCTV(int r, int c, int type) {
			this.r = r;
			this.c = c;
			this.type = type;
		}
	}
}
