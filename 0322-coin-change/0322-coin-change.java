class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];

        for(int idx = 1; idx<amount+1;idx++){
            dp[idx] =Integer.MAX_VALUE;
        }


        for(int idx =1; idx<=amount; idx++){

            for(int c=0;c<coins.length;c++){

            
                if(idx-coins[c]<0)continue;

                if(dp[idx-coins[c]]==Integer.MAX_VALUE)continue;

                
                dp[idx]= Math.min(dp[idx-coins[c]]+1,dp[idx]);

            }
        }

        if(dp[amount]==Integer.MAX_VALUE)return -1;

        return dp[amount];
    }
}