import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int num=s/n;
        int add=s%n;
        
        Arrays.fill(answer,num);
        if(num==0)return new int[]{-1};
        for(int i=n-1;i>=0;i--){
            if(add==0)break;
            answer[i]+=1;
            add--;
        }
        return answer;
    }
}