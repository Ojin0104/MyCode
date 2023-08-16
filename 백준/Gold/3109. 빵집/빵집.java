import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 각 칸을 지나는 파이프는 단 하나. 
 * 각칸에서는 오른쪽방향으로 세방향에 놓을수 있다. 
 * *위칸부터 연결 최대한 할 수록좋음*
 *  1. 0번쨰 열에서 N-1번쨰 열까지 연결하는 방법 순서대로 위에껄 연결시키면됨
 *  2. 오른쪽위 오른쪽 오른쪽아래 세가지 경우의수로 하고 가다가 세곳 모두 못갈시에 dfs돌아오면서 방문체크를 없앤다(그냥 그열버림)
 * 
 */
public class Main {
	static int answer = 0;
	static boolean flag;
	static int C;
	static int R;
	static char[][] map;
	static int[]rowlimit;
	static int startRow;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		rowlimit = new int[C];
		
		for (int row = 0; row < R; row++) {
			String line = br.readLine();
			for (int col = 0; col < C; col++) {
				map[row][col] = line.charAt(col);
			}
		}

		for (int row = 0; row < R; row++) {//위에열 부터 하나씩 dfs로 구해줌 어차피 도착 열에서 위에행부터 차곡차곡 넣어야 최대값이 되기 때문에
			flag = false;
			dfs(row, 1);
		}
		System.out.println(answer);
	}

	static void dfs(int row, int col) {
		if (col == C - 1) {
			if(row<rowlimit[col])//이미 파이프연결된경우
				return;
			rowlimit[col]=row+1;
			flag = true;
			answer++;
			return;
		}
		

		for (int dr = -1; dr <= 1; dr++) {//왼쪽 위부터 아래까지 뻗어줌
			int next_r = row + dr;
			if(next_r<rowlimit[col])continue;
			if (next_r < 0||next_r>=R)
				continue;
			
			if (map[next_r][col] == 'x')//이미 벽이나 파이프가 있는 경우
				continue;

			rowlimit[col]=next_r+1;
			dfs(next_r, col + 1);

			if(flag)return;
		}
	}
}
