import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1.union-find문제
 * 
 */
public class Solution {
	static int[] parent;
	static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			parent = new int[N+1];
			rank= new int[N+1];
			for(int idx=1;idx<N+1;idx++) {//parent배열 초기화
				parent[idx]=idx;
				rank[idx]=1;
			}
			
			sb.append("#"+test_case+" ");
			
			for(int query=0;query<M;query++) {
				st = new StringTokenizer(br.readLine());
				
				if(Integer.parseInt(st.nextToken())==0) {
					//union
					int nodeA=Integer.parseInt(st.nextToken());
					int nodeB=Integer.parseInt(st.nextToken());
					
					union(nodeA,nodeB);
				}else {
					int nodeA=Integer.parseInt(st.nextToken());
					int nodeB=Integer.parseInt(st.nextToken());
					
					//find 비교
					if(find(nodeA)==find(nodeB)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}
	
	public static int find(int a) {
		if(parent[a]==a) {
			return a;
		}
		
		return parent[a]=find(parent[a]);
	}
	
	public static void union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A==B) {
			//이미 합집합
			return;
		}
		
		if(rank[B]<rank[A]) {
			parent[B]=A;
			rank[A]+=rank[B];
		}else {
			parent[A]=B;
			rank[B]+=rank[A];
		}
		
	}
}
