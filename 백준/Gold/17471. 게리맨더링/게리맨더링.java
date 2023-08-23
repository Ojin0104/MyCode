import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1. 백트랙킹으로 1~9개 선택하는 경우의수를 구한다. 
 * 2. total값을 두고 백트랙킹으로 뽑은 노드의 인원수를 빼 현재 answer과 비교하여 dfs를 시작할지 결정한다.
 * (answer보다 큰 차이의 인원수라면 굳이 dfs돌릴 필요가없음)
 * 3. 선택된 노드들이 각각 서브트리가 될 수 있는지 확인한다. 
 * 4. teamA라는 배열을 만들어 경우의수를 구하고 각팀끼리만 이동가능하게하는 dfs를 생성한다.
 * 5. dfs를 통해 check 배열에 방문을 체크하고 teamA의 배열과 같으면 트리가 될수 있음을 알 수 있따.
 * 6. teamA의 false부분을 teamB로 취급하고 4번을 한번더 진행한다.
 * 7. teamA, teamB부분 모두 트리가 된다면 answer에 넣어준다.
 *
 */
public class Main {
	static int[] people;
	static int answer = 1000;
	static ArrayList<Integer>[] graph;
	static boolean[] teamA;
	static int N;
	static boolean flag; // 해당팀이 트리로 구성될 수 있는지
	static int count;
	static int total = 0;/// 인구수 총합을 저장

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		people = new int[N + 1];
		teamA = new boolean[N + 1];

		graph = new ArrayList[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int idx = 1; idx <= N; idx++) {// 각 지역의 인구수를 지정
			people[idx] = Integer.parseInt(st.nextToken());
			total += people[idx];
			graph[idx] = new ArrayList<Integer>();
		}

		for (int from = 1; from <= N; from++) {// 그래프 생성
			st = new StringTokenizer(br.readLine());
			int edges = Integer.parseInt(st.nextToken());

			for (int edge = 0; edge < edges; edge++) {
				int to = Integer.parseInt(st.nextToken());

				graph[to].add(from);
				graph[from].add(to);

			}
		}
		count = 0;
		// check[idx]=true;
		backtracking(1, 0, 0);

		if (answer == 1000) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
		// check[idx]=false;
	}

	static void backtracking(int index, int count, int sum) {
		// 1~N/2 개까지만 구하면됨
		if (index == N+1 &&count<=N/2&& answer > Math.abs(2 * sum - total)) {// 각 팀이 서로 연결되는지체크
			//for(int i=1;i<=N;i++) {
				//if(teamA[i])System.out.print(i+" ");
			//}
			//System.out.println();
			if (isPossible()) {
				answer = Math.abs(2 * sum - total);
			}
			return;
		}

		if (count > N / 2 || index > N)
			return;

		teamA[index] = true;
		backtracking(index + 1, count + 1, sum + people[index]);
		teamA[index] = false;
		backtracking(index + 1, count, sum);
	}

	static boolean isPossible() {
		// team A와 아닌것들이 서로 트리여야한다.
		boolean[] check = new boolean[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			if (teamA[idx]) {
				dfs(idx, check, true);// teamA인트리
				break;
			}
		}
		if (!checkTree(check, true))
			return false;

		check = new boolean[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			if (!teamA[idx]) {
				dfs(idx, check, false);// teamA가 아닌 트리
				break;
			}
		}

		return checkTree(check, false);

	}

	static boolean checkTree(boolean[] check, boolean type) {
		for (int idx = 1; idx <= N; idx++) {// teamA의 방문을 체크해 하나의 트리에 존재할 수 있는지 확인
			if ((teamA[idx] != check[idx]) == type)
				return false;
		}
		return true;
	}

	static void dfs(int now, boolean[] check, boolean type) {

		check[now] = true;

		for (Integer next : graph[now]) {
			if (teamA[next] != type || check[next])
				continue; // 이미방문했거나 다른 트리의 노드일경우
			check[next] = true;
			dfs(next, check, type);
		}
	}

}
