import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1.Ground class로 map을 만든다. 
 * 2. 해당 땅에 영향을 미치는 충전기 중 파워가 쎈순서대로 Ground에 ArrayList로 담아준다. 
 * 3. col,row 순으로 반대로 들어온다.
 * 4. 0초일때도 충전이가능하다.
 * 5. 똑같은 충전기로 충전하는 경우 총 2가지 경우를따진다.
 *   하나의 충전기로 반씩 충전하는 경우
 *   한명이 두번째 충전기를 쓰는 경우
 */
public class Solution {
	static Ground[][] map;
	static int[] dr = { 0, 0, 1, 0, -1 };// x 상 우 하 좌
	static int[] dc = { 0, -1, 0, 1, 0 };// col,row순으로 들어오기때문에 방향 다르게 표시함

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());

			int[] userA = new int[M + 1];
			int[] userB = new int[M + 1];
			st = new StringTokenizer(br.readLine());
			
			//사용자 이동방향 저장 0번째는 0 으로 제자리 이동하게
			for (int index = 1; index <= M; index++) {
				userA[index] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int index = 1; index <= M; index++) {
				userB[index] = Integer.parseInt(st.nextToken());
			}

			Charger[] chargers = new Charger[A];

			for (int index = 0; index < A; index++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int dist = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());

				chargers[index] = new Charger(r, c, dist, power);
			}
			Arrays.sort(chargers, (a, b) -> b.power - a.power);// 충전력이 좋은 충전기 순으로 정렬

			map = new Ground[11][11];
			makeMap();// Ground객체 생성
			for (int index = 0; index < A; index++) {
				setCharger(chargers[index]);// 충전기값 map에 뿌려줌
			}

			int answer = moveMan(userA, userB);
			sb.append("#" + test_case + " " + answer + "\n");
		}

		System.out.println(sb);
	}

	static int moveMan(int[] userA, int[] userB) {
		int[] A = { 1, 1 };
		int[] B = { 10, 10 };
		int answer = 0;
		for (int index = 0; index < userA.length; index++) {// 위치갱신후 충전기 찾기
			A[0] = A[0] + dr[userA[index]];
			A[1] = A[1] + dc[userA[index]];

			B[0] = B[0] + dr[userB[index]];
			B[1] = B[1] + dc[userB[index]];
			Ground Ag = map[A[0]][A[1]];
			Ground Bg = map[B[0]][B[1]];

			Charger Ac = new Charger();
			Charger Bc = new Charger();
			if (!Ag.canCharge.isEmpty()) {
				Ac = Ag.canCharge.get(0);
			}

			if (!Bg.canCharge.isEmpty()) {
				Bc = Bg.canCharge.get(0);
			}
			
			if (Ac != Bc) {// 서로다른 충전기일때
				answer += Ac.power + Bc.power;

			} else {
				int bufferAnswer = 0;
				bufferAnswer = Ac.power;// 하나로 두개중천하는경우

				// A가 두번째크기 충전기 B가 첫번째
				if (Ag.canCharge.size() >= 2) {
					Charger newAc = Ag.canCharge.get(1);
					bufferAnswer = newAc.power + Bc.power;
				}

				// A가 첫번쨰 B가 두번째
				if (Bg.canCharge.size() >= 2) {
					Bc = Bg.canCharge.get(1);
					bufferAnswer = Math.max(bufferAnswer, Ac.power + Bc.power);
				}

				answer += bufferAnswer;

			}

		}
		return answer;
	}

	static void setCharger(Charger charger) {
		int row = charger.r;
		int col = charger.c;
		int dist = charger.dist;

		for (int drow = 0; drow <= dist; drow++) {
			// 행기준 위쪽
			int next_r = row + drow;
			int dcol = 0;
			while (drow + dcol <= dist) {

				int next_c = col + dcol;// 오른쪽

				if (!(next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)) {
					// 범위 안벗어날때만
					map[next_r][next_c].addCharger(charger);
				}
				if (dcol == 0) {
					dcol++;
					continue;
				}
				next_c = col - dcol;// 왼쪽
				if (!(next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)) {
					// 범위 안벗어날때만
					map[next_r][next_c].addCharger(charger);
				}
				dcol++;
			}

			// 아래쪽
			if (drow == 0)
				continue;
			next_r = row - drow;
			dcol = 0;
			while (drow + dcol <= dist) {
				int next_c = col + dcol;// 오른쪽
				
				if (!(next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)) {
					// 범위 안벗어날때만
					map[next_r][next_c].addCharger(charger);
				}
				if (dcol == 0) {
					dcol++;
					continue;
				}
				next_c = col - dcol;// 왼쪽
				if (!(next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)) {
					// 범위 안벗어날때만
					map[next_r][next_c].addCharger(charger);
				}
				dcol++;
			}

		}
	}

	static void makeMap() {
		for (int row = 0; row < 11; row++) {
			for (int col = 0; col < 11; col++) {
				map[row][col] = new Ground();
			}
		}
	}

	static class Ground {
		ArrayList<Charger> canCharge;

		public Ground() {
			this.canCharge = new ArrayList<>();//충전기 정보 저장 (파워가 큰순으로)
		}

		public void addCharger(Charger charger) {
			this.canCharge.add(charger);
		}
	}

	static class Charger {
		int r;
		int c;
		int dist;
		int power;

		public Charger(int r, int c, int dist, int power) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.power = power;
		}

		public Charger() {
			this.power = 0;
		}
	}
}
