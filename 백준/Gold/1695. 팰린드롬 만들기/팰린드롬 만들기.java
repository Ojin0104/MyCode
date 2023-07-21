import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {//오른쪽에넣을지 왼쪽에 넣을지 
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int[] nums=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<nums.length;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		dp=new int[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(dp[i], -1);
		}
		int answer=countPalindrome(nums,0,nums.length-1);
		
		System.out.println(dp[0][nums.length-1]);
	}
	
	static int countPalindrome(int[] nums,int left, int right) {
		
		if(left>=right)return 0;
		if(dp[left][right]!=-1)return dp[left][right];
		int count=0;
		
		
			if(nums[left]==nums[right]) {
				count=countPalindrome(nums,left+1,right-1);
			}else {
				count=Math.min(countPalindrome(nums,left,right-1)+1, countPalindrome(nums,left+1,right)+1);
			}
			dp[left][right]=count;
		return count;
	}
}
