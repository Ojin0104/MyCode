class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int maxLength = 0;
        for(int row = 0 ; row < matrix.length; row++){
            for(int col = 0; col <matrix[0].length; col++){
                if(matrix[row][col] == '1'){
                    if(row == 0 || col == 0){
                        dp[row][col] =1;
                    }else{

                        dp[row][col] = Math.min(Math.min(dp[row-1][col],dp[row][col-1]),dp[row-1][col-1]) + 1;
                    }
                    maxLength = Math.max(maxLength,dp[row][col]);
                }
            }
        }

        return maxLength * maxLength;
    }
}