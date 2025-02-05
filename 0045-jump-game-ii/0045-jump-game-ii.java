class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int idx = 0; idx<nums.length; idx++){
            dp[idx] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for(int idx =0; idx< nums.length ; idx++){
            if(nums[idx]==0)continue;
            for(int i = idx+1; i< Math.min(nums.length,idx+nums[idx]+1); i++){
                dp[i] = Math.min(dp[idx]+1,dp[i]);
            }
            
        }
        return dp[nums.length-1];
    }
}