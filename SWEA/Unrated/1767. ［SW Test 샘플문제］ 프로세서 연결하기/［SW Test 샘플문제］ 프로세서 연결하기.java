import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *  1.코어 클래스와 배열을 만들어 각 코어의 전선 설치할 수 있는 방향을 기록한다.
 *  2.코어의 갯수는 최대 12개이므로 백트래킹 가능 4^12=1600만 정도-> 각방향에 대해서 백트랙키을한다.
 *  3.백트래킹중 적당히 최적화 하기
 *
 */
public class Solution {
	static int[][] map;
	static ArrayList<Core> cores=new ArrayList<>();
	static int maxSize=0;
	static int minLength=0;
	static int N;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case=1;test_case<=T;test_case++) {
			N = Integer.parseInt(br.readLine().trim());
			maxSize=0;
			minLength=Integer.MAX_VALUE;
			map = new int[N][N];
			cores=new ArrayList<>();
			
			for(int row =0; row<N;row++) {//코어 위치를 저장하는 배열
				StringTokenizer st =new StringTokenizer(br.readLine());
				for(int col=0;col<N;col++) {
					map[row][col]=Integer.parseInt(st.nextToken());
					if(map[row][col]==1) {
						cores.add(new Core(row,col));
					}
				}
			}
			
			dfs(0,0,0);
			
			sb.append("#"+test_case+" "+minLength+"\n");
		}
		System.out.println(sb);
	}
	
	
	static void dfs(int now, int size,int length) {//index,연결된 코어 갯수, 연결할떄 사용한 전선 길이
		
		if(now==cores.size()) {//모두 탐사시 코어갯수와 전선 길이 갱신해줌
			if(maxSize<size) {//코어갯수 많으면 무조건 갱신
				maxSize=size;
				minLength=length;
			}else if(maxSize==size&&length<minLength) {//코어갯수 같고 전선길이는 짧으면 갱신
				minLength=length;
			}
			return;
		}
		
		
		//4방향 모두 탐지
		Core nowCore= cores.get(now);
		
		//벽에붙어있는 경우
		if(nowCore.r==0||nowCore.r==N-1||nowCore.c==0||nowCore.c==N-1) {
			dfs(now+1,size+1,length);
			
		}else {//벽에붙어있지않을경우 4가지 방향으로 탐색을 진행한다.
			for(int dir=0;dir<4;dir++) {
				//전선 그려주는 메소드
				int addLength = addLine(nowCore,dir);
				//dfs
				if(addLength!=0) {//코어사이즈 추가 및 전선지워주는 메소드
					dfs(now+1,size+1,length+addLength);
					delLine(nowCore,dir);
				}
			}
			
			dfs(now+1,size,length);//추가하지 않는 경우
			
		}
	}
	
	static void delLine(Core nowCore, int dir) {
		int[] now = {nowCore.r+dr[dir],nowCore.c+dc[dir]};
		int line =0;
		while(now[0]>=0&&now[1]>=0&&now[0]<N&&now[1]<N) {
			
			map[now[0]][now[1]]=0;//다시 0으로
			now[0]=now[0]+dr[dir];
			now[1]=now[1]+dc[dir];
		}
	}
	
	static int addLine(Core nowCore, int dir) {
		//nowCore 기준으로 dir방향으로 벽 일떄 까지 감 만약 벽이아니라 1이라면 0을 반환
		int[] now = {nowCore.r+dr[dir],nowCore.c+dc[dir]};
		int line =0;
		while(now[0]>=0&&now[1]>=0&&now[0]<N&&now[1]<N) {
			if(map[now[0]][now[1]]==1||map[now[0]][now[1]]==2)return 0;//이미 전선이나 코어 존재하는 경우
			//System.out.println(now[0]+" "+now[1]);
			now[0]=now[0]+dr[dir];
			now[1]=now[1]+dc[dir];
		}
		
		//전선 존재할 수 있음
		
		now[0] = nowCore.r+dr[dir];
		now[1] = nowCore.c+dc[dir];
		
		while(now[0]>=0&&now[1]>=0&&now[0]<N&&now[1]<N) {//전선 존재할 수 있을때 2로 전선 표기
			line++;
			map[now[0]][now[1]]=2;
			now[0]=now[0]+dr[dir];
			now[1]=now[1]+dc[dir];
		}
		
		return line;
	}
	
	static class Core{
		
		int r;
		int c;
		
		public Core(int r,int c) {
			this.r= r;
			this.c=c;
		}
	
	}
}
