import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int[][] dp;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		graph = new ArrayList[size + 1];
		dp = new int[size + 1][2];
		for (int i = 0; i < size + 1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < size - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[s].add(v);
			graph[v].add(s);

		}
		dp(1, -1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}
	//내가 얼리어답터가 될때
	//내가 얼리어답터가 안될때
	static void dp(int now, int parent) {
		dp[now][0] = 0;
		dp[now][1] = 1;
		for (Integer next : graph[now]) {
			if (parent != next) {
				dp(next, now);//dfs로 리프노드까지 들어가면서 돌아오면서 더해줌 
				dp[now][0] += dp[next][1];
				dp[now][1] += Math.min(dp[next][0], dp[next][1]);
			}
		}
	}

}
