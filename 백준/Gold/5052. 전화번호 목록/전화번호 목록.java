import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test_case=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
		
		for(int testcase=1;testcase<=test_case;testcase++) {
			int num=Integer.parseInt(br.readLine());
			
			String[] nums=new String[num];
			
			for(int index=0;index<num;index++) {
				nums[index]=br.readLine();
			}
			Arrays.sort(nums,(a,b)->a.length()-b.length());
			HashMap<String,Boolean> check = new HashMap<>();
			boolean flag=checkYes(check,nums);
			if(flag) {
				sb.append("YES\n");
			}else {
				sb.append("NO\n");
			}
			
		}
		System.out.println(sb);
	}
	static boolean checkYes(HashMap<String,Boolean> check,String[] nums) {
		for(String Intnum:nums) {
			for(int cutIndex=1;cutIndex<=Intnum.length();cutIndex++) {
				if(check.containsKey(Intnum.substring(0,cutIndex))) {
					return false;
				}
			}
			check.put(Intnum, true);
		}
		return true;
	}
}
