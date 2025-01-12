import java.util.*;
class Solution {
    public int findMinArrowShots(int[][] points) {
        int answer =0 ;
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int maxRange = points[0][1];
        
        for(int[] point:points){
            if(point[0]>maxRange){
                answer++;
                maxRange = point[1];
            }else if(point[1]<maxRange){
                maxRange = point[1];
            }
        }
        
        return answer+1;
    }
}