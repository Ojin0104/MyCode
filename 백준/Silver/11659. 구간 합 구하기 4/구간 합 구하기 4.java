import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//누적합 사용 sum[i]= 0~i번쨰까지의 합
// sum[i]-sum[j] -> j+1~i까지의 합
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int query = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		int[] nums = new int[N];
		int[] sum = new int[N];// sum[i]= i까지 합
		st = new StringTokenizer(br.readLine());
		for (int index = 0; index < N; index++) {
			nums[index] = Integer.parseInt(st.nextToken());
			if (index != 0) {// 누적합 입력과 동시에 받아줌
				sum[index] = sum[index - 1] + nums[index];
			} else {
				sum[index] = nums[index];
			}
		}

		for (int number = 0; number < query; number++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());

			sb.append(quest(to, from, sum) + "\n");
		}

		System.out.println(sb);
	}

	static int quest(int to, int from, int[] sum) {
		if(to==1) {//0~from-1까지의 합일 경우 
			return sum[from-1];
		}
		return sum[from-1] - sum[to-2];
	}
}
