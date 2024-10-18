import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);

        ArrayList<int[]> list = new ArrayList<>();
        int[] now = null;
        for(int[] interval: intervals){
            if(now==null){
                now = interval;
                continue;
            }

            if(interval[0]<=now[1]){
                now[1] = Math.max(now[1],interval[1]);
            }else{
                list.add(now);
                now=interval;
            }
        }
        if(now!= null){
            list.add(now);
        }
        int[][] answer= new int[list.size()][2];
        int idx = 0;
        for(int[] node : list){
            answer[idx] = node;
            idx++;
        }
        return answer;
    }
}