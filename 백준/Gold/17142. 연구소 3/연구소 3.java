import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static char[][] map;
	static boolean[] check;
	static int M;
	static int min=Integer.MAX_VALUE;
	static int zero_count=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		
		map=new char[N][N];
		ArrayList<Position> pos_arr=new ArrayList<>();
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=st.nextToken().charAt(0);
				if(map[i][j]=='2') {
					pos_arr.add(new Position(i,j));
				}
				if(map[i][j]=='0')zero_count++;
			}
		}
		if(zero_count==0) {
			System.out.println(0);
			return;
		}
		check=new boolean[pos_arr.size()];
		selectVirus(pos_arr,0,0);
		if(min==Integer.MAX_VALUE)min=-1;
		System.out.println(min);
	}
	
	static void selectVirus(ArrayList<Position> pos_arr,int index,int count) {
		if(count==M) {
			bfsStart(pos_arr);
			
			return ;
		}
		if(index>=pos_arr.size())return;
		check[index]=true;
		selectVirus(pos_arr,index+1,count+1);
		check[index]=false;
		selectVirus(pos_arr,index+1,count);
		
		
	}
	
	static void bfsStart(ArrayList<Position> pos_arr) {
		int[] dr= {0,1,0,-1};
		int[] dc= {1,0,-1,0};
		Queue<int[]> que=new LinkedList<>();
		char[][] newMap=new char[map.length][map.length];
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				newMap[i][j]=map[i][j];
			}
		}
		int count=0;
		
		for(int i=0;i<pos_arr.size();i++) {
			if(check[i]) {
				Position pos=pos_arr.get(i);
				que.add(new int[] {pos.r,pos.c,0});
				newMap[pos.r][pos.c]='*';
			}
		}
		int times=0;
		int nowtime=-1;
		//System.out.println("Start-----------------");
		while(!que.isEmpty()) {
			
			int[] now=que.poll();
			times=now[2];
			
			if(now[2]>=min) {
				break;
			}
//			if(nowtime!=now[2]&&min!=2) {
//				System.out.println("times"+ times+ "now "+now[2]);
//				System.out.println(Arrays.deepToString(newMap));
//				System.out.println();
//				nowtime=now[2];
//			}
			
			for(int i=0;i<4;i++) {
				int next_r=now[0]+dr[i];
				int next_c=now[1]+dc[i];
				if(next_r<0||next_c<0||next_r>=map.length||next_c>=map.length)continue;
				if(newMap[next_r][next_c]=='*'||newMap[next_r][next_c]=='1')continue;
				
				if(newMap[next_r][next_c]=='0') {
					count++;
					
				}
				newMap[next_r][next_c]='*';
				
				
				que.add(new int[] {next_r,next_c,now[2]+1});
			}
			if(zero_count==count) {
				times=now[2]+1;
				break;
			}
			
		}
		if(zero_count==count)
			min=Math.min(min, times);
		
		
		
	}
	
	static class Position{
		int r;
		int c;
		public Position(int r,int c) {
			this.r=r;
			this.c=c;
		}
	}

}
