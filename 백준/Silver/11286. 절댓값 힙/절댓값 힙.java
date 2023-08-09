import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 컴퍼레이터에 절대값으로 값을 비교해준다.
 * 
 * @author 영진
 *
 */
public class Main {
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int query = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		// 절대값 오름차순으로 설정
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
			if (Math.abs(a) == Math.abs(b)) {//절대값같을시엔 기존 수 오름차순
				return a - b;
			}
			return Math.abs(a) - Math.abs(b);
		});
        
		for (int index = 0; index < query; index++) {// 쿼리문 처리
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				// 출력
				if (pq.isEmpty()) {
					sb.append(0 + "\n");
				} else {
					sb.append(pq.poll() + "\n");
				}
			} else {
				// 입력
				pq.add(num);
			}

		}
		System.out.println(sb);
	}

}
