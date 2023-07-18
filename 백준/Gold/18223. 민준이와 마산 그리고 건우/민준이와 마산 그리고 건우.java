import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static ArrayList<edge>[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		V=Integer.parseInt(st.nextToken());
		int E=Integer.parseInt(st.nextToken());
		int P=Integer.parseInt(st.nextToken());
		
		map=new ArrayList[V+1];
		for(int i=0;i<=V;i++) {
			map[i]=new ArrayList<edge>();
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken());
			int dist=Integer.parseInt(st.nextToken());
			
			map[s].add(new edge(v,dist));
			map[v].add(new edge(s,dist));
		}
		
		int shortDist=dikstra(1,V);
		
		int toP=dikstra(1,P);
		int toDist=dikstra(P,V);
		
		if(shortDist==toP+toDist) {
			System.out.println("SAVE HIM");
		}else {
			System.out.println("GOOD BYE");
		}
	}
	static int dikstra(int start,int end) {
		PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
		boolean[] check=new boolean[V+1];
		int[] dist=new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start]=0;
		
		pq.add(new int[] {start,0});
		
		while(!pq.isEmpty()) {
			if(check[end])break;
			int[] now=pq.poll();
			for(edge next:map[now[0]]) {
				if(check[next.v])continue;
				
				if(now[1]+next.dist<dist[next.v]) {
					
					dist[next.v]=now[1]+next.dist;
					pq.add(new int[] {next.v,now[1]+next.dist});
				}
			}
			check[now[0]]=true;
		}
		return dist[end];
	}
	static class edge{
		int v;
		int dist;
		public edge(int v,int dist) {
			this.v=v;
			this.dist=dist;
		}
	}
}
