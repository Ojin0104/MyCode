class Solution {
    public int lengthOfLIS(int[] nums) {
        
        List<Integer> list = new ArrayList<>();

        if(nums.length==0)return 0;

        list.add(nums[0]);

        for(int idx =1; idx<nums.length ;idx++){
            int target = findNum(list,nums[idx]);
            System.out.println(target);
            if(target>=list.size()){
                list.add(nums[idx]);
            }else{
                list.set(target,nums[idx]);
            }
        }

        return list.size();
        
    }

    public int findNum(List<Integer> list, int num){
        int left = 0;
        int right =list.size();

        while(left<right){
            int mid = (left+right)/2;
            int midNum = list.get(mid);
            if(num <=midNum){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left;
    }
}