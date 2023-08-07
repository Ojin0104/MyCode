import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		// 해쉬로 삭제된 값확인후 삭제되었으면 +1해준다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] answer = yosepus(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		for (int index = 0; index < answer.length; index++) {
			sb.append(answer[index]);
			if (index != answer.length - 1) {
				sb.append(", ");
			}
		}
		sb.append(">");
		System.out.println(sb);
	}

	static int[] yosepus(int N, int plus) {
		int[] answer = new int[N];
		ArrayDeque<Integer> que = new ArrayDeque<>();
		for (int num = 1; num <= N; num++) {
			que.addLast(num);
		}
		int count = 0;
		int index = 0;
		while (!que.isEmpty()) {
			int now = que.pollFirst();
			count++;
			if (count == plus) {
				answer[index] = now;
				count = 0;
				index++;
			} else {
				que.addLast(now);
			}
		}

		return answer;

	}
}
