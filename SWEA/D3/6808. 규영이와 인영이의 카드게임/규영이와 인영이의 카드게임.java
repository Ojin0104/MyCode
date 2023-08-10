import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * dfs백트랙킹을 통해 인영이가 내는 순서를 결정한다.
 * 결정된후 승패를 예상하여 규영이가 이기는 경우와 지는경우를 계산한다.
 * @author 영진
 *
 */
public class Solution {
	static int win=0;
	static int lose=0;
	static boolean[] check;
	static int[] Guyeong=new int[9];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T =Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int test_case =1;test_case<=T;test_case++) {
			win=0;
			lose=0;
			StringTokenizer st =new StringTokenizer(br.readLine());
			check = new boolean[9]; //체크배열 초기화
			boolean[] Inscard=new boolean[19];//인영이쓸카드 체크하는 배열
			int[] Inyeong= new int[9];
			int[] card = new int[9];//인영이가쓸카드 저장하는 배열
			
			for(int index=0;index<9;index++) {
				Guyeong[index]=Integer.parseInt(st.nextToken());
				Inscard[Guyeong[index]]=true;//규영이에게 배정된 카드 체크
			}
			int num=0;
			for(int index=1;index<19;index++) {//인영이가쓸카드 배열 지정
				if(!Inscard[index]) {
					card[num++]=index;
				}
			}
			
			dfs(card,Inyeong,0);
			sb.append("#"+test_case+" "+win+" "+lose+"\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int[] card,int[] Inyeong,int count) {
		if(count==9) {
			whoWin(Guyeong,Inyeong);
			return;
		}
		
		for(int index=0;index<9;index++) {
			if(check[index])continue;//이미 포함된 숫자이면 중복 xx
			
			Inyeong[count]=card[index];
			check[index]=true;
			dfs(card,Inyeong,count+1);
			check[index]=false;
		}
		
	}
	
	static void whoWin(int[] Guyeong,int[] Inyeong) {
		int score=0;//규영이이기면+ 지면 -
		for(int round=0;round<9;round++) {
			if(Guyeong[round]>Inyeong[round]) {
				score+=Guyeong[round]+Inyeong[round];
			}else if(Guyeong[round]<Inyeong[round]) {
				score-=(Guyeong[round]+Inyeong[round]);
			}
		}
		if(score>0) {
			win++;
		}else if(score<0) {
			lose++;
		}
	}
}
