import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 조합?
 * @author 영진
 * 1. 5킬로를 우선경우로 하여서 모든 경우를 다 계산한다
 * 
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sugar = Integer.parseInt(br.readLine());

		int maxFive = sugar / 5;
		int maxThree = sugar / 3;
		int answer = 0;
		
		for (int five = maxFive; five >= 0; five--) {
			int sum = five * 5;
			int three = 0;
			if (sum == sugar) {//5kilo짜리로만 구성된경우
				answer = five;
				break;
			}
			
			while (sum < sugar) {//3키로를 추가하는 경우
				three++;
				sum = five * 5 + three * 3;
				if (sum == sugar) {//정답찾으면 비닐봉지 갯수 반환
					answer = five + three;
				}
			}
			
			if (answer != 0)//정답찾으면 break
				break;
		}
		
		
		if (answer == 0) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}
}
