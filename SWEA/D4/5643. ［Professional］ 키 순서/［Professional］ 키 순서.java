
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 *  1. 확실하게 자신의 키가 몇 번째인지 알 수 있는 경우 -> 노드들의 연관관계를 모두 아는 노드여야한다. 
 *  2.dfs를 돌려 각 노드에 대해 연관관계를 가지는 수를 계산한다. 
 *  3. 연관관계를 N-1개 가지는 경우 확실한 순서를 아는 학생이다.
 *  4. T= 15, N = 500이하이므로 N^3 까지도 충분히 가능하므로 시간적으로 여유롭다.
 */
public class Solution {
	static int[] count;
	static boolean[] check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			// 나보다 작은 학생수 저장
			ArrayList<Integer>[] nodes = new ArrayList[N + 1];
			count = new int[N + 1];
			check = new boolean[N + 1];
			// 해당학생보다 큰 학생들 저장
			for (int init = 0; init < nodes.length; init++) {// 리스트 초기화
				nodes[init] = new ArrayList<Integer>();
			}
			for (int query = 0; query < M; query++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken());
				int big = Integer.parseInt(st.nextToken());

				nodes[small].add(big);

			}
			
			////////////////////init 완료///////////////////////////

			for (int index = 1; index < N + 1; index++) {//각 노드들 마다 dfs를 돌려 몇개의 노드와 연관관계를 가지는 지 확인한다.
				Arrays.fill(check, false);
				check[index] = true;
				count[index] += dfs(nodes, index, 0);
			}
			
			int answer = 0;
			for (int index = 1; index < N + 1; index++) {//for문을 돌려 N-1개의 관계를 가지는 노드를 찾아낸다
				if (count[index] >= N - 1) {
					answer++;
				}
			}

			sb.append("#" + test_case + " " + answer + " \n");

		}

		System.out.println(sb);
	}

	static int dfs(ArrayList<Integer>[] nodes, int index, int sum) {
		count[index]++;
		for (Integer next : nodes[index]) {
			if (check[next])
				continue;
			check[next] = true;//방문노드 체크
			sum += dfs(nodes, next, 1);

		}

		return sum;
	}

}
