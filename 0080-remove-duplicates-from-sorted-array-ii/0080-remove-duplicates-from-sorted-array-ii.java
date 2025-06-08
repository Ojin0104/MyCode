class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        boolean flag = false;
        int lastNum = -101;
        int nowIdx = 0;
        
        for(int idx = 0 ; idx< nums.length; idx++){
            int num = nums[idx];
            if(num == lastNum){
                if(flag) continue;
                flag = true;
            }else{
                flag= false;
            }
            nums[nowIdx++] = num;
            lastNum = num;
            count++;

        }
        return count;
    }
}