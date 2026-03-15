class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = binSearchLeft(nums,target);
        int r = binSearchRight(nums,target);

        return new int[] {l,r};
    }

    public int binSearchLeft(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int idx = -1;
        while(left<=right){
            int mid = (left+right)/2;

            if(target<nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid +1;
            }else {
                idx = mid;
                right = mid-1;
            }
        }
        return idx;
    }

    public int binSearchRight(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        int idx = -1;
        while(left<=right){
            int mid = (left+right)/2;

            if(target<nums[mid]){
                right = mid-1;
            }else if(target>nums[mid]){
                left = mid +1;
            }else {
                idx = mid;
                left = mid+1;
            }
        
        }
        return idx;
    }

}