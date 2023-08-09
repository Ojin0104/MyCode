import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**\
 * dfs+dp로 풀수있다.
 * 총 칸수는 1000*1000 이고 이동경우는 +1클떄이다.
 *
 * dp를이용해 이미 계산되어있는 경로는 추가적으로 계산하지 않는다.
 * @author 영진
 *
 */
public class Solution {
	static int maxRoom;
	static int maxNum;
	static int[][] dp;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++) {
			int N= Integer.parseInt(br.readLine());
			maxRoom=-1;
			maxNum=-1;
			
			dp = new int[N][N];
			int[][] map = new int[N][N];
			
			for(int row =0;row<N;row++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				Arrays.fill(dp[row],-1);//아직방문하지 않았다면 -1로 표시해줌
				for(int col=0;col<N;col++) {
				map[row][col]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int row=0;row<N;row++) {
				for(int col = 0;col<N;col++) {
					if(dp[row][col]==-1)
						dfs(map,row,col);
				}
			}
			
			sb.append("#"+test_case+" "+maxRoom+" "+maxNum+"\n");
			
		}
		System.out.println(sb);
	}
	
	static void dfs(int[][] map,int row, int col) {
		dp[row][col]=1;//방문체크 
		for(int dir=0;dir<4;dir++) {
			int next_r=row+dr[dir];
			int next_c=col+dc[dir];
			
			if(next_r<0||next_c<0||next_r>=map.length||next_c>=map[0].length) {//범위벗어나는경우
				continue;
			}
			if(map[next_r][next_c]!=map[row][col]+1) continue;//이동불가능!
				
				
			if(dp[next_r][next_c]!=-1) {//이미방문했을 경우 구해논값을 이용해 현재위치의 범위를 계산한다.
				dp[row][col]=Math.max(dp[row][col],dp[next_r][next_c]+1);
				
			}else {//방문하지않았을경우 다음방을 먼저 들린후 그값을 이용해 현재위치의 범위를 계산한다.
				dfs(map,next_r,next_c);
				dp[row][col]=Math.max(dp[row][col],dp[next_r][next_c]+1);
				
			}
			
		}
		if(dp[row][col]>maxNum) {//더큰 범위가진 방이라면
			maxNum=dp[row][col];
			maxRoom=map[row][col];
		}else if(dp[row][col]==maxNum) {
			if(map[row][col]<maxRoom) {//범위 같지만 방번호가 작은경우
				maxNum=dp[row][col];
				maxRoom=map[row][col];
			}
		}
		
	}

}
