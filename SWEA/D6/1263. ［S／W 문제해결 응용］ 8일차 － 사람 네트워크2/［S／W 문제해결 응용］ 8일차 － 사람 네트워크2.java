import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		for(int test_case = 1;test_case <=T; test_case++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			for(int row = 0; row<N;row++) {
				for(int col = 0;col<N;col++) {
					int num = Integer.parseInt(st.nextToken());
					if(num==0)num=N;
					map[row][col]= num;
				}
			}
			
			//floyd
			
			for(int center = 0;center < N;center++) {
				for(int start = 0 ;start<N;start++) {
					for(int end= 0;end<N;end++) {
						map[start][end]=Math.min(map[start][end], map[start][center]+map[center][end]);
					}
				}
			}
			
			int answer = findMin(map,N);
			
			sb.append("#"+test_case+" "+answer+"\n");
		}
		
		System.out.println(sb);
	}
	
	static int findMin(int[][] map ,int N) {
		int min=Integer.MAX_VALUE;
		for(int row = 0;row<N;row++) {
			int sum = 0;
			for(int col = 0;col<N;col++) {
				if(map[row][col]<N&&row!=col) {
					sum+=map[row][col];
				}
			}
			min = Math.min(min, sum);
		}
		
		return min;
	}
}
