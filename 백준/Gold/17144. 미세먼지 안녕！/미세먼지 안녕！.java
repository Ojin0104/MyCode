import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int R=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		int T=Integer.parseInt(st.nextToken());
		
		int[][] map=new int[R][C];
		int[] up=new int[] {0,0};
		
		boolean flag=false;
		
		//입력
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(!flag&&map[i][j]==-1) {
					up[0]=i;
					up[1]=j;
					flag=true;
				}
			}
		}
		for(int i=0;i<T;i++) {
			//미세먼지 퍼지는 부분
			map=spreadMap(map);
			map[up[0]][up[1]]=-1;
			map[up[0]+1][up[1]]=-1;
			
			//공기청정기 가동하는 부분
			moveAir(map,up);
		}
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum+=map[i][j];
			}
		}
		sum+=2;
		
		System.out.println(sum);
		
	}
	static void moveAir(int[][] map,int[] up) {
		
		for(int i=0;i<2;i++) {
			int[] now=new int[] {up[0]+i,up[1]};
			if(i==1) {
				//공기필터 방향바꿈(위아래)
				dr[0]*=-1;
				dr[2]*=-1;
			}
			for(int j=0;j<4;j++) {
				
				while(true) {
					
					int next_r=now[0]+dr[j];
					int next_c=now[1]+dc[j];
					
					if(i==0) {
						if(next_r<0||next_c<0||next_r>up[0]||next_c>=map[0].length) {
							break;
						}
					}else {
						if(next_r<=up[0]||next_c<0||next_r>=map.length||next_c>=map[0].length) {
							break;
						}
					}
					if(map[next_r][next_c]==-1) {
						map[now[0]][now[1]]=0;
						break;
					}
					if(map[now[0]][now[1]]==-1) {
						now[0]=next_r;
						now[1]=next_c;
						
						continue;
					}
					
					map[now[0]][now[1]]=map[next_r][next_c];
					now[0]=next_r;
					now[1]=next_c;
					
				}
			}
		}
		dr[0]*=-1;
		dr[2]*=-1;
		
		
	}
	static int[][] spreadMap(int[][] map){
		
		int[][] nextMap=new int[map.length][map[0].length];
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[0].length;j++) {
				if(map[i][j]!=-1)
					spread(nextMap,map,i,j);
			}	
		}
		
		return nextMap;
	}
	
	static void spread(int[][] nextMap,int[][] map,int r, int c) {
		
		int air=map[r][c];
		int last_air=map[r][c];
		for(int i=0;i<4;i++) {
			int next_r=r+dr[i];
			int next_c=c+dc[i];
			
			if(next_r<0||next_c<0||next_r>=map.length||next_c>=map[0].length||map[next_r][next_c]==-1) {
				continue;
			}
			nextMap[next_r][next_c]+=air/5;
			last_air-=air/5;
		}
		nextMap[r][c]+=last_air;
	}

}
