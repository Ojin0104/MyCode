class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        
        int count = 0;
        int right = Integer.MIN_VALUE;

        for(int[] interval:intervals){
            if(interval[0]>=right){
                right= interval[1];
            }else{
                count++;
                right = Math.min(right,interval[1]);
            }
        }

        return count;
    }
}