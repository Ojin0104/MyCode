class Solution {
    public int solution(int[] diffs, int[] times, long limit) {//이진탐색으로 최소한 레벨의 통과가능 값 확인
        
        
        int left = 0;
        int right = 100000;
        
        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(mid, diffs,times,limit)){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        
        return Math.max(1,left);
    }
    
    boolean isPossible(int level,int[] diffs, int[] times, long limit){
        long total  = 0;
        
        
        for(int idx = 0 ;idx< diffs.length; idx++){
            int diff = diffs[idx];
            int time = times[idx];
            int prev = 0;
            
            if(idx>0) prev = times[idx-1];
            
            if(diff>level){
                total += (time+prev)*(diff-level); 
            }
            
            total+=time;
            
            if(total>limit)return false;
        }
        
        return true;
        
        
    }
}