
import java.util.*;
import java.io.*;


class Solution
{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testNum = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= testNum; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int calcSize = Integer.parseInt(st.nextToken());

			int[][] bigMap = new int[size][size];
			for (int row = 0; row < size; row++) {//map정보 넣어줌
				st = new StringTokenizer(br.readLine());
				for (int col = 0; col < size; col++) {
					bigMap[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			int max = calcMax(bigMap, calcSize);
			sb.append("#" + test_case + " " + max + "\n");

		}
		System.out.println(sb);
	}

	static int calcMax(int[][] bigMap, int calcSize) {
		int max = 0;
		for (int row = 0; row <=bigMap.length - calcSize; row++) {// 시작 범위+calcSize가 배열범위 벗어나지 않게
			for (int col = 0; col <= bigMap[0].length - calcSize; col++) {
				max = Math.max(max, sumMap(row, col, bigMap, calcSize));//시작행렬 기준으로 calcSize만큼 더해준다
			}
		}
		return max;
	}

	static int sumMap(int row, int col, int[][] bigMap, int calcSize) {//해당사이즈 맵의 sum값
		int sum = 0;
		for (int dr = 0; dr < calcSize; dr++) {
			for (int dc = 0; dc < calcSize; dc++) {
				sum += bigMap[row + dr][col + dc];
			}
		}
		return sum;
	}
}