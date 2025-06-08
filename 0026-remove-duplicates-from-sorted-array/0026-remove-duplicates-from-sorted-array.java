class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int lastNum = -101;
        int nowIdx = 0;
        for(int idx = 0 ; idx< nums.length; idx++){
            int num = nums[idx];
            if(num == lastNum) continue;
            nums[nowIdx++] = num;
            lastNum = num;
            count++;

        }
        return count;
    }
}