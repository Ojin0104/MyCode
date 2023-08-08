import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1.비어있는 칸 중에서 좋아하는 학생 몇칸있는지 2.주변에 빈칸이 가장많은자리 
 * 3.행열 순 N은 최대 20이므로 완전탐색하여도 시간문제가없음을 알 수 있다. 
 * 우선순위가 높은 왼쪽위 부터 행기준으로 탐색을 진행한다.(왼쪽위부터 이므로 같은 조건일경우 전환 XX) 탐색하며
 * 주변에 좋아하는 학생과 빈칸의 갯수를 측정하여 우선순위 기준으로 가장 높은 자리만 저장한다.
 * 
 * @author 영진
 *
 */
public class Main {
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Child[] children = new Child[N * N];
		for (int index = 0; index < N * N; index++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] arr = new int[4];
			for (int i = 0; i < 4; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			children[index] = new Child(num, arr);

		}

		Child[][] map = new Child[N][N];
		for (int index = 0; index < N * N; index++) {//한명씩 자리지정
			selectMap(children[index], map);
		}

		int answer = countingtotalScore(map);//한명씩 점수파악

		System.out.println(answer);
	}

	static int countingtotalScore(Child[][] map) {//행열돌며 findFriendsNum메소드 실행
		int answer = 0;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				answer += findFriendsNum(map, row, col);
			}
		}
		return answer;
	}

	static int findFriendsNum(Child[][] map, int row, int col) {//선호친구 수를 파악하고 점수로변환해주는 메소드

		int[] favor = map[row][col].favor;
		int count = 0;
		for (int dir = 0; dir <= 3; dir++) {// 네방향돌아보기
			int next_r = row + dr[dir];
			int next_c = col + dc[dir];

			if (next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)
				continue;// 범위벗어남
			Child next = map[next_r][next_c];
			for (int child : favor) {
				if (next.num == child) {// 선호친구
					count++;
					break;
				}
			}

		}
		if (count == 2) {//점수변환
			count = 10;
		} else if (count == 3) {
			count = 100;
		} else if (count == 4) {
			count = 1000;
		}
		return count;
	}

	static void selectMap(Child child, Child[][] map) {//앉을자리 지정해주느 메소드
		int friends = -1;
		int blanks = -1;
		int[] position = new int[2];
		;
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if (map[row][col] != null)
					continue; // 이미찬자리 XX
				int[] around = findFriends(map, row, col, child.favor);
				
				if (friends < around[0] || friends == around[0] && blanks < around[1]) {// 선호친구더많은자리
					friends = around[0];
					blanks = around[1];
					position[0] = row;
					position[1] = col;
				}

			}
		}
		map[position[0]][position[1]] = child;// 자리 앉히기
	}

	static int[] findFriends(Child[][] map, int row, int col, int[] favor) {//친구와 빈칸갯수 반환

		int[] answer = new int[2];
		for (int dir = 0; dir <= 3; dir++) {// 네방향돌아보기
			int next_r = row + dr[dir];
			int next_c = col + dc[dir];

			if (next_r < 0 || next_c < 0 || next_r >= map.length || next_c >= map[0].length)
				continue;// 범위벗어남
			Child next = map[next_r][next_c];
			if (next == null) {// 빈자리
				answer[1]++;
				continue;
			}

			for (int child : favor) {
				if (next.num == child) {// 선호친구
					answer[0]++;
					break;
				}
			}

		}
		return answer;
	}

	static class Child {

		int num;
		int[] favor;

		public Child(int num, int[] favor) {
			this.num = num;
			this.favor = favor;
		}
	}
}
