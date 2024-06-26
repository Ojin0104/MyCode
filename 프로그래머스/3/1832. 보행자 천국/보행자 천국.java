class Solution {
    int MOD = 20170805;
    int[] dr = {1,0};
    int[] dc = {0,1};
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][][] dp =new int[m][n][2]; //0은 
        for(int col = 0;col<n ; col++){
            if(cityMap[0][col]==1){
                break;
            }
            
            dp[0][col][1]=1;
        }
        dp[0][0][0]=1;
        
        for(int row = 1; row<m;row++){
            for(int col = 0;col<n;col++){
                
                
                
                if(cityMap[row][col]==1){
                    continue;
                }
                
                if(col ==0){
                    dp[row][0][0]=dp[row-1][0][0];
                    continue;
                }
                
//                 if(cityMap[row][col]==2){
//                     dp[row][col][0]=dp[row-1][col][0];
//                     dp[row][col][1] = dp[row][col-1][1];
//                 }else{
                    
                    if(cityMap[row-1][col]==2){
                        dp[row][col][0]=dp[row-1][col][0];
                    }else{
                        dp[row][col][0] =(dp[row-1][col][0]+dp[row-1][col][1])%MOD;
                    }
                    
                    if(cityMap[row][col-1]==2){
                        dp[row][col][1]=dp[row][col-1][1];
                    }else{
                   
                    dp[row][col][1]=(dp[row][col-1][1]+dp[row][col-1][0])%MOD;
                    }
             //   }
                
                
               
          // System.out.print(dp[row][col][0]+dp[row][col][1]+" ");
                
            }
         //   System.out.println();
        }
        answer =(dp[m-1][n-1][0]+dp[m-1][n-1][1])%MOD;
        return answer;
    }
}