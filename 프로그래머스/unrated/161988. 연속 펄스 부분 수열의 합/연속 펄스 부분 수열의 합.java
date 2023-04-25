import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        long[] sum=new long[sequence.length];
        sum[0]=sequence[0];
        long max=sum[0];
        long min=sum[0];
        for(int i=1;i<sequence.length;i++){
            if(i%2==1){
                sum[i]=sum[i-1]-sequence[i];
            }else{
                sum[i]=sum[i-1]+sequence[i];
            }
            
            max=Math.max(max,sum[i]);
            min=Math.min(min,sum[i]);
        }
        
        answer=max-min;
        if(max<0)answer=-min;
        if(min>0)answer=max;
        
        return answer;
    }
}