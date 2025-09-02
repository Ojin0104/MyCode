class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int answer = 0;

        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int row = 0 ;row< obstacleGrid.length; row++){
            for(int col = 0 ; col <obstacleGrid[0].length ;col++){
                
                if(obstacleGrid[row][col]==1)continue;
                if(row==0 && col==0){
                    dp[row][col]=1;
                    continue;
                }
                
                if(row==0){
                    dp[row][col] =dp[row][col-1];
                    continue;
                }
                if(col==0){
                    dp[row][col] = dp[row-1][col];
                    continue;
                }



                int sum = 0;

                sum+=dp[row-1][col];
                sum+=dp[row][col-1];

                dp[row][col] = sum;
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }
}