class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;
        int size = 1;
        int left = 0 ;
        int right = 0;

        int sum = nums[0];
        if(sum>=target)return 1;
        while(left<nums.length && left<=right){
            if(sum<target){
                right++;
                if(right>=nums.length)break;
                size++;
                sum+=nums[right];
                if(sum>=target){
                    answer = Math.min(answer,size);
                }
                continue;
            }

            if(sum>= target){
                sum-=nums[left];
                left++;
                size--;
                if(sum>=target){
                    answer = Math.min(answer,size);
                }
                continue;
            }
        }
        if(answer == Integer.MAX_VALUE) return 0;
        return answer;

    }
}