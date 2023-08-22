import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1. 모음인지 알 수있는 hashmap 을 만든다
 * 2. dfs 백트랙킹을 통해 모음 최소한개+자음 최소 두개의 조합을 확인한다. 
 * 3. L개의 문자를 구성한 후 2번을 통해 확인을하고 조건에 만족한다면 출력하고 return한다. 
 * 4.조건이만족하지 않다면 return 을한다. 
 * 5. 가능성 있는 암호를 password배열에 받아 자료구조의 중복 생성을 방지한다.
 *
 */
public class Main {
	static char[] password;
	static char[] chs;
	static HashMap<Character, Boolean> map;
	static StringBuilder sb = new StringBuilder();
	static boolean[] check;
	static int L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new HashMap<>();// 모음 저장
		map.put('a', true);
		map.put('e', true);
		map.put('i', true);
		map.put('o', true);
		map.put('u', true);

		st = new StringTokenizer(br.readLine());

		password = new char[L];
		chs = new char[C];
		check = new boolean[C];
		for (int i = 0; i < C; i++) {
			chs[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chs); // 사전순으로 출력하기위해 정렬을 해준다.
		dfs(0, 0, 0, 0);

		System.out.println(sb);

	}

	static void dfs(int r, int c, int index, int num) {// r 은 모음의 갯수, c는 자음의 갯수

		if (num == L && r >= 1 && c >= 2) {// L개의 문자를 가지며 모음이 1개이상 자음이 2개이상일때.

			sb.append(String.valueOf(password));// char 배열 String으로 변환후 append
			sb.append("\n");
			return;
		}
		if (index >= chs.length||num>=password.length)
			return;// L보다 커지면 return

		password[num] = chs[index];
		
		if (map.containsKey(chs[index])) {// 해당위치 문자 사용하는경우
			dfs(r + 1, c, index + 1, num + 1);// 모음일경우
		} else {
			dfs(r, c + 1, index + 1, num + 1);// 자음일 경우
		}
		// 해당위치 문자 사용하지 않는 경우
		dfs(r, c, index + 1, num);

	}
}
