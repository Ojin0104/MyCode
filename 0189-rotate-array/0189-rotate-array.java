class Solution {
    public void rotate(int[] nums, int k) {
        int[] answer = new int[nums.length];

        for(int idx = 0 ;idx<nums.length; idx++){
            answer[(idx+k)%nums.length] = nums[idx];
            
        }

        for(int idx =0 ;idx<nums.length; idx++){
            nums[idx] = answer[idx];
        }
    }
}