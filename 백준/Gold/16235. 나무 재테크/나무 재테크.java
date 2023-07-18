import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
		static int N;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		PriorityQueue<Integer>[][] trees=new PriorityQueue[N][N];
		int[][] ground=new int[N][N];
		int[][] vitamin=new int[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				trees[i][j]=new PriorityQueue<Integer>();
				ground[i][j]=5;
				vitamin[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int r=Integer.parseInt(st.nextToken())-1;
			int c=Integer.parseInt(st.nextToken())-1;
			int age=Integer.parseInt(st.nextToken());
			trees[r][c].add(age);
		}
		for(int i=0;i<K;i++) {
			ArrayList<int[]> makeTree=new ArrayList<>();
			spring(ground,trees,makeTree);
			autumn(ground,trees,makeTree);
			winter(ground,vitamin);
		}
		int answer=checkTree(trees);
		System.out.println(answer);
	}
	static int checkTree(PriorityQueue<Integer>[][] trees) {
		int count=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				count+=trees[i][j].size();
			}
		}
		
		return count;
	}
	
	static void winter(int[][] ground,int[][] vitamin) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				ground[i][j]+=vitamin[i][j];
			}
		}
	}
	static void autumn(int[][] ground,PriorityQueue<Integer>[][] trees,ArrayList<int[]> makeTree) {
		for(int[] now:makeTree) {
			for(int i=-1;i<=1;i++) {
				for(int j=-1;j<=1;j++) {
					if(i==0&&j==0)continue;
					
					int next_r=now[0]+i;
					int next_c=now[1]+j;
					
					if(next_r<0||next_c<0||next_r>=N||next_c>=N)continue;
					
					trees[next_r][next_c].add(1);
				}
			}
		}
	}
	static void spring(int[][]ground,PriorityQueue<Integer>[][] trees,ArrayList<int[]> makeTree) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(trees[i][j].isEmpty())continue;
				int dead=0;
				PriorityQueue<Integer> next=new PriorityQueue<Integer>();
				while(!trees[i][j].isEmpty()) {
					int now=trees[i][j].poll();
					if(ground[i][j]>=now) {
						ground[i][j]-=now;
						next.add(now+1);
						if((now+1)%5==0) {
							makeTree.add(new int[] {i,j});
						}
					}else {
						dead+=now/2;
					}
					
				}
				ground[i][j]+=dead;
				trees[i][j]=next;
			}
		}
	}
	
	
}