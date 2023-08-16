import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * @author 영진
 *1.재귀를 돌며 재귀 들어갈때마다 ( 해당 지역이 모두 같은 숫자이면 숫자표시 그 후 )작성
 */
public class Main {
	static StringBuilder sb= new StringBuilder();
	static char[][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		
		for(int row=0;row<N;row++) {//기존 맵 정보저장!!
			String line = br.readLine();
			for(int col=0;col<N;col++) {
				map[row][col] = line.charAt(col);
			}
		}
		
		compressMap(0,0,N,N);
		System.out.println(sb);
	}
	
	static void compressMap(int s_r,int s_c,int e_r,int e_c) {
		//다 같은 숫자인지 확인
		if(mapCheck(s_r,s_c,e_r,e_c)) {//같다면 값 sb에 저장후 return;(압축)
			sb.append(map[s_r][s_c]);
			return;
		}
		//다른숫자 있다면 (생성후 재귀 진입
		sb.append("(");
		
		//4사분면으로 각각 재귀 실행
		int mid_r=(s_r+e_r)/2;
		int mid_c=(s_c+e_c)/2;
		//1사분면
		compressMap(s_r,s_c,mid_r,mid_c);
		//2사분면
		compressMap(s_r,mid_c,mid_r,e_c);
		//3사분면
		compressMap(mid_r,s_c,e_r,mid_c);
		//4사분면
		compressMap(mid_r,mid_c,e_r,e_c);
		
		sb.append(")");
	}
	
	static boolean mapCheck(int s_r,int s_c,int e_r,int e_c) {//해당범위 모두 같은 값인지 확인하는 메소드
		char check=map[s_r][s_c];
		for(int row=s_r;row<e_r;row++) {
			for(int col=s_c;col<e_c;col++) {
				if(map[row][col]!=check) {//다른값이 존재
					return false;
				}
			}
		}
		return true;
	}
}
