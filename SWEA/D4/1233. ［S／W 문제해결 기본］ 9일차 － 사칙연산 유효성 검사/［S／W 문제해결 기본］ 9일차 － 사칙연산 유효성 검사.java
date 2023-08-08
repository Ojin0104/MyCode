import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * !!리프노드들만 숫자를 가져야한다.
 * 현재사이즈 초과하는 2^n을 만들고
 *  현재사이즈 ~2^n /2까지는 확실히 리프노드이다
 *  (현재사이즈 - 2^n /2 )/2개 는 리프노드가아니므로
 *  2^n /4+(현재사이즈 - 2^n /2 )/2  이후는 모두 숫자여야함
 * @author 영진
 *
 */
public class Solution {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		for(int test_case =1;test_case<=10;test_case++) {
			N=Integer.parseInt(br.readLine());
			
			int leafStart =calcLeafIndex(N);
			int answer= isRight(leafStart,br);
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	static int isRight(int leafStart,BufferedReader br) throws IOException {//맞는지확인
		int answer=1;
		for(int node = 1;node<=N;node++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			st.nextToken();
			if(node<leafStart) {
				
				if(isNum(st.nextToken())){
					answer=0;
				}
			}else {
				if(!isNum(st.nextToken())) {
					answer=0;
				}
			}
		}
		return answer;
	}
	
	static boolean isNum(String str) {//문자열이 숫자인지 검증
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	static int calcLeafIndex(int N) {
		if(N%2==0)return-1;//가장끝 한노드가남게되어 연산이 불가능함
		int size =1;
		while(size<N) {
			size*=2;
		}
		int LeafsParent=(N-size/2)/2;//리프를가진 부모의 해당 레벨에서의 위치
		int LeafIndex=size/4+LeafsParent+1;//해당 레벨까지의 노드개수 + 리프를 가지지않는 노드의 인덱스 
		
		return LeafIndex;
		
	}
}
