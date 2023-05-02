import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int[] size= new int[10000001];
        for(int tan:tangerine){
            size[tan]++;
        }
        Arrays.sort(size);
        for(int i=size.length-1;i>=0;i--){
            k-=size[i];
            if(k<=0)return size.length-i;
        }
        
        
        return answer;
    }
}