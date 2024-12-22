import java.util.*;
class Solution {
    public int solution(int n, int[] cores) {
        
        int left = 0;
        int right = n*10000;
        while(left<=right){
            int mid = (left+right)/2;
            if(isPossible(mid,cores)>=n){
                right = mid- 1;
            }else{
                left = mid + 1;
            }
            
        }
        int totalTime = left;
        int work = isPossible(totalTime,cores);
        work -= n;
        
        for(int idx = cores.length-1; idx>=0 ; idx--){
            if(totalTime%cores[idx]==0){
                
                if(work==0)
                    return idx+1;
                work --;
                
            }
        }
        
        return -1;
    }
    
    public int isPossible(int totalTime, int[] cores){
        if(totalTime ==0)return cores.length;
        int sum = cores.length;
        for(int idx = 0 ; idx<cores.length; idx++){
            sum+= totalTime/cores[idx];
        }
        
        return sum;
    }
    
    
        
        
       
        
    
}