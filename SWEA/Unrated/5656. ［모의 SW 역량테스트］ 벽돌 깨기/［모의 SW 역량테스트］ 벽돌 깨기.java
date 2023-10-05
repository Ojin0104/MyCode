import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 
 * @author 영진
 * 1. N=4 W=12 H=15
 * 2. 숫자가 작으므로 브루트포스로 문제를 해결해도 문제 XX
 * 3. 벽돌은 최대 4개이므로 떨어뜨리는 경우의수는 12^4이다 (20736)
 * 4. 벽돌을 떨어뜨리고 몇개의 벽돌이 제거 되는지 확인한다.
 *
 */
public class Solution {
	static int[][] map;
	static int answer;
	static int W;
	static int H;
	static int[] dr = {1,0,-1,0};
	static int[] dc = {0,1,0,-1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int test_case = 1 ; test_case<=T;test_case++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			answer = Integer.MAX_VALUE/2;
			int N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int block=0;
			map =new int[H][W];
			
			for(int row=0;row<H;row++) {
				st = new StringTokenizer(br.readLine());
				for(int col = 0 ;col<W;col++) {
					map[row][col] = Integer.parseInt(st.nextToken());
					if(map[row][col]!=0) {
						block++;
					}
				}
			}
			
			int[] order = new int[N];
			//구슬 던지는 순열 구하기
			findOrder(N,order);
			//System.out.println(block);
			//answer=block-answer;
			sb.append("#"+test_case+" "+answer+"\n");
			
		}
		System.out.println(sb);
	}
	
	static int[][] mapCopy(){//map을 copy
		int[][] newMap = new int[map.length][map[0].length];
		
		for(int row=0;row<map.length;row++) {
			for(int col = 0 ;col<map[0].length;col++) {
				newMap[row][col]=map[row][col];
				
			}
		}
		
		return newMap;
	}
	
	static int breakBlock(int[] order) {
		//System.out.println(Arrays.toString(order));
		//맵을 복사
		int[][] nowMap = mapCopy();
		int sum = 0 ;
		//순서대로 구슬을 쏘기
		//System.out.println(Arrays.toString(order));
		for(int index:order) {
			//부서질 벽돌의 위치 찾기
			Point point= findBlock(nowMap,index);
			shootBlock(nowMap,point);
			//블록 재정비
			blockSetting(nowMap);
//			
//			if(order[0]==2&&order[1]==2) {
//				for(int row=0;row<H;row++) {
//					System.out.println();
//					for(int col=0;col<W;col++) {
//						System.out.print(nowMap[row][col]);
//					}
//				}
//				System.out.println();
//			}
		}
		sum = countMap(nowMap);
		
		return sum;
	}
	
	static int countMap(int[][] nowMap) {
		int sum = 0;
		for(int row=0;row<H;row++) {
			for(int col =0;col<W;col++) {
				if(nowMap[row][col]>0) {
					sum++;
				}
			}
		}
		return sum;
	}
	
	static void blockSetting(int[][] nowMap) {
		for(int col=0;col<W;col++) {
			for(int row=1;row<H;row++) {
				//0일 시 위에꺼 아래로 당겨줌
				if(nowMap[row][col]==0) {
					//위에꺼 당기기
					for(int nextRow=row;nextRow>=1;nextRow--) {
						nowMap[nextRow][col]=nowMap[nextRow-1][col];
						nowMap[nextRow-1][col]=0;
					}
				}
			}
		}
	}
	
	static Point findBlock(int[][] nowMap,int index) {
		Point point = new Point(0,index);
		for(int row=0;row<H;row++) {
			if(nowMap[row][index]>0) {
				return new Point(row,index);
			}
		}
		return point;
	}
	
	//해당 블럭 연쇄적으로 부수기
	static void shootBlock(int[][] nowMap,Point point) {
		
		int power = nowMap[point.row][point.col];
		if(nowMap[point.row][point.col]>0) {
			nowMap[point.row][point.col]=0;
		}else {
			return ;
		}
		
		for(int dir=0;dir<4;dir++) {//4방향 블럭들 제거
			for(int dist=1;dist<power;dist++) {//파워 만큼 블럭 제거
				int nextR = point.row+dr[dir]*dist;
				int nextC = point.col+dc[dir]*dist;
				
				if(nextR<0||nextR>=H||nextC<0||nextC>=W)break;
				shootBlock(nowMap,new Point(nextR,nextC));
			}
		}
		return ;
		
	}
	
	static void findOrder(int remain,int[] order){
		if(remain==0) {
			//블럭 부시기
		//	System.out.println(Arrays.toString(order));
			int count = breakBlock(order);
			answer= Math.min(count, answer);
			return;
		}
		int index = order.length-remain;
		
		for(int idx=0;idx<W;idx++) {//중복순열을 구함
			order[index]=idx;
			findOrder(remain-1,order);
		}
	}
	
	static class Point{
		int row;
		int col;
		
		Point(int row,int col){
			this.row=row;
			this.col=col;
		}
	}
}
