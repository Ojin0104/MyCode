class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int sumMax =nums[0];
        int nowMax = nums[0];
        int nowMin = nums[0];
        int sumMin = nums[0];

        for(int idx = 1; idx<nums.length;idx++){
            sum+=nums[idx];

            nowMax = Math.max(nowMax+nums[idx],nums[idx]);
            sumMax = Math.max(nowMax,sumMax);
            nowMin = Math.min(nowMin+nums[idx],nums[idx]);
            sumMin = Math.min(nowMin,sumMin);

        }
        if(sum==sumMin)return sumMax;
        return Math.max(sumMax,sum-sumMin);
    }
}