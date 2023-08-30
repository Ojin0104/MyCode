import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 	1.bfs 
 *
 */
public class Main {
	static int K;
	static int W;
	static int H;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	static int[] ddr = {1,1,-1,-1};
	static int[] ddc = {1,-1,1,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		
		int[][] map =new int[H][W];
		
		for(int row=0;row<H;row++) {
			st =new StringTokenizer(br.readLine());
			for(int col=0;col<W;col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int answer=bfs(map);
		
		System.out.println(answer);
	}
	
	static int bfs(int[][] map) {
		ArrayDeque<Status> que = new ArrayDeque<>();
		int[][] check  = new int [H][W];
		for(int row=0;row<H;row++) {
			Arrays.fill(check[row], -1);
		}
		que.add(new Status(0,0,0,K));
		
		while(!que.isEmpty()) {
			
			Status now = que.pollFirst();
			//System.out.println(now.times);
			//System.out.println(now.row+" "+now.col+" "+now.jump);
			if(now.row==H-1&&now.col==W-1)return now.times;
			
			if(now.jump>0) {//jump로 이동 
				//System.out.println(now.row+" "+now.col+" "+now.jump);
				for(int dir=0;dir<4;dir++) {
					int next_r= now.row+ddr[dir]*2;
					int next_c= now.col+ddc[dir];
					
					if(next_r>=0&&next_c>=0&&next_r<H&&next_c<W) {//범위포함
						if(map[next_r][next_c]==0) {
							if(check[next_r][next_c]<now.jump-1) {
								que.addLast(new Status(next_r,next_c,now.times+1,now.jump-1));
								check[next_r][next_c]=now.jump-1;
							}
							}
					}
					
					
					next_r=now.row+ddr[dir];
					next_c=now.col+ddc[dir]*2;
					//System.out.println(next_r+" "+next_c);
					if(next_r>=0&&next_c>=0&&next_r<H&&next_c<W) {//범위포함
						if(map[next_r][next_c]==0) {
							if(check[next_r][next_c]<now.jump-1) {
								que.addLast(new Status(next_r,next_c,now.times+1,now.jump-1));
								check[next_r][next_c]=now.jump-1;
							}
							}
					}
					
					
					
					
					
				}
			}
			
			for(int dir=0;dir<4;dir++) {
				int next_r= now.row+dr[dir];
				int next_c= now.col+dc[dir];

				//System.out.println(next_r+" "+next_c+" "+H+ " "+W);
				if(next_r>=0&&next_c>=0&&next_r<H&&next_c<W) {//범위포함
					//System.out.println(next_r+" "+next_c);
					if(map[next_r][next_c]==0) {
						if(check[next_r][next_c]<now.jump) {
							que.addLast(new Status(next_r,next_c,now.times+1,now.jump));
							check[next_r][next_c]=now.jump;
						}
						}
				}
			}
			
			
			
		}
		
		return -1;
		
	}
	
	static class Status{
		int row;
		int col;
		int times;
		int jump;//점프남은횟수
		
		public Status(int row, int col, int times,int jump){
			this.row=row;
			this.col=col;
			this.times=times;
			this.jump=jump;
		}
	}
}
