class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];

        int now = 1;
        for(int idx = 0 ;idx<nums.length; idx++){
            now*=nums[idx];
            max = Math.max(max,now);

            if(now ==0) now =1;
        }
now =1;
        for(int idx = nums.length-1 ;idx>=0; idx--){
            now*=nums[idx];
            max = Math.max(max,now);

            if(now ==0) now =1;
        }

        return max;
    }
}