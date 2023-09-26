import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
/**
 * 
 * @author 영진
 *  1. LIS 리스트를 생성
 *  2. 배열 앞에서 부터 해당 숫자가 LIS리스트에 어디에 포함될지 계산
 *  3. LowerBound(해당 숫자보다 크거나 같은 곳에 위치) 에 값을 대체 
 *  4. 만약 해당값이 가장 큰값이라면 add 해줌
 *  5. LIS의 최종 크기가 곧 길이가 된다.
 *
 */
public class Solution {
	static int T;
	static int N;
	static List<Integer> LIS;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int test_case=1;test_case<=T;test_case++) {
			N = Integer.parseInt(br.readLine());
			LIS= new ArrayList<>();
			int[] map = new int[N];
			StringTokenizer st =new StringTokenizer(br.readLine());
			for(int index =0 ;index<N;index++) {
				map[index]=Integer.parseInt(st.nextToken());
			}
			LIS.add(map[0]);
			
			for(int index =1; index<N;index++) {
				int pos = binSearch(LIS,map[index]);
				
				if(pos>=LIS.size()) {//가장 큰값일 시 add
					LIS.add(map[index]);
				}else {//아닐시 크거나 같은 곳 변경
					LIS.set(pos, map[index]);
				}
			}
			sb.append("#"+test_case+" "+LIS.size()+"\n");
			
			
			
		}
		
		System.out.println(sb);
	}
	
	static int binSearch(List<Integer> LIS,int num) {
		int left= 0;
		int right= LIS.size()-1;
		
		while(left<=right) {
			int mid = (left+right)/2;
			
			if(LIS.get(mid)<=num) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		
		return left;
	}
}
