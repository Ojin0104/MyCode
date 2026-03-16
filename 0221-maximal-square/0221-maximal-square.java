class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] dp = new int[r][c];
        for(int row = 0; row< r ; row++){
            for(int col =0; col< c ; col++){
                if(matrix[row][col]=='1'){
                    if(row==0 || col ==0){
                        dp[row][col]=1;
                    }else{

                        dp[row][col] = Math.min(dp[row-1][col-1],Math.min(dp[row][col-1],dp[row-1][col]))+1;
                        
                    }
                    max = Math.max(dp[row][col],max);
                }
            }
        }
        return max*max;
    }
}