class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        
        int[][] dp = new int[land.length][4];
        dp[0][0]=land[0][0];
        dp[0][1]=land[0][1];
        dp[0][2]=land[0][2];
        dp[0][3]=land[0][3];
        
        for(int row =1 ;row<land.length;row++){
            for(int col = 0;col<4;col++){
                for(int j = 0;j<4;j++){
                    if(col==j)continue;
                    dp[row][col] = Math.max(dp[row][col],dp[row-1][j]+land[row][col]);
                }
                
            }
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        for(int col = 0;col<4;col++){
            answer= Math.max(answer,dp[land.length-1][col]);
        }
        return answer;
    }
}