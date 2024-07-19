class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int[] left= new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = nums[0];
        right[nums.length-1] = nums[nums.length-1];
        for(int idx = 1;idx<nums.length;idx++){
            left[idx] = nums[idx]*left[idx-1];
            right[nums.length-1-idx] = nums[nums.length-1-idx]*right[nums.length-idx];
        }

        answer[0] = right[1];
        answer[nums.length-1] = left[nums.length-2];

        for(int idx= 1; idx<nums.length-1;idx++){
            answer[idx] = left[idx-1]*right[idx+1];
        }

        return answer;
    }
}