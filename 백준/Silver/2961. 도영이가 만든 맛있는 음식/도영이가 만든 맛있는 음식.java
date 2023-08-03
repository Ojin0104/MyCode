import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int answer = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {// 신맛은 곱, 쓴맛은 합
		// 재료는 적어도하나 사용
		// 신맛과 쓴맛의 차이 작게
		// 백트랙킹 사용 재료 최대 10개이므로 각 재료를 넣거나 안넣거나 경우 고려시 2^10 시간복잡도 지님
		// 최소한 한개는 포함되어있는지 확인하는 부분 필요
		// 최종맛은 10억보다 작으므로 int 가능
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] flavor = new int[N][2];// 신맛 쓴맛
		for (int dish = 0; dish < N; dish++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			flavor[dish][0] = Integer.parseInt(st.nextToken());
			flavor[dish][1] = Integer.parseInt(st.nextToken());
		}

		dfs(1, 0, 0, flavor);// 신맛, 단맛, 현재 요리 index

		System.out.println(answer);
	}

	static void dfs(int sour, int sweet, int dish, int[][] flavor) {

		// 종료조건
		if (dish >= N) {
			if (sweet != 0) {// 요리 0개면 xx
				answer = Math.min(answer, Math.abs(sour - sweet));
			}
			return;
		}
		int nowSour = flavor[dish][0];
		int nowSweet = flavor[dish][1];
		// 해당 dish 넣는 경우
		dfs(sour * nowSour, sweet + nowSweet, dish + 1, flavor);
		// 해당 dish 안넣는 경우
		dfs(sour, sweet, dish + 1, flavor);
	}
}
