import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N이 1000이므로 n^2까지 충분히가능 완전탐색으로 M을초과하지않는 과자 무게의 합을 구한다.
 * 
 * @author 영진
 *
 */
public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			//입력부분
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int limit = Integer.parseInt(st.nextToken());
			int[] snacks = new int[num];
			st = new StringTokenizer(br.readLine());
			for (int index = 0; index < num; index++) {
				snacks[index] = Integer.parseInt(st.nextToken());
			}

			int max = maxSnack(snacks, limit);// 두봉지의최대합
			sb.append("#" + test_case + " " + max + "\n");
		}
		System.out.println(sb);
	}

	static int maxSnack(int[] snacks, int limit) {// 이중for문으로 반복해줌!
		int max = 0;
		int sum = 0;// 과자두봉지합
		for (int left = 0; left < snacks.length - 1; left++) {
			for (int right = left + 1; right < snacks.length; right++) {
				sum = snacks[left] + snacks[right];
				if (sum <= limit && sum > max) {
					max = sum;
				}
			}
		}
		if (max == 0)
			return -1;// 방법이없는경우
		return max;
	}
}
