import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int answer = 0;
        
        long nowLineCount = food_times.length;
        
        int[] sortedFood = Arrays.copyOf(food_times, food_times.length);
        k+=1;
        Arrays.sort(sortedFood);
        int idx = 0;
        int wave = sortedFood[idx];
        int before = 0;
        while(k>0){
            if(idx>=sortedFood.length)return -1;
            nowLineCount = sortedFood.length - idx;
            wave = sortedFood[idx];
            if(k <= nowLineCount*(wave-before)){
                return findIdx(food_times,wave,k,nowLineCount)+1;
            }
            k-=nowLineCount* (wave-before);
            before = wave;
            idx++;
            while(true){
                if(idx>=sortedFood.length)break;
                
                if(sortedFood[idx-1] != sortedFood[idx])break;
                idx++;
            }
        }
        return answer;
    }
    
    public int findIdx(int[] food_times, int time, long k,long nowLineCount){
        int count = (int)(k%nowLineCount);
        if(count ==0 ) count = (int)nowLineCount;
        
        for(int idx =0 ;idx<food_times.length; idx++){
            if(food_times[idx]<time)continue;
            count--;
            if(count == 0)return idx;
            
            
        }
        
        return -2;
    }
}