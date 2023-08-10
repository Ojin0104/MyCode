import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1. 스타트팀과 링크팀으로 나눈 조합두개를 찾는다. 
 * 2. 각 팀의 조합점수를 더해준다.
 *
 */
public class Main {
	static int min = Integer.MAX_VALUE;
	static int[][] talent;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		talent = new int[N][N];
		
		for(int row =0;row<N;row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0 ;col<N;col++) {
				talent[row][col]= Integer.parseInt(st.nextToken());
			}
		}
		int[] start= new int[N/2];
		int[] link= new int[N/2];
		
		dfs(start,link,0,0,0) ;
			
		System.out.println(min);
		
	}
	
	static void dfs(int[] start,int[] link,int left,int right,int index) {
		if(left+right==N) {//두팀 모두 정해졌을때
			//두팀의 차이 구하기
			min= Math.min(min,compareTeam(start,link));
			return;
		}
		
		if(left<N/2) {//팀에 자리가있을때만 로직 수행
			start[left]=index;
			dfs(start,link,left+1,right,index+1);
		}
		
		if(right<N/2) {
			link[right]=index;
			dfs(start,link,left,right+1,index+1);
		}
	}
	
	static int compareTeam(int[] start, int[] link) {
		int startSum=0;
		int linkSum=0;
		
		for(int l=0;l<N/2;l++) {//각팀 2명씩 조합하여 sum을 구해준다.
			for(int r=l+1;r<N/2;r++) {
				startSum+=talent[start[l]][start[r]]+talent[start[r]][start[l]];
				linkSum+=talent[link[l]][link[r]]+talent[link[r]][link[l]];
			}
		}
		
		return Math.abs(startSum-linkSum);
	}
}
