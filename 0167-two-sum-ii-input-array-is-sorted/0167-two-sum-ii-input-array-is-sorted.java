class Solution {
    public int[] twoSum(int[] numbers, int target) {
        for(int idx =0 ; idx<numbers.length-1; idx++){
            for(int next = idx+1;next<numbers.length; next++){
                if(numbers[idx]+numbers[next] ==target){
                    return new int[] {idx+1,next+1};

                }

                if(numbers[idx]+numbers[next]>target)break;
            }
        }

        return null;
    }
}