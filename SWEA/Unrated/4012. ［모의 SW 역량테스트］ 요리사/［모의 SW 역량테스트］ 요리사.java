import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 재료를 N/2개씩나는 두개의 조합을 찾아낸다. 
 * 2. 해당 조합의 시너지 합을 계산한다. 
 * 3. 시너지합을 계산할때 양쪽모두 계산
 * 
 * @author 영진
 *
 */
public class Solution {
	static int min = 0;
	static int[][] synergy;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());

			min = Integer.MAX_VALUE;
			synergy = new int[N][N];

			for (int row = 0; row < N; row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int col = 0; col < N; col++) {
					synergy[row][col] = Integer.parseInt(st.nextToken());
				}
			}

			int[] leftTeam = new int[N / 2];// 각 팀조합 저장해주는 배열
			int[] rightTeam = new int[N / 2];

			dfs(leftTeam, rightTeam, 0, 0, 1);
			sb.append("#" + test_case + " " + min + "\n");
		}
		System.out.println(sb);
	}

	
	static void dfs(int[] left, int[] right, int l_index, int r_index, int count) {
		if (count == N + 1 && l_index == N / 2 && r_index == N / 2) {// 모든 숫자가 저장되었으면 값비교
			min = Math.min(min, compareSum(left, right));
			return;
		}

		//조합 골라주는 부분
		if (l_index < N / 2) {// 이미 N/2개 꽉채웠을겨우 더이상 xx
			left[l_index] = count;
			dfs(left, right, l_index + 1, r_index, count + 1);
		}

		if (r_index < N / 2) {
			right[r_index] = count;
			dfs(left, right, l_index, r_index + 1, count + 1);
		}
	}

	/**
	 * 구한 조합으로
	 * 맛들의 합을 비교해줌
	 * 
	 * @param left
	 * @param right
	 * @return
	 */
	static int compareSum(int[] left, int[] right) {
		int leftSum = 0;
		int rightSum = 0;

		for (int l = 0; l < N / 2; l++) {
			for (int r = l + 1; r < N / 2; r++) {
				leftSum += synergy[left[l] - 1][left[r] - 1] + synergy[left[r] - 1][left[l] - 1];
				rightSum += synergy[right[l] - 1][right[r] - 1] + synergy[right[r] - 1][right[l] - 1];
			}
		}

		return Math.abs(leftSum - rightSum);
	}
}
