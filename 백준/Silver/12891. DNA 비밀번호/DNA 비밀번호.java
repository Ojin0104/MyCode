import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static char[] base= {'A','C','G','T'};
	static int count=0;
	public static void main(String[] args) throws IOException {
		//투포인터 사용 
		//1. 처음에 0~ 부분 문자열길이만큼의 ACGT포함갯수를 측정
		//2. 뒤로가면서 앞에꺼 문자열 뺴주고 뒤에꺼 문자열 더해줌 
		//3. 각 경우의 수에서 최소 문자열 보다 많다면 +1
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P= Integer.parseInt(st.nextToken());
		
		String Minho = br.readLine();
		HashMap<Character,Integer> standard = new HashMap<>(); // 최소기준 저장
		
		st = new StringTokenizer(br.readLine());
		for(char now:base) {//기준 저장
			standard.put(now,Integer.parseInt(st.nextToken()));
		}
		findKey(standard,Minho,P);
		
		System.out.println(count);
	}
	
	static void findKey(HashMap<Character,Integer>standard, String Minho,int P) {
		HashMap<Character,Integer> nowKey=new HashMap<Character,Integer>();
		for(char now:base) {//기본상태 지정
			nowKey.put(now, 0);
		}
		
		for(int index =0 ;index<P;index++) {
			char nowChar = Minho.charAt(index);
			nowKey.put(nowChar, nowKey.getOrDefault(nowChar, 0)+1);//현재글자 hashmap에 넣어줌 만약 key가없다면 만들어줌
		}
		
		int left=-1;
		int right=left+P;
		isRight(nowKey,standard);
		while(right<Minho.length()-1) {
			left++;
			right++;
			
			//앞에문자열 -1
			nowKey.put(Minho.charAt(left), nowKey.getOrDefault(Minho.charAt(left), 0)-1);//앞에 문자열 빼주기
			//뒤에 문자열 +1
			nowKey.put(Minho.charAt(right), nowKey.getOrDefault(Minho.charAt(right), 0)+1);//뒤에 문자열 추가
			
			//조건 만족하는지 check
			isRight(nowKey,standard);
		}
			
		
	}
	static boolean isRight(HashMap<Character,Integer> now,HashMap<Character,Integer> standard) {
			for(char check: base) {
				if(now.getOrDefault(check,0)<standard.get(check)) {//기준 넘지못하면 비밀번호 조건 만족 XX
					return false;
				}
			}
			count++;
			return true;
	}
}
