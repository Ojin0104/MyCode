import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 
 * @author 영진
 * 1. 결국 4면에 있는 문자열을 오름차순으로 정렬하는 것이다
 * 2. 각문자열을 연속된 4개로 잘라 set에 저장(중복 제거)
 * 3. set에 저장되어있는 문자열을 정렬한다.
 * 4. 10번째에 있는 문자열이 10번째로큰 숫자이다.
 *
 */
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T  = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		for(int test_case=1;test_case<=T;test_case++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			String str = br.readLine();
			Set<String> set = new HashSet<>();
			
			int sliceLength = N/4;
			for(int plus = 0;plus<sliceLength;plus++) {
				for(int start=plus;start<N;start+=sliceLength) {
					String sub;
					if(start+sliceLength>N) {//길이 초과하는 경우
						sub= str.substring(start,N)+str.substring(0,start+sliceLength-N);
					}else {
						sub = str.substring(start,start+sliceLength);
					}
					set.add(sub);
				}
			}
			
			//set을 배열로 만들고 정렬
			String[] result = set.toArray(new String[0]);
			
			Arrays.sort(result,(a,b)->a.compareTo(b));
			//16진수 10진수로 변환
			int answer = Integer.parseInt(result[result.length-K],16);
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.println(sb);
	}
}
