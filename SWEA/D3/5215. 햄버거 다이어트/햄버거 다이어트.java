
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * dp풀이방식 점화식 i칼로리일때 가장 큰 맛점수를 기록한다. dp[i] 과dp[i-재료칼로리]+재료맛 비교하여 큰점수를 기록한다.
 * 뒤에서부터 갱신을하는데 만약 300cal에 flavor 50이라면 300~limitCal까지 50으로 채워줘야한다. 만약 앞에서 부터
 * 갱신을 한다면 현재 갱신된 값이 뒤에까지 영향을 미치게 되므로 뒤에서부터 갱신!!
 * 
 * @author 영진
 *
 */
public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int limitCal = Integer.parseInt(st.nextToken());

			ingredient[] ingredients = new ingredient[N];
			for (int index = 0; index < N; index++) {
				st = new StringTokenizer(br.readLine());
				int flavor = Integer.parseInt(st.nextToken());
				int calorie = Integer.parseInt(st.nextToken());
				ingredients[index] = new ingredient(flavor, calorie);
			}

			int[] dp = new int[limitCal + 1];// i칼로리일때 가장 큰 맛점수 기록

			for (int index = 0; index < N; index++) {
				for (int cal = limitCal; cal >= ingredients[index].calorie; cal--) {// 최대 칼로리 부터 앞으로가면서 갱신
					dp[cal] = Math.max(dp[cal], dp[cal - ingredients[index].calorie] + ingredients[index].flavor);
				}
			}
			sb.append("#" + test_case + " " + dp[limitCal] + "\n");
		}
		System.out.println(sb);
	}

	static class ingredient {// 맛과 칼로리를 저장하는 class
		int flavor;
		int calorie;

		public ingredient(int flavor, int calorie) {
			this.flavor = flavor;
			this.calorie = calorie;
		}
	}
}

