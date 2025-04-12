class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int idx = 1; idx<triangle.length; idx++){
            for(int col = 0; col <= idx; col++){
                dp[idx][col] = Math.max(dp[idx-1][col] + triangle[idx][col],dp[idx][col]);
                if(col>0){
                    dp[idx][col] = Math.max(dp[idx-1][col-1] + triangle[idx][col],dp[idx][col]);
                }
            }
        }
        
        
        for(int idx =0 ;idx<triangle.length; idx++){
            answer = Math.max(dp[triangle.length-1][idx],answer);
        }
        return answer;
    }
}