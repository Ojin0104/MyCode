import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *	1. 몇다리 거쳐서 알 수 있는 관계 -> 유니온 파인드 사용시 같은 부모를 가질 경우
 *	2. 모두 union을 한 이후 find로 부모를 갱신해주면서 distinct한 부모들의 수를 센다.
 */
public class Solution {
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parent = new int[N+1];
			for(int idx=1;idx<=N;idx++) {//부모배열 초기화
				parent[idx]=idx;
			}
			
			for(int times=1;times<=M;times++) {//관계 연결해주기
				st = new StringTokenizer(br.readLine());
				
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				union(start,end);
			}
			
			Set<Integer> set = new HashSet<>();
			
			for(int idx =1;idx<parent.length;idx++) {
				set.add(find(parent[idx]));
			}
			
			sb.append("#"+test_case+" "+set.size()+"\n");
		}
		System.out.println(sb);
	}
	
	static int find(int a) {
		if(parent[a]==a)return a;
		
		return parent[a] = find(parent[a]);
	}
	
	static boolean union(int a, int b) {
		int A = find(a);
		int B = find(b);
		
		if(A==B) {//이미 부모가 같은경우
			return false;
		}
		
		if(A<B) {
			parent[B]=A;
		}else {
			parent[A]=B;
		}
		return true;
	}

}
