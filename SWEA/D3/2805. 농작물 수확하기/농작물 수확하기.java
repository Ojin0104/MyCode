
import java.util.*;
import java.io.*;


class Solution
{
	// NxN정사각형일때 r행에서 가운데기준 +-r까지 더해줌
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= testCase; test_case++) {
			int N = Integer.parseInt(br.readLine());

			String[] map = new String[N];

			for (int row = 0; row < N; row++) {
				map[row] = br.readLine();
			}
			int answer = sumMap(map);
			sb.append("#" + test_case + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	static int sumMap(String[] map) {// mid를 중심으로 패턴이 있는것을 볼 수 있음
		int answer = 0;
		int mid = map.length / 2;
		for (int row = 0; row < map.length; row++) {// mid를 중심으로 fillSize가 줄어듬
			int fillSize = map.length / 2 - Math.abs(mid - row);// 변 길이 - mid에서의 거리만큼 중심에서 양쪽으로 채워줘야한다.
			for (int col = 0; col < map[0].length(); col++) {
				if (col >= mid - fillSize && col <= mid + fillSize) {
					answer += map[row].charAt(col) - '0';
				}
			}
		}
		return answer;
	}
}