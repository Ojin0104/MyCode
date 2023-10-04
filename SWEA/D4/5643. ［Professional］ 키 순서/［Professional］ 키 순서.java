
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *1. 확실하게 자신의 키가 몇 번째인지 알 수 있는 경우 -> 남은 노드중 가장 작은 순서대로 노드를 걷어낸다. 
 *2. 해당 시간에 혼자 노드를 걷어낸다면 이는 확실한 키순서를 가진 학생이다.
 *3. 위상정렬을 사용하여 현재 시간을 기록하며 노드를 걷어낸다.
 *
 *4. T= 15, N = 500이하이므로 N^3 까지도 충분히 가능하므로 시간적으로 여유롭다.
 */
public class Solution {
//트리가 나눠지는 경우??
	static int[] count ; 
	static boolean[] check;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int test_case = 1; test_case<=T;test_case++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			int[] degree= new int[N+1];
			//나보다 작은 학생수 저장
			ArrayList<Integer>[] nodes = new ArrayList[N+1];
			count = new int[N+1];
			check = new boolean[N+1];
			//해당학생보다 큰 학생들 저장
			for(int init = 0;init<nodes.length;init++) {//리스트 초기화
				nodes[init] = new ArrayList<Integer>();
			}
			for(int query = 0;query<M;query++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				int small = Integer.parseInt(st.nextToken());
				int big = Integer.parseInt(st.nextToken());
				
				degree[big]++;
				nodes[small].add(big);
				
			}
			
			for(int index=1;index<N+1;index++) {
				Arrays.fill(check,false);
				check[index]=true;
				count[index]+=dfs(nodes,index,0);
				
			}
			 //topological(degree,nodes);
			int answer =0;
			for(int index=1;index<N+1;index++) {
				if(count[index]>=N-1) {
					answer++;
				}
			}
			
			sb.append("#"+test_case+" "+answer+" \n");
			
		}
		
		System.out.println(sb);
	}
	
	
	static int dfs( ArrayList<Integer>[] nodes,int index,int sum) {
		count[index]++;
		for(Integer next: nodes[index]) {
			if(check[next])continue;
			
			check[next] = true;
			sum+=dfs(nodes,next,1);
			
		}
		
		return sum;
	}
	
	
}