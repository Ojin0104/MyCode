class Solution {
    public int maxSubArray(int[] nums) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        int answer = 0;
        int max = sum[0];
        int min = 0;
        answer = max-min;
        min = Math.min(sum[0],0);
        //지금까지의 최소값 과 sum[idx] 값 비교
        for(int idx = 1; idx < nums.length; idx++){
            sum[idx] = sum[idx-1]+nums[idx];
            answer = Math.max(answer,sum[idx]-min);
            min = Math.min(sum[idx],min);
        }
    
        return answer;
    }
}