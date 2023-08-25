import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1. MST를 만드는 문제로 프림 , 크루스칼 중 하나를 선택한다.
 * 2. 노드는 최대 N개 간선은 N(N-1)개이다. 크루스칼은 간선을 정렬 즉 (N^2logN^2)이걸림 간선이많으므로 프림이 조금? 더 적절해보임
 * 3. 정점을 선택후 가장 가까운 정점을 선택
 */
public class Solution {
	
	static int[][] map;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int  T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		for(int test_case=1;test_case<=T;test_case++) {
			
			N =Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int idx=0;idx<N;idx++) {
				
				int row = Integer.parseInt(st.nextToken());
				
				map[idx][0]=row;
				
			}
			
			st =new StringTokenizer(br.readLine());
			for(int idx=0;idx<N;idx++) {
				
				int row = Integer.parseInt(st.nextToken());
				
				map[idx][1]=row;
				
			}
			
			double E = Double.parseDouble(br.readLine());
			
			long answer = Math.round(prim()*E);
			
			//String str=String.format(" %l",answer*E);
			
			sb.append("#"+test_case+" "+answer+"\n");
		
		}
		
		System.out.println(sb);
	}
	
	static double prim() {
		boolean check[] = new boolean[N];
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1,e2)->{
			if(e1.dist-e2.dist<0) {
				return -1;
			}else {
				return 1;
			}
		 
			
		});//dist짧은 순으로 정렬
		double totalDist=0;
		
		pq.add(new Edge(0,0));
		
		while(!pq.isEmpty()) {
			Edge now =pq.poll();
			
			if(check[now.v]) continue;
			//System.out.println("real "+now.v+" "+now.dist);
			check[now.v]=true;
			//totalDist+=now.dist;
			totalDist+=Math.pow(now.dist, 2);
			for(int idx=0;idx<N;idx++) {
				if(!check[idx]) {
					pq.add(new Edge(idx,calcDist(map[now.v],map[idx])));
				//	System.out.println(idx+"  "+calcDist(map[now.v],map[idx]));
				}
				
			}
		}
		
		
		
		return totalDist;
	}
	
	static class Edge{
		int v;//다음노드
	    double dist;//다음노드까지 거리
	    
	    public Edge(int v, double dist) {
	    	this.v =v;
	    	this.dist=dist;
	    }
	    
	    
	}
	static double calcDist(int[] land1,int[] land2){//섬끼리 거리
		//return Math.abs(land1[0]-land2[0])+Math.abs(land1[1]-land2[1]);
		//System.out.println(Math.sqrt(Math.pow(land1[0]-land2[0], 2)+Math.pow(land1[1]+land2[1], 2)));
		return Math.sqrt(Math.pow(land1[0]-land2[0], 2)+Math.pow(land1[1]-land2[1], 2));
	}
	

}
