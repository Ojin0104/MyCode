import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *	1.ArrayList를 요소로한 배열을 생성하여 각 노드에서 갈 수 있는 곳을 탐색한다.
 *  2.check배열을 통해 방문했던 노드를 체크하고 총 5번의 경로를 거칠 수 있다면 1을 바로 반환한다.
 *  3.dfs를 여러번 반복한다.
 */
public class Main {
	static boolean[] check;
	static ArrayList<Integer>[] graph;
	static int answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		int N= Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		check = new boolean[N];
		graph = new ArrayList[N];
		for(int idx=0;idx<N;idx++) {
			graph[idx]=new ArrayList<Integer>();
		}
		for(int edge =0;edge<M;edge++) {//노드들 마다 이동할 수  있는 edge를 기록해줌
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph[start].add(end);
			graph[end].add(start);
		}
		
		
		for(int num=0;num<N;num++) {//모든 노드들에대해 dfs를 해준다. 만약 이미 친구관계가 존재한다면 break한다.
			if(answer==1)break;
			check = new boolean[N];
			dfs(num,0);
		}
		
		System.out.println(answer);
	}
	
	static void dfs(int now,int depth) {
		if(depth==5) {
			answer=1;
			return;
		}
		if(answer==1)return;
		for(int next: graph[now]) {//다음노드로 이동
			if(check[next]) continue;
			
			check[next]=true;
			dfs(next,depth+1);
			check[next]=false;
		}
	}
}
