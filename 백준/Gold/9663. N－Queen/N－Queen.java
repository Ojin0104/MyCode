import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 
 * @author 영진
 *  1. 퀸은 같은 행과 열, 대각선 모두를 갈 수 있다.
 *  2. 백트래킹을통해 행마다 하나 씩 놓으며 해당열에 놓을 수 있는지 확인하고 놓는다.
 *  3. 모두 놓았다면 +1을해준다.
 */
public class Main {
	static int answer = 0;
	static int N;
	static boolean[][] check;
	static int[] dr = { -1, -1 };
	static int[] dc = { 1, -1 };
	static boolean[] colCheck;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		check = new boolean[N][N];
		colCheck= new boolean[N];
		
		setQueen(0, 0);
		System.out.println(answer);
	}

	static void setQueen(int nowRow, int count) {// 각행에 놓여지는지확인

		if (count == N) {

			answer++;
			return;
		}

		for (int col = 0; col < N; col++) {

			if (isAvailable(nowRow, col)) {
				colCheck[col]=true;
				check[nowRow][col] = true;
				setQueen(nowRow + 1, count + 1);
				check[nowRow][col] = false;
				colCheck[col]=false;
			}
		}

	}

	static boolean isAvailable(int row, int col) {// 열과 대각선을 확인

		// 열체크
		if(colCheck[col])return false;

		for (int dir = 0; dir < 2; dir++) {// 대각선 4방향 모두 탐색
			for (int dist = 1; dist < N; dist++) {
				int next_r = row + dr[dir] * dist;
				int next_c = col + dc[dir] * dist;

				if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= N)
					break;// 범위벗어나는경우

				if (check[next_r][next_c]) {// 대각선 방향 퀸 존재하는 경우
					return false;
				}
			}
		}
		
		return true;
	}

}
