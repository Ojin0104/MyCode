class Solution {
    public int[] solution(int target) {
        int[] answer = {};
        int[][] dp = new int[target+1][2];
        for(int idx= 1; idx<=target; idx++){
            dp[idx][0] = Integer.MAX_VALUE;
            for(int left = Math.max(0,idx-60); left <idx ; left++){
                int point = idx-left;
                if(point <=20 || point == 50){
                    if(dp[idx][0]>dp[left][0]+1){
                        dp[idx][0] = dp[left][0]+1;
                        dp[idx][1] = dp[left][1]+1;
                    }else if(dp[idx][0] ==dp[left][0]+1 &&dp[idx][1]<dp[left][1] +1 ){
                        dp[idx][0] = dp[left][0]+1;
                        dp[idx][1] = dp[left][1]+1;
                    }
                }else if(point>20 && point <=40 && point%2==0){
                        if(dp[idx][0]>dp[left][0]+1){
                        dp[idx][0] = dp[left][0]+1;
                        dp[idx][1] = dp[left][1];
                    }else if(dp[idx][0] ==dp[left][0]+1 &&dp[idx][1]<dp[left][1] ){
                        dp[idx][0] = dp[left][0]+1;
                        dp[idx][1] = dp[left][1];
                    }
                }else if(point>20 && point <=60 && point%3==0){
                       if(dp[idx][0]>dp[left][0]+1){
                        dp[idx][0] = dp[left][0]+1;
                        dp[idx][1] = dp[left][1];
                    }else if(dp[idx][0] ==dp[left][0]+1 &&dp[idx][1]<dp[left][1] ){
                        dp[idx][0] = dp[left][0]+1;
                        dp[idx][1] = dp[left][1];
                    }
                
                }
            }
        }
        return new int[]{dp[target][0],dp[target][1]};
    }
}