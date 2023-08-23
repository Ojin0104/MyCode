import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1. 백트랙킹으로 1~9개 선택하는 경우의수를 구한다. 
 * 2. total값을 두고 백트랙킹으로 뽑은 노드의 총 인원수를 빼 현재 answer과 비교하여 더 작다면 dfs를 시작한다.
 * (answer보다 큰 차이의 인원수라면 굳이 dfs돌릴 필요가없음)
 * 3. 선택된 노드들이 각각 서브트리가 될 수 있는지 확인한다. 
 * 4. teamA라는 배열을 만들어 경우의수를 구하고 각팀끼리만 이동가능하게하는 dfs를 생성한다.
 * 5. dfs를 통해 check 배열에 방문을 체크하고 teamA의 배열과 같으면 트리가 될수 있음을 알 수 있다.
 * 6. teamA의 false부분을 teamB로 취급하고 4번을 한번더 진행한다.
 * 7. teamA, teamB부분 모두 트리가 된다면 answer에 넣어준다.
 *
 */
public class Main {
	static int[] people;
	static int answer = 1000;//최대 합은 구역인구수 100* N 이므로 1000을 넘을 수 없다.
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
		
		//부분집합을 구하고 부분집합노드들의 트리여부를 체크한다.
		backtracking(1, 0, 0);

		if (answer == 1000) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	
	}

	static void backtracking(int index, int count, int sum) {//부분집합 구하기
		// 1~N/2 개까지만 구하면됨
		if (index == N+1&&count<=N/2&& answer > Math.abs(2 * sum - total)) {// 각 팀이 서로 연결되는지체크
			if (isPossible()) {//서브트리 두개 가질 수 있는지 체크
				answer = Math.abs(2 * sum - total);
			}
			return;
		}

		if (index==N+1||count>N/2) 
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
		if (!checkTree(check, true))//팀들이 서로 연결될 수 없다(트리xx)
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

	//dfs를통해 얻은 check배열과 팀 배열을 비교하여 일치하다면 Tree가 될 수 있다.
	static boolean checkTree(boolean[] check, boolean type) {//teamA와 check배열이 type 이여야함
		for (int idx = 1; idx <= N; idx++) {// teamA의 방문을 체크해 하나의 트리에 존재할 수 있는지 확인
			if ((teamA[idx] != check[idx]) == type)
				return false;
		}
		return true;
	}

	//dfs를통해 연결되어있는 팀에 check를 표시한다.
	static void dfs(int now, boolean[] check, boolean type) {//teamA의 값이 type형일떄 dfs 를 계속진행한다. teamA일떄는 true만 teamB일떄는 false만 dfs 진행

		check[now] = true;

		for (Integer next : graph[now]) {
			if (teamA[next] != type || check[next])
				continue; // 이미방문했거나 다른 트리의 노드일경우
			check[next] = true;
			dfs(next, check, type);
		}
	}

}
