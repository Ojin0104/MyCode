import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 100X100배열을만든다 
 * 검은도화지 10X10X100만큼 영역모두 1로바꿔준다. 
 * 100X100을 탐색하면서 더해준다.
 * 
 * @author 영진
 *
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		int[][] paper = new int[100][100];
		for (int index = 1; index <= count; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());

			fillPaper(paper, row, col);
		}

		int answer = countArea(paper);

		System.out.println(answer);
	}

	//검은영역을 1로 표시해준다.
	static void fillPaper(int[][] paper, int row, int col) {
		for (int r = row; r < row + 10; r++) {
			for (int c = col; c < col + 10; c++) {
				paper[r][c] = 1;
			}
		}
	}

	//배열돌며 더해준다.
	static int countArea(int[][] paper) {
		int answer = 0;
		for (int r = 0; r < paper.length; r++) {
			for (int c = 0; c < paper[0].length; c++) {
				answer += paper[r][c];
			}
		}
		return answer;
	}
}
