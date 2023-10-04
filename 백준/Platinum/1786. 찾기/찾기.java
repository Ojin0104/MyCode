import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author 영진
 * 1. KMP알고리즘을 사용한다.
 * 2. PI배열을 만든다 - 1~N번째 까지 for문을 돌려 접두사 접미사의 최장길이를 구한다.
 * 3. 앞에서 부터 N 번 비교하여 같은 문자열이 존재할때마다 ArrayList에 숫자를 저장한다.
 *
 */
public class Main {
	static int arrLength;
	static ArrayList<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		char[] T = br.readLine().toCharArray();
		
		char[] P = br.readLine().toCharArray();
		
		arrLength = P.length;
		int[] pi = new int[arrLength];
		
		//pi배열 생성
		makePi(pi,P);
		//
		KMP(T,P,pi);
		
		System.out.println(answer.size());
		
		for(Integer num : answer) {
			System.out.print(num+" ");
		}
		
	}
	public static void KMP(char[] T,char[] P,int[] pi) {
		
		//현재 비교대상
		int Ppointer=0;
		
		for(int Tpointer=0;Tpointer<T.length;Tpointer++) {
			
			while(Ppointer>0 && T[Tpointer]!=P[Ppointer]) {
				Ppointer = pi[Ppointer-1];
			}
		//	System.out.println(Tpointer + " "+Ppointer);
			
			if(T[Tpointer]==P[Ppointer]) {
				if(Ppointer ==arrLength-1) {
					answer.add(Tpointer-arrLength+2);
					Ppointer = pi[Ppointer];
				}else {
					Ppointer++;
				}
			}
//			if(T[Tpointer]==P[Ppointer]) {
//				Ppointer++;
//				
//			}else {
//				if(Ppointer != 0)//0이라면 다음 검색시 0 그대로
//				Ppointer = pi[Ppointer-1];//아니라면 이전 index의 최대 접미사 접두사 중복 갯수 위치로 갱신
//			}
//			
//			if(Ppointer ==arrLength) {//일치할 경우
//				Ppointer=pi[Ppointer-1];// 이전 index의 최대 접미사 접두사 중복 갯수 위치로 갱신 ( abababa 에서 aba찾는 경우)
//				answer.add(Tpointer-arrLength+2);
//			}
		}
		
		
	}
	
	public static void makePi(int[] pi,char[] P) {
		int compare = 0;
		for(int index=1;index<arrLength;index++) {
			//비교 시작위치를 지정해줌
			while(compare>0&&P[compare]!=P[index]) {
				compare =pi[compare-1];
			}
			
			if(P[compare]==P[index]) {
				compare++;
				pi[index]=compare;
				}
		}
	}
}
