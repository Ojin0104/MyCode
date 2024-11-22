class Solution {
    public boolean canJump(int[] nums) {
        int count= 1;
        for(int idx =0 ;idx<nums.length;idx++){
            if(count==0)return false;
            count--;
            count= Math.max(count,nums[idx]);
        }

        return true;
    }
}