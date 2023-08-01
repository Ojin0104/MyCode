import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[] nums = new int[M];// 선택된 숫자들
		check = new boolean[N + 1];// 숫자가 선택되었는지 확인
		dfs(0, nums);// (선택된숫자갯수,선택된숫자배열)

		System.out.println(sb);
	}

	static void dfs(int count, int[] nums) {// (선택된숫자갯수,선택된숫자배열)
		if (count == M) {// 원하는 개수만큼 선택시 sb에 출력값 저장
			for (int num : nums) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}

		for (int addNum = 1; addNum <= N; addNum++) {// 1~N까지 숫자들 선택해주기

			if (check[addNum])
				continue;// 이미 선택된 것이라면 건너뛰기

			check[addNum] = true;
			nums[count] = addNum;
			dfs(count + 1, nums);
			check[addNum] = false;// true로 돌고난후 false인 경우로 탐색
		}

	}
}