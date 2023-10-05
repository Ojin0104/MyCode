import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *  1.가장 작은 값으로 도착지점에 도착하는 방법
 *  2.다익스트라 사용하여 N-1,N-1까지 움직인다.
 *
 */
public class Main {

	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int problem = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			int[][] map = new int[N][N];

			for (int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int col = 0; col < N; col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			int answer = dikstra(map);
			sb.append("Problem " + problem + ": " + answer + "\n");
			problem++;
		}

		System.out.println(sb);
	}

	static int dikstra(int[][] map) {
		PriorityQueue<Status> que = new PriorityQueue<Status>((a, b) -> a.dist - b.dist);// 간선 짧은 순 정렬
		que.add(new Status(0, 0, map[0][0]));
		boolean[][] check = new boolean[N][N];//노드 방문 체크 배열
		int[][] distArr = new int[N][N];//해당 노드점 까지의 최소길이

		for (int row = 0; row < N; row++) {
			Arrays.fill(distArr[row], Integer.MAX_VALUE / 4);
		}

		while (!que.isEmpty()) {
			Status now = que.poll();
			if (check[now.row][now.col])
				continue;
			check[now.row][now.col] = true;
			for (int dir = 0; dir < 4; dir++) {// 해당노드의 간선은 4방향
				int nextR = now.row + dr[dir];
				int nextC = now.col + dc[dir];

				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N)
					continue;

				if (check[nextR][nextC])
					continue;

				if (distArr[nextR][nextC] > now.dist + map[nextR][nextC]) {// 더 최소비용 있을시 갱신
					distArr[nextR][nextC] = now.dist + map[nextR][nextC];
					que.add(new Status(nextR, nextC, distArr[nextR][nextC]));
				}

			}

		}

		return distArr[N - 1][N - 1];
	}

	static class Status {
		int row;
		int col;
		int dist;

		Status(int row, int col, int dist) {
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
}
