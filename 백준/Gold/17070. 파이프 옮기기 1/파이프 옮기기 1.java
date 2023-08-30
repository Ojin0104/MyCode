import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 
 * @author 영진
 * 1. dfs를 통해 이동시키는 경우의 수를 구한다.
 * 2. dfs진행시 가로 or 대각 or 세로 인 현재 상황을 판단하여 다음 이동지점을 정한다.
 * 2. dp를 사용하여 시간을 줄인다.
 *
 */
public class Main {
	static int[][] map;
	static int[] dr = {0,1,1};//오른  아래 아래대각
	static int[] dc = {1,0,1};
	static int count=0;
	static int N;
	static boolean[][] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		check = new boolean[N][N];
		
		for(int row =0 ;row<N;row++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int col = 0; col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());	
			}
		}
		
		dfs(0,1,0);//status  0 가로 1세로 2 대각
		
		System.out.println(count);
	}
	
	static void dfs(int row,int col,int status) {
		//System.out.println(row+" "+col+" "+status);
		if(row==N-1&&col==N-1) {
			count++;
			return;
		}
		
//		
		for(int next=0;next<=2;next++) {
			if(status!=2&&next!=2&&next!=status)continue;//대각은 무조건이동가능 , 세로 -> 가로  가로-> 세로 는 이동불가능함
			
			int next_r = row+dr[next];
			int next_c = col+dc[next];
				
			if(next_r<0||next_r>=N||next_c<0||next_c>=N||map[next_r][next_c]==1)continue;
			if(next==2&&(map[row+1][col]==1||map[row][col+1]==1))continue; // 벽에부딪히는경우
			if(check[next_r][next_c])continue;
			//System.out.println(next_r+" "+next_c);
			check[next_r][next_c]=true;
			dfs(next_r,next_c,next);
			check[next_r][next_c]=false;
			
			
		}
	}
}
