import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int sharks;
	static int smell;
	static int[] dr = { -1, 1, 0, 0 };// 위 아래 왼쪽 오른쪽
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// N 격자 M상어수 k냄새지속시간

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		sharks = Integer.parseInt(st.nextToken());
		smell = Integer.parseInt(st.nextToken());

		Ground[][] map = new Ground[N][N];
		Shark[] sharkArr = new Shark[sharks];
		check = new boolean[sharks+1];
		
		for (int row = 0; row < N; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < N; col++) {
				int sharkNum = Integer.parseInt(st.nextToken());
				map[row][col] = new Ground(0, 0);
				if (sharkNum != 0) {
					Shark shark = new Shark(sharkNum);
					sharkArr[sharkNum-1] = shark;
					map[row][col].setShark(shark);
				}
			}
		}
		st = new StringTokenizer(br.readLine());

		for (int sharkNum = 0; sharkNum < sharks; sharkNum++) {// 상어의 현재방향설정
			sharkArr[sharkNum].setSharkDir(Integer.parseInt(st.nextToken()) - 1);// 인덱스맞추기 위해 -1
		}

		for (int sharkNum = 0; sharkNum < sharks; sharkNum++) {// 상어의 방향마다 우선순위설정
			int[][] wantGo = new int[4][4];
			for (int row = 0; row < 4; row++) {
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < 4; col++) {
					wantGo[row][col] = Integer.parseInt(st.nextToken()) - 1;
				}
			}
			sharkArr[sharkNum].setSharkIndex(wantGo);
		}

		// 만약 1개가 된다면 1 혼자 남는 것이므로 break 하고 시간출력
		int time = 1;

		while (time <= 1000) {
			// 맵에 냄새뿌리고 이미뿌려진 냄새 -1해주기
			check = new boolean[sharkArr.length+1];
			spreadSmell(map);
			// 상어이동하기
			sharkMove(map);
			// 상어개수체크하기 기존에 sharks개가 있는데 sharks없어질때마다 -1해줌
			if (sharks == 1) {
				break;
			}
			
			time++;
			
		}

		if (time == 1001) {
			System.out.println(-1);
		} else {
			System.out.println(time);
		}

	}

	static void sharkMove(Ground[][] map) {// 현재방향에 따른 우선순위 고려해서 움직여줌
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if (map[row][col].shark == null)
					continue;
				boolean flag = false;// 상어움직였는지 확인
				
				Shark nowshark = map[row][col].shark;
				if(check[nowshark.number])continue; //이미 움직인 상어라면 스킵
				check[nowshark.number] = true;
				int[] priority = nowshark.wantGo[nowshark.dir];
				// 1.아무 냄새가 없는 방향
				for (int type : priority) {
					
					int next_r = row + dr[type];
					int next_c = col + dc[type];
					
					if (next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)
						continue;

					if (map[next_r][next_c].smellNum == 0) {// 움직임
						
						flag = true;
						
						if (map[next_r][next_c].shark != null) {// 만약 움직이는 곳에 이미상어가있다면?숫자큰거 사라짐
							sharks--;
							if (nowshark.number < map[next_r][next_c].shark.number) {//상어 잡아먹기
								map[next_r][next_c].setShark(nowshark);
								nowshark.dir = type;
							}
						}else {
							map[next_r][next_c].setShark(nowshark);
							nowshark.dir = type;
						}
						map[row][col].shark = null;
						break;
					}
				}
				if (flag)
					continue;

				// 2.본인 냄새방향
				for (int type : priority) {//본인 냄새방향은 다른 상어가 접근 불가능
					int next_r = row + dr[type];
					int next_c = col + dc[type];

					if (next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)
						continue;

					if (map[next_r][next_c].smellNum == nowshark.number) {// 움직임
							map[next_r][next_c].setShark(nowshark);
							nowshark.dir = type;
							map[row][col].shark = null;
							break;
						}
						
						
					}
				}
			}
		}

	

	static void spreadSmell(Ground[][] map) {
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {// 이미뿌려진냄새 -1

				if (map[row][col].time >= 2) {
					map[row][col].time -= 1;

				} else {
					map[row][col].time = 0;
					map[row][col].smellNum = 0;
				}

				if (map[row][col].shark != null) {// 상어존재시 냄새뿌려줌
					map[row][col].setGround(map[row][col].shark.number, smell);
				}

			}
		}
	}

	static class Shark {
		int number;
		int dir;
		int[][] wantGo;

		public Shark(int number, int dir, int[][] wantGo) {
			this.number = number;
			this.dir = dir;
			this.wantGo = wantGo;
		}

		public Shark(int number) {
			this.number = number;
		}

		public void setShark(int dir, int[][] wantGo) {
			this.dir = dir;
			this.wantGo = wantGo;
		}

		public void setSharkDir(int dir) {
			this.dir = dir;
		}

		public void setSharkIndex(int[][] wantGo) {
			this.wantGo = wantGo;
		}
	}

	static class Ground {
		int smellNum;
		int time;
		Shark shark;

		public Ground(int num, int time) {
			this.smellNum = num;
			this.time = time;
		}

		public void setGround(int num, int time) {
			this.smellNum = num;
			this.time = time;
		}

		public void setShark(Shark shark) {
			this.shark = shark;
		}
	}
}
