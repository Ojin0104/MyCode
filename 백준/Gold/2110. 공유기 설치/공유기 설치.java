import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int C;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int[] nums=new int[N];
		for(int i=0;i<N;i++) {
			nums[i]=Integer.parseInt(br.readLine());
		}
		Arrays.sort(nums);
		int d=nums[N-1]/(C-1);
		
		System.out.println(binSearch(nums,d));
		
	}
	static int binSearch(int[] nums,int d) {
		int left=1;
		int right=d;
		int mid=0;
		while(left<=right) {
			mid=(left+right)/2;
			if(posible(nums,mid)) {
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return right;
		
	}
	
	static boolean posible(int[] nums, int d) {
	
		int point=-d;
		int count=0;
		for(int num:nums) {
			if(num>=point+d) {
				point=num;
				count++;
				
			}
		}
		
		if(count>=C) {
			return true;
			
		}else {
			return false;
		}
	}
}
