import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 1. query클래스 배열을 두고 순열을 뽑는다 K는 최대 6개 이므로 6!의 경우의수 2. 기존배열은 유지한채로
 *         새로운 배열을 복사해 놓고 복사한 배열을 쿼리에 맞게 회전한다. 3. 회전되어있는 배열의 최솟값을 찾는다.
 */
public class Main {
	static boolean[] check;
	static int[][] map;
	static int[][] copyMap;
	static Query[] querys;
	static int min = Integer.MAX_VALUE;
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		copyMap = new int[N][M];
		querys = new Query[K];// 쿼리배열 저장

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		for (int query = 0; query < K; query++) {// 쿼리배열 입력
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());

			querys[query] = new Query(row - 1, col - 1, size);
		}

		int[] order = new int[K];
		check = new boolean[K];
		dfs(order, 0);// 0~K-1번까지 순열을 구한다.

		System.out.println(min);
	}

	static void dfs(int[] order, int count) {// order배열안에 순서 저장
		if (count == order.length) {

			// map 복사해줌
			copyMap();
			// 쿼리대로 배열돌려주는 함수
			rotateMat(order);
			// 최소값구해주는 함수
			min = Math.min(min, calcMin());

			return;
		}

		for (int num = 0; num < order.length; num++) {
			if (check[num])
				continue;// 이미 순열에 포함되어있는 경우

			check[num] = true;
			order[count] = num;

			dfs(order, count + 1);

			check[num] = false;
		}

	}

	static int calcMin() {
		int answer = Integer.MAX_VALUE;
		for (int row = 0; row < map.length; row++) {
			int line = 0;
			for (int col = 0; col < map[0].length; col++) {
				line += copyMap[row][col];
			}
			answer = Math.min(answer, line);
		}
		return answer;
	}

	static void rotateMat(int[] order) {// 쿼리만큼 회전시켜준다.

		for (int q : order) {
			Query now = querys[q];
			int row = now.row;
			int col = now.col;
			for (int layer = 1; layer <= now.size; layer++) {

				int temp = copyMap[row - layer][col - layer];
				// 왼쪽 돌리기
				for (int r = row - layer; r < row + layer; r++) {
					copyMap[r][col - layer] = copyMap[r + 1][col - layer];
				}
				// 아래쪽돌리기
				for (int c = col - layer; c < col + layer; c++) {
					copyMap[row + layer][c] = copyMap[row + layer][c + 1];
				}

				// 오른쪽돌리기
				for (int r = row + layer; r > row - layer; r--) {
					copyMap[r][col + layer] = copyMap[r - 1][col + layer];
				}

				
				
				// 위쪽돌리기
				for (int c = col + layer; c > col - layer; c--) {
					copyMap[row - layer][c] = copyMap[row - layer][c - 1];
				}

				copyMap[row - layer][col - layer + 1] = temp;

			}

		}
	}

	static void copyMap() {// 돌아간 맵 원상복구
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				copyMap[row][col] = map[row][col];
			}
		}
	}

	// row와 col을 중심점으로 잡고 중심점과 size만큼떨어져있는 테두리를 회전한다고 생각
	static class Query {
		int row;
		int col;
		int size;

		public Query(int row, int col, int size) {
			this.row = row;
			this.col = col;
			this.size = size;
		}
	}
}
