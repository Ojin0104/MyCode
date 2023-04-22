import java.util.*;
class Solution {
    public long solution(int k, int d) {//a^2+b^2=
        long answer = 0;
        for(int i=0;i<=d;i+=k){
            long result=(long)Math.pow(d,2)-(long)Math.pow(i,2);
            result=(long)Math.sqrt(result);
            answer+=result/k+1;
        }
        
        return answer;
    }
}