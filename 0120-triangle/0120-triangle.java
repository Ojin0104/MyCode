class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        
        for(int row =0 ; row<dp.length; row++){
            for(int col = 0 ; col<dp.length; col++){
                dp[row][col] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = triangle.get(0).get(0);
        for(int row = 0; row<triangle.size()-1; row++){
            int col = 0;
            for(Integer num : triangle.get(row)){
                dp[row+1][col]= Math.min(dp[row+1][col],dp[row][col]+triangle.get(row+1).get(col));
                dp[row+1][col+1]= Math.min(dp[row+1][col+1],dp[row][col]+triangle.get(row+1).get(col+1));
                col++;
                System.out.println(dp[row+1][col]);
            }
        }
        int answer = Integer.MAX_VALUE;
        for(int sum : dp[triangle.size()-1]){
            answer = Math.min(sum,answer);
        }

        return answer;
    }
}