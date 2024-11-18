import java.util.*;
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> answer = new ArrayList<>();
        Set<String> set = new HashSet<>();


        for(int left =0 ;left<nums.length-2;left++){
            for(int right=left+2;right<nums.length;right++){
                int small = nums[left];
                int big = nums[right];
                int find = -big-small;
                int mid =  binSearch(nums,find,left+1,right-1);
                
                if(mid==Integer.MIN_VALUE)continue;

                String str = small+""+mid+""+big;
                
                if(set.contains(str))continue;

                set.add(str);
                answer.add(List.of(small,mid,big));
            }
        }

        return answer;

    }

    static int binSearch(int[] nums, int find, int left, int right){

        while(left<=right){
            int mid = (left+right)/2;

            if(nums[mid]==find)return nums[mid];

            if(nums[mid]<find){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }


        return Integer.MIN_VALUE;
    }
}