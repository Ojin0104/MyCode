class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        int product =1;
        int zeroNum= 0;
        for(int idx = 0;idx<nums.length;idx++){
            if(nums[idx]==0){
                zeroNum++;
                continue;
            }
            product *=nums[idx];
        }
        for(int idx= 0; idx<nums.length;idx++){

            if(nums[idx]==0&&zeroNum==1){
                answer[idx] = product;
                continue;
            }
            if(zeroNum!=0)continue;

            answer[idx] = product/nums[idx];
        }

        return answer;
    }
}