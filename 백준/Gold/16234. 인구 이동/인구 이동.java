import java.util.*;
import java.io.*;
public class Main {
	static int N;
	static int L;
	static int R;
	
	static int[][] map;
	
	static int[][] check;
	static HashMap<Integer,ArrayList<Index>> sum; 
	static boolean flag;
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		check=new int[N][N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		flag=true;
		int answer=0;
		while(flag) {
			flag=false;
			sum=new HashMap<>();
			check=new int[N][N];
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(check[i][j]==0) {
						bfs(i,j);
					}
				}
			}
			
			if(flag)answer++;
			else break;
			//합치고 배분
			
			for(Integer index: sum.keySet()) {
				ArrayList<Index> arr=sum.get(index);
				int num=arr.size();
			
				int addNum= check[arr.get(0).r][arr.get(0).c]/num;
				
				for(int i=0;i<num;i++) {
					map[arr.get(i).r][arr.get(i).c]=addNum;
				}
			}
			
		}
		System.out.println(answer);
		
		
	}
	
	static void bfs(int x,int y) {
		int[] dr= {1,0,-1,0};
		int[] dc= {0,1,0,-1};
		Queue<int[]> que=new LinkedList<>();
		que.add(new int[] {x,y});
		ArrayList<Index> arr=new ArrayList<Index>();
		arr.add(new Index(x,y));

		check[x][y]=map[x][y];
		
		
		while(!que.isEmpty()) {
			int[] now=que.poll();
			
			for(int i=0;i<4;i++) {
				int next_r=now[0]+dr[i];
				int next_c=now[1]+dc[i];
				if(next_r<0||next_c<0||next_r>=N||next_c>=N||check[next_r][next_c]!=0)continue;
				
				int diff=Math.abs(map[next_r][next_c]-map[now[0]][now[1]]);
				
				if(diff>=L&&diff<=R) {
					flag=true;
					check[next_r][next_c]=1;
					check[x][y]+=map[next_r][next_c];
					arr.add(new Index(next_r,next_c));
					que.add(new int[] {next_r,next_c});
				}
				
				
				
			}
			
		}
		if(arr.size()>=2) {
			sum.put(x*map[0].length+y,arr);
		}
	}
	
	static class Index{
		int r;
		int c;
		Index(int r,int c){
			this.r=r;
			this.c=c;
		}
	}
	
}
