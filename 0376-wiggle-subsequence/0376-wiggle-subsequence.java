import java.util.*;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length==0)return 0;
        int up = 1;
        int down = 1;

        for(int idx = 0; idx<nums.length-1; idx++){
            if(nums[idx]>nums[idx+1]){
                up = down+1;
            }

            if(nums[idx]<nums[idx+1]){
                down = up+1;
            }
        }

        return Math.max(up,down);
    }
}