import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        Arrays.sort(money);
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=0;i<money.length;i++){
            for(int j=money[i];j<n+1;j++){
                dp[j]+=dp[j-money[i]]%1000000007;
               
            }
        }
        return dp[n];
    }
}