import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] map ;
	static int[][] dp;
	static boolean[][] check;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	public static void main(String args[]) throws IOException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+2][M+2];
		for(int i=0;i<N+2;i++) {
			Arrays.fill(map[i],Integer.MAX_VALUE);
			}
		
		for(int i=1;i<=N;i++) {
		st=new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		check=new boolean[N+2][M+2];
	    dp=new int[N+2][M+2];
		System.out.println(dfs(1,1));
		
		
	}

	static int dfs(int x,int y) {//도착했을때 지났던길에 도착만해도 카운트 해주면
		if(x==N&&y==M) {
			
			return 1;
		}
		
		if(check[x][y])
	    {
	        
	        return dp[x][y];
	    }
	    
	    check[x][y]=true;
	    
	    for(int i=0;i<4;i++) {
	    	if(map[x+dx[i]][y+dy[i]]<map[x][y]) {
	    		dp[x][y]+=dfs(x+dx[i],y+dy[i]);
	    	}
	    }
	    
		
		
		
		return dp[x][y];
	}
	}
