class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        // 1번을 무조건 훔치는 경우, 마지막을 무조건 훔치는 경우
        
        return Math.max(bestRobberCase(nums,0,nums.length-2),bestRobberCase(nums,1,nums.length-1));
    }

    public int bestRobberCase(int[] nums, int start, int end){
        int prev = 0;
        int max = 0;

        for(int idx = start; idx<=end; idx++){
            int temp = Math.max(prev+nums[idx], max);
            prev = max;
            max = temp;
        }

        return max;
    }
}