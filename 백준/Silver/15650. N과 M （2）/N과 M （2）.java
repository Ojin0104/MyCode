import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int M;
	static int N;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = new int[M];//M 개 선택한 배열
		dfs(1, 0, answer);
		System.out.println(sb);
	}

	static void dfs(int now, int num, int[] answer) {

		if (num == M) {//M개를 선택했을 경우 sb에 넣고 return
			for(int row=0;row<answer.length;row++) {
				sb.append(answer[row]+" ");
			}
			sb.append("\n");
			return;
		}
		if (now == N + 1)//숫자범위 넘어갔을 경우 return
			return;
		answer[num]=now;
		dfs(now + 1, num + 1, answer);//선택한 경우
		dfs(now + 1, num, answer);//선택안한 경우
	}
}
