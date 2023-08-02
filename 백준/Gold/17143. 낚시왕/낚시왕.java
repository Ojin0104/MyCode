import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int R;
	static int C;
	static int M;// 상어의 갯수

	static int[] dr = { 0, -1, 1, 0, 0 }; // 위 아래 오른 왼쪽
	static int[] dc = { 0, 0, 0, 1, -1 };

	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Shark[] sharks = new Shark[M + 1];
		int[][] map = new int[R + 1][C + 1];// index로 상어위치 표시!!
		for (int index = 1; index <= M; index++) {// 상어배열에 보관
			st = new StringTokenizer(br.readLine());

			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			map[row][col] = index;// index 로 맵에 상어 저장
			sharks[index] = new Shark(row, col, speed, dir, size, index);

		}

		for (int nowCol = 1; nowCol <= C; nowCol++) {
			catchShark(sharks, map, nowCol);

			sharkMove(sharks, map);

		}
		System.out.println(answer);

	}

	// 아직안움직인 상어와 움직인 상어 부딫힐경우 움직인 상어로 map수정 시켜줌
	// 둘다 움직인 상어라면 크기 작은애 잡아 먹힘
	// 현재 상어 탐색 인덱스보다 작으면 이미 움직인 상어이다.
	static void sharkMove(Shark[] sharks, int[][] map) {
		for (Shark shark : sharks) {
			if (shark == null)
				continue; // 0번쨰인덱스 스킵
			if (shark.size == -1)
				continue; // 죽은상어 스킵
			int row = shark.row;
			int col = shark.col;
			if(map[row][col]==shark.index) {//현재 다른상어가 이위치로 이동하지 않았다면 0으로 초기화해줌(떠날자리)
				map[row][col]=0;
			}
			for (int times = 0; times < shark.speed; times++) {// 한칸씩 이동하며 상어 이동방향을 설정한다.
				int next_r = row + dr[shark.dir];
				int next_c = col + dc[shark.dir];
				if (next_r <= 0 || next_c <= 0 || next_r > R || next_c > C) {// 방향전환후 한칸 이동
					shark.dir = swapDir(shark.dir);
					next_r += dr[shark.dir] * 2;
					next_c += dc[shark.dir] * 2;
				}
				row = next_r;
				col = next_c;
			}
			shark.row = row;
			shark.col = col;

			if (map[row][col] != 0) {// 상어가 이미 존재하는 경우
				if (map[row][col] < shark.index) {// 이미 움직인 상어인경우
					fightShark(shark, sharks[map[row][col]], map);
				} else {
					map[row][col] = shark.index;
				}
			} else {
				map[row][col] = shark.index;
			}
		}
	}

	// 큰사이즈 상어가 작은애 잡아먹는다.
	static void fightShark(Shark sh1, Shark sh2, int[][] map) {
		if (sh1.size > sh2.size) {
			sh2.deadShark();
			map[sh1.row][sh1.col] = sh1.index;
		} else {
			sh1.deadShark();
			map[sh1.row][sh1.col] = sh2.index;
		}
	}

	// 상어가 격자끝에 부딪힐때 방향을 바꿔준다.
	static int swapDir(int dir) {
		if (dir == 1 || dir == 3) {
			return dir + 1;
		} else
			return dir - 1;
	}

	static void catchShark(Shark[] sharks, int[][] map, int man) {
		for (int row = 1; row <= R; row++) {
			if (map[row][man] != 0) {// 상어를 잡음
				answer += sharks[map[row][man]].size;
				sharks[map[row][man]].deadShark();
				map[row][man] = 0;
				return;
			}
		}
	}

	static class Shark {// size=-1이면 죽은상어
		int size;
		int speed;
		int dir;
		int row;
		int col;
		int index;

		public Shark(int row, int col, int speed, int dir, int size, int index) {
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.index = index;
		}

		public void deadShark() {
			this.size = -1;
		}
	}
}
