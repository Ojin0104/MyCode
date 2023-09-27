
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *	1.다잌스트라 사용하여 해당지점까지 갈 수 있는지 체크한다.
 *  2.Place클래스를 선언해서  
 */
public class Main {
	static boolean[] check;
	static int[] dist;
	static boolean flag;
	static StringBuilder sb = new StringBuilder();
	private final static int inf = 10000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			int restNum=Integer.parseInt(br.readLine());
			check= new boolean[restNum+1];
			dist= new int[restNum+1];
			Arrays.fill(dist, inf);
			StringTokenizer st = new StringTokenizer(br.readLine());
			flag= false;
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			
			Place startPoint = new Place(row,col,0);
			
			List<Place> places = new ArrayList<>();
			
			for(int index=0;index<restNum;index++) {//편의점 위치 설정
				st = new StringTokenizer(br.readLine());
				row = Integer.parseInt(st.nextToken());
				col = Integer.parseInt(st.nextToken());
				Place place = new Place(row,col,1);
				places.add(place);
			}
			
			//도착지점 설정
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			Place place = new Place(row,col,2);
			places.add(place);
			
			sb.append(dikstra(places,startPoint)+"\n");
		}
		System.out.println(sb);
		
		
	}
	static String dikstra(List<Place> places,Place startPoint) {
		PriorityQueue<Status> que = new PriorityQueue<>((a,b)-> a.dist-b.dist);//거리 기준 정렬
		Status state = new Status(0,startPoint,1000,-1);
		que.add(state);
		while(!que.isEmpty()) {
			Status now = que.poll();
			
			if(now.order!=-1) {
				if(check[now.order])continue;
				check[now.order]=true;
			}
			for(int index=0;index<check.length;index++) {
				if(check[index])continue;
				Place next = places.get(index);
				int dist= calcDist(next,now);
				if(dist<=now.canMove) {
					int canMove=1000;
					if(next.type==2) {
						return "happy";
					}
					que.add(new Status(now.dist+dist,next,canMove,index));
				}
				
			}
			
		}
		return "sad";
	}
	
	
	static int calcDist(Place one,Status two) {//거리 찾는 메소드
		return Math.abs(one.row-two.place.row)+Math.abs(one.col-two.place.col);
	}
	
	static class Place{
		int row;
		int col;
		int type; //0은 집 1은 편의점 2 도착지점
		
		public Place(int row, int col, int type) {
			this.row=row;
			this.col=col;
			this.type=type;
		}
	}
	
	static class Status{
		int dist;
		Place place;
		int canMove;
		int order;
		public Status(int dist,Place place, int canMove,int order){
			this.dist=dist;
			this.place=place;
			this.canMove=canMove;
			this.order =order;
		}
	}
}
