import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1. 모든 경우의 수를 계산했을때 9!(순서정하는 경우의수)*50(이닝의 최대수) = 약1800만 으로 완전탐색 가능
 * 2. 타자의 순열을 찾는다. 순열을 찾을때 4번쨰는 0(1번타자)으로고정
 * 3. 각순열의 결과를 구현한다.
 */
public class Main {
	
	static int N;
	static int max;
	
	static int[][] result; //각 선수가 이닝별 얻는 결과
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		result = new int[N][9]; //N이닝에 col 번 타자가 친 것
		
		for(int inning=0;inning<N;inning++) {//타자 기록 정보 저장
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			for(int  turn=0;turn<9;turn++) {
				result[inning][turn]=Integer.parseInt(st.nextToken());
			}
			
		}
		
		int[] order = new int[9];
		//order[3]=0;
		boolean[] check = new boolean[9];
		makeOrder(0,order,check);
		
		System.out.println(max);
	}
	
	static void makeOrder(int now,int[] order,boolean[] check) {
		
		if(now==9) {
			//점수확인
			max=Math.max(max, calcPoint(order));
			
			return;
		}
		
		for(int player=1;player<9;player++) {
			if(check[player])continue;
			order[now]=player;
			check[player] = true;
			if(now==2) {//4번째 배열의 숫자 정할때는 +2로 넘ㄱ겨줌
				makeOrder(now+2,order,check);
			}else
				makeOrder(now+1,order,check);
			check[player]= false;
		}
	}
	
	static int calcPoint(int[] order) {
		int out=0;
		boolean[] base=new boolean[3];
		int score=0;
		int turn=-1;
		for(int inning=0;inning<N;inning++) {
			out =0;
			//아웃시에 모든 베이스 false;
			Arrays.fill(base, false);
			while(true) {
				
				turn= (turn+1)%9;//다음차례
				int hit = result[inning][order[turn]];
				if(hit ==0) {
					out++;
					if(out==3) 
						break;
					
				}else {
					//뒤에베이스 부터 앞으로떙김
					for(int idx=2;idx>=0;idx--) {
						if(base[idx]) {//앞으로떙겨줌
							if(idx+1+hit>=4) {
								score++;
							}else {
								base[idx+hit]=true;
							}
							base[idx]=false;
							
						}
					}
					if(hit==4) {//홈런친경우{
						score++;
					}
					else
						base[hit-1]=true;
				}
				
			}
		}
		
		return score;
	}

}
