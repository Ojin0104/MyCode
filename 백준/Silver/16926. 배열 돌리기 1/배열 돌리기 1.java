import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * temp하나를 사용하여 테두리 한층한층 돌리기 변의 길이가 NXM일때 N과M중작은값을 min이라고할 때   min/2개의 테두리가 있음
 * 0,0~min/2,min/2 300*300*1000
 * 
 * @author 영진
 *
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		int R = Integer.parseInt(st.nextToken());
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < M; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		turnMap(map, R);
		StringBuilder sb =new StringBuilder();
		for (int row = 0; row < N; row++) {
			for (int col = 0; col < M; col++) {
				sb.append(map[row][col]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

	static void turnMap(int[][] map, int R) {// 각줄마다 2(N-2*line)+2(M-2*line)-4 만큼돌면 원상복귀이므로
		int dr[] = { 0, 1, 0, -1 };
		int dc[] = { 1, 0, -1, 0 };// 도는방향대로 방향벡터설정
		int N = map.length;
		int M = map[0].length;
		int temp = 0;
		int min = Math.min(N, M);
		for (int line = 0; line < min / 2; line++) {// 테두리 정하기 밖에서 line만큼 들어간테두리 
			int maxR = 2 * (N - 2 * line) + 2 * (M - 2 * line) - 4;
			int realR = R % maxR;// 한바퀴maxR 의 나머지만큼만 돌면된다.
			
			for (int times = 1; times <= realR; times++) {// 각테두리마다 도는횟수 다름
				int[] point = { line, line }; //갱신포인트
				temp = map[line][line];
				int maxRow = N - line;//line~max 까지 범위로 돎
				int maxCol = M - line;
				int dir = 0;

				while (!(point[0] == line + 1 && point[1] == line)) {// 테두리 한바퀴 돌때까지

					map[point[0]][point[1]] = map[point[0] + dr[dir]][point[1] + dc[dir]];
					point[0] = point[0] + dr[dir];
					point[1] = point[1] + dc[dir];// 다음갱신 포인트 지정
					int next_r = point[0] + dr[dir];// 다음 자리 테두리벗어날시 다음 방향 변경해줌!
					int next_c = point[1] + dc[dir];
					if (next_r < line || next_c < line || next_r >= maxRow || next_c >= maxCol)
						dir = (dir + 1) % 4;

				}
				map[line + 1][line] = temp;
			}
		}
	}
}
