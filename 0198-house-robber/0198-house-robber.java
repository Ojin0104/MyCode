class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int idx = 2 ;idx< dp.length; idx++){
            dp[idx] = Math.max(dp[idx-2]+nums[idx-1],dp[idx-1]);
        }

        return dp[nums.length];
    }
}