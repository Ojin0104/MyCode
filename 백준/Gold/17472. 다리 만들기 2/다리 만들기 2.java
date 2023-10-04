import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 
 * @author 영진
 * 1. 각 섬에 대해 모든방향을 검색한다. 100*5 경우의 수 계산 
 * 2. 섬과섬을 연결하는 가장 최단거리만 저장한다 6*6 배열에 저장
 * 3. 각섬이 한번씩만 포함되면 된다 36개 수 정렬해서 앞에꺼 부터 꺼냄 두개 있는 부분 중 하나라도 새로운 섬 있을때만 OK
 * 4. N-1개의 다리를 선택하면 sum을 return 한다.
 *
 */
public class Main {
	static int[][] bridge;
	static int N;
	static int M;
	static int[] dr = {0,-1,0,1};
	static int[] dc = {1,0,-1,0};
	static int[] parent;
	public static void main(String[] args) throws IOException {
			BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st =new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			for(int row=0;row<N;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 0 ;col<M;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			//각 섬을 해당 번호로 만든다 bfs사용 섬의 갯수도 알아냄
			int numIsland = findIsland(map);
			
			//알아낸 섬의 갯수로 bride 배열 생성 
			bridge = new int[numIsland+2][numIsland+2];//0,1부분은 비어있는 부분
			for(int idx = 0;idx<numIsland+2;idx++) {
				Arrays.fill(bridge[idx],Integer.MAX_VALUE/4);//다리 초기화
			}
			
			//for 문을 돌려 각 섬의 테두리 부분을 확인하고 4방향으로 다리를 만들어 본다
			for(int row = 0; row <N; row++) {
				for(int col = 0;col<M;col++) {
					if(map[row][col]!=0) {
						makeBridge(map,row,col);
					}
				}
			}
			
			
			BridgeStatus[] arr = new BridgeStatus[numIsland*numIsland];
			int index =0;
			//bridge 작은 순서대로 뽑기 
			for(int row=2;row<numIsland+2;row++) {
				for(int col=2;col<numIsland+2;col++) {
					
					arr[index++] = new BridgeStatus(row,col,bridge[row][col]);
				}
			}
			
			Arrays.sort(arr,(a,b)->(a.count-b.count));//카운트 적은 순으로 정렬
			
			parent = new int[numIsland+2];
			for(int idx =2; idx<parent.length;idx++) {
				parent[idx]=idx;
			}
			int answer =0;
			for(int idx=0;idx<arr.length;idx++) {
				BridgeStatus now = arr[idx];
				
				int start= now.start;
				int end= now.end;
				if(union(start,end)) {
					
					answer+=now.count;
					
				}
			}
			
			boolean flag=true;
			for(int idx=3;idx<parent.length;idx++) {
				if(parent[idx]!=parent[idx-1])flag=false;
			}
			if(flag&&answer<Integer.MAX_VALUE/4) {
				System.out.println(answer);
			}else {
				System.out.println(-1);
			}
			
			
	}
	
	static boolean union(int a,int b) {
		int A = find(a);
		int B = find(b);
		
		if(A==B) return false;
		
		if(A<B) {
			parent[B]=A;
		}else {
			parent[A]=B;
		}
		return true;
	}
	
	static int find(int a) {
		if(parent[a]==a)return a;
		
		return parent[a]=find(parent[a]);
	}
	static class BridgeStatus{
		int start;
		int end;
		int count;
		public BridgeStatus(int start,int end,int count){
			this.start= start;
			this.end = end;
			this.count =count;
		}
	}
	
	static void makeBridge(int[][] map, int row, int col) {
		//4방향 탐색 바로 옆에 0이 아닌부분이 있으면 바로 return
		for(int dir=0;dir<4;dir++) {
			int nextR= row+dr[dir];
			int nextC = col+dc[dir];
			
			if(nextR<0||nextR>=N||nextC<0||nextC>=M)continue;
			if(map[nextR][nextC]==0) {//해당방향으로 탐색시작
				findNextIsland(map,row,col,dir);
			}
			
		}
	}
	
	static void findNextIsland(int[][] map,int row,int col,int dir) {
		int start = map[row][col];
		row+=dr[dir];
		col+=dc[dir];
		int dist = 0;
		while(map[row][col]==0) {
			row+=dr[dir];
			col+=dc[dir];
			dist++;
			if(row<0||row>=N||col<0||col>=M)return;//범위 벗어나는 경우
		}
		//System.out.println("dist "+dist);
		int end = map[row][col];
		
		if(dist==1)return;
		
		//다리 건설
		bridge[start][end]=Math.min(bridge[start][end],dist);
		bridge[end][start]=Math.min(bridge[end][start],dist);
		
	}
	
	static int findIsland(int[][] map) {
		
		int count = 0;
		for(int row = 0 ;row<N;row++) {
			for(int col = 0;col<M;col++) {
				if(map[row][col]==1) {
					count++;
					bfs(map,row,col,count);
				}
			}
		}
		return count;
	}
	
	static void bfs(int[][] map, int row, int col,int count) {
		Queue<Position> que = new ArrayDeque<>();
		que.add(new Position(row,col));
		map[row][col]=count+1;
		while(!que.isEmpty()) {
			Position now=  que.poll();
			
			for(int dir =0;dir<4;dir++) {
				int nextR= now.row+dr[dir];
				int nextC = now.col+dc[dir];
				
				if(nextR<0||nextR>=N||nextC<0||nextC>=M)continue;
				
				if(map[nextR][nextC]==1) {
					map[nextR][nextC]=count+1;
					que.add(new Position(nextR,nextC));
				}
			}
		}
		
	}
	
	static class Position{
		int row;
		int col;
		Position(int row, int col) {
			this.row= row;
			this.col=col;
		}
	}
	
}
