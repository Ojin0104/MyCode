import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *  1. 각 죠별리그의 경우의 수는 3^15 
 *  2. 각 경우의 수를 다해 
 *  
 */
public class Main {
	static int[][] status;
	static int[][] backtrack;
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		status= new int[6][3];//이기고 비기고 지는 경우의수 저장
		
		for (int num = 1; num <= 4; num++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			backtrack= new int[6][3];
			flag=false;
			int match=0;
			for (int team = 0; team < 6; team++) {
				for (int type = 0; type < 3; type++) {
					status[team][type] = Integer.parseInt(st.nextToken());
					match+=status[team][type];
				}
			}
			
			if(match<=30) {
				isAvailable(0,0,1);
			}
			
			if(flag) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
			
		}
		
		System.out.println(sb);
	}
	//경기는 총 15번
	static void isAvailable(int now,int countryA,int countryB) {
		if(now==15) {
			//if(compareArr())
			flag=true;
			return;
		}
		
		if(flag)return;//정답을찾은경우  바로 return 해줘서 시간단축
		
		//다음나라를 지정해주는 로직
		int nextA =countryA;
		int nextB=0;
		if(countryB<5) {//나라는 총 6개이므로 범위넘어갈시 A나라를 다음나라로 바꿔줌
			nextB=countryB+1;
		}else {
			nextA=countryA+1;
			nextB=nextA+1;
		}
		
		//countryA가이긴경우
		backtrack[countryA][0]++;
		backtrack[countryB][2]++;
		if(backtrack[countryA][0]<=status[countryA][0]&&backtrack[countryB][2]<=status[countryB][2])//각 이기고 비기고 지는 경우에대해 현재 경우보다 커지는 순간 그 백트랙킹은 더들어갈 필요가 없음
			isAvailable(now+1,nextA,nextB);
		backtrack[countryA][0]--;
		backtrack[countryB][2]--;
		
		//비긴경우
		backtrack[countryA][1]++;
		backtrack[countryB][1]++;
		if(backtrack[countryA][1]<=status[countryA][1]&&backtrack[countryB][1]<=status[countryB][1])
			isAvailable(now+1,nextA,nextB);
		backtrack[countryA][1]--;
		backtrack[countryB][1]--;
		
		//countryB가이긴경우
		backtrack[countryB][0]++;
		backtrack[countryA][2]++;
		if(backtrack[countryB][0]<=status[countryB][0]&&backtrack[countryA][2]<=status[countryA][2])
			isAvailable(now+1,nextA,nextB);
		backtrack[countryB][0]--;
		backtrack[countryA][2]--;
	}
	
	static boolean compareArr() {
		for(int row=0;row<6;row++) {
			for(int col=0;col<3;col++) {
				if(backtrack[row][col]!=status[row][col])return false;
			}
		}
		return true;
	}
	
	

}
