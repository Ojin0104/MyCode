import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1.다잌스트라 문제 
 * 2. 한점을 기준으로 연결된 경로 가중치와 연결되지 않았아면 INF로 배열을 만든다. 
 * 3. 우선순위큐에 한점에서 다른점으로 가는 가중치를 저장해두고 가중치가 낮은 순서로 정렬한다. 
 * 4. 큐에 값이 없을떄까지 큐에서 값을빼(한점에서 해당점으로 갈수 있는 가장 낮은 가중치) 해당 노드에서 다른노드를 갈때 현재보다 빠르게 갈 수 있는지 체크한다. 
 * 5. 만약 빠르게 갈 수 있다면 우선순위 큐에 넣어준다
 */
public class Main {
	static ArrayList<Edge>[] graph;
	static int[] shortestDist;
	static int V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		graph = new ArrayList[V + 1];
		shortestDist = new int[V + 1];
		for (int idx = 1; idx <= V; idx++) {
			graph[idx] = new ArrayList<Edge>();
		}

		int K = Integer.parseInt(br.readLine());

		for (int idx = 0; idx < E; idx++) {// 그래프 생성
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			int dist = Integer.parseInt(st.nextToken());

			graph[start].add(new Edge(end, dist));
		}

		dikstra(K);
		for (int idx = 1; idx <= V; idx++) {
			if (shortestDist[idx] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(shortestDist[idx] + "\n");
			}
		}
		System.out.println(sb);
	}

	static void dikstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> e1.dist - e2.dist);// 거리가까운순
		//boolean[] check = new boolean[V + 1];
		pq.add(new Edge(start, 0));
		Arrays.fill(shortestDist, Integer.MAX_VALUE);
		shortestDist[start] = 0;
		//int size=0;
		while (!pq.isEmpty()) {
			Edge now = pq.poll();
			if(now.dist>shortestDist[now.node])continue;
			//if(check[now.node])continue;
			//size++;
			//if(size==V)return;
			//check[now.node] = true;
			//shortestDist[now.node] = now.dist;
			for (Edge next : graph[now.node]) {
			//	if (check[next.node])
				//	continue;
				if (shortestDist[next.node] > shortestDist[now.node] + next.dist) {
					shortestDist[next.node] = shortestDist[now.node] + next.dist;
					pq.offer(new Edge(next.node, shortestDist[next.node]));
				}
			}
		}
	}

	static class Edge {
		int node;
		int dist;

		public Edge(int node, int dist) {
			this.node = node;
			this.dist = dist;
		}
	}
}
