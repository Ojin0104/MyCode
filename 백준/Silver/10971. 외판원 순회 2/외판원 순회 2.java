import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1. 한점에서 출발하여 최소거리를 찾는다.
 * 2. 비트마스킹을 사용해 방문했던 도시를 기록한다.
 * 
 *
 */
public class Main {
	static int arrive=0;

	static int[][] map; 
	static int min = Integer.MAX_VALUE;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int row=0;row<N;row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int col = 0;col<N;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		int visited=1;
		arrive=(int) (Math.pow(2, N)-1);
		dfs(0,visited,0);
		
		System.out.println(min);
	}
	
	static void dfs(int now, int visited,int sum) {
		if(sum>min)return;
		
		if(visited==(int) (Math.pow(2, N)-1)) {//모든점방문 후 다시 0으로 돌아올 수 있는지 체크
			if(map[now][0]!=0) {//다시 0으로 갈 수 있는지 체크
				min = Math.min(min, sum+map[now][0]);
			}
			
			return;
		}
		
		for(int idx=1;idx<N;idx++) {
			if((visited>>idx&1)==1||map[now][idx]==0) continue; //이미방문
			
			visited=visited|(1<<idx);
			dfs(idx,visited,sum+map[now][idx]);
			visited=visited&~(1<<idx);
			
		}
	}
}
