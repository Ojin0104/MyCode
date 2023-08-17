import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *  인접행렬으로구현 N사이즈가 1000 이므로 충분히 행렬로가능 
 *  
 *
 */
public class Main {
	static int N;
	static int M;
	static int V;
	static boolean[] check;// 방문체크하는 배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		boolean[][] graph = new boolean[N + 1][N + 1];
		check = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = true;
			graph[end][start] = true;

		}

		dfs(graph, V);
		check = new boolean[N + 1];
		sb.append("\n");
		bfs(graph, V);
		System.out.println(sb);
	}

	public static void dfs(boolean[][] graph, int now) {
		check[now] = true;
		sb.append(now+" ");
		for (int i = 1; i <= N; i++) {// 아직방문하지않은 다음 그래프로 이동한다.
			if (graph[now][i] == true && !check[i]) {
				dfs(graph, i);
			}
		}
	}

	public static void bfs(boolean[][] graph, int now) {
		check[now] = true;

		Queue<Integer> que = new LinkedList<>();

		que.add(now);
		sb.append(now+" ");

		while (que.size() != 0) {
			now = que.poll();
			for (int i = 1; i <= N; i++) {
				if (graph[now][i] == true && !check[i]) {
					check[i] = true;
					que.add(i);
					sb.append(i + " ");
				}
			}
		}

	}
}
