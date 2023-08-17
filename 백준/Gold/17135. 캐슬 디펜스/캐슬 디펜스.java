import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *  1. 궁수를 배치할때 최대 15열중 3열을 선택하는 조합이므로 455가지의 경우의 수를가진다. 
 *  2. 각n경우의수일때 처치한 적의 수를 구한다.
 *  3. 한 라운드에 궁수는 동시에 하나의 적을 공격할 수 있다. -> 공격당한적m그라운드에 제외 XX
 *  4. 같은 거리의 왼쪽에있는적을 먼저 탐지한다.
 *  5. 한 라운드가 지나고 궁수의 위치를 -1 해준다.
 *  
 */
public class Main {
	static int[] bow;
	static int N;
	static int M;
	static int D;
	static int bowRow;
	static int[][] map;
	static int answer = 0;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		bowRow = N;// 궁수들이 현재 위치한 열
		map = new int[N][M];
		bow = new int[3];

		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		findComb(bow, 0, 0);

		System.out.println(answer);
	}

	static void findComb(int[] bow, int index, int count) {
		if (count == 3) {
			// 궁수 배치완료
			bowRow = N;
			int[][] copy = copyMap();
			play(copy, bow);
			return;
		}
		
		if (index == M) {
			return;
		}

		bow[count] = index;
		findComb(bow, index + 1, count + 1);// 현재 인덱스 궁수위치에 포함

		findComb(bow, index + 1, count);// 현재 인덱스 궁수위치 XX
	}

	static void play(int[][] copy, int[] bow) {
		int arrAnswer = 0;
		while (bowRow > 0) {
			// 각 궁수의 가장가까운 적 찾고 지금의 bowRow로 바꿔줌
			for (int num = 0; num < 3; num++) {
				arrAnswer += findEnemy(copy, bow[num]);
			}
			
			bowRow--;
		}
		//System.out.println(Arrays.toString(bow));
		//System.out.println(Arrays.deepToString(copy));
		answer = Math.max(answer, arrAnswer);
	}

	static int findEnemy(int[][] copy, int me) {
		int dist = 1;
		
		while (dist <= D) {
			
			// dist가 n일때 앞으로 x칸 옆으로 n-x칸이동 왼쪽부터 탐색해 가장 먼저 적있는곳에서 멈춤
			int row = 1;

			while (row <= dist) {// 똑같은 거리일때 row가 클수록 col의 양범위가 크다
				int next_r = bowRow - row;
				int next_c = me - dist+row;//왼쪽 발사지점
				if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {
					row++;
					continue;
				}
					

				if (copy[next_r][next_c] == 1) {
					copy[next_r][next_c] = bowRow+1;//기존의 1이랑 겹칠수 있으므로 +1크게 기록을한다.
					return 1;
				}

				if (copy[next_r][next_c] == bowRow+1) {// 이미 처치된적
					return 0;
				}
				row++;
				
			}
			row--;
			
		
			while (row >0) {// 같은거리 오른쪽은 반대로 row가 큰거부터해야함
				int next_r = bowRow - row;
				int next_c = me + dist-row;//오른쪽발사지점
				if (next_r < 0 || next_c < 0 || next_r >= N || next_c >= M) {
					row--;
					continue;
				}

				if (copy[next_r][next_c] == 1) {
					copy[next_r][next_c] = bowRow+1;
					return 1;
				}

				if (copy[next_r][next_c] == bowRow+1) {// 이미 처치된적
					return 0;
				}
				row--;
			}
			dist++;
		}
		return 0;
	}

	//배열 깊은복사
	static int[][] copyMap() {
		int[][] copyMap = new int[N][M];
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				copyMap[row][col] = map[row][col];
			}
		}

		return copyMap;
	}
}
