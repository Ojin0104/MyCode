import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String,Integer> index=new HashMap<>();
        
        for(int i=0;i<want.length;i++){
            index.put(want[i],i);
        }
        int last=0;
        int food=0;
        for(int j=0;j<10;j++){
            if(!index.containsKey(discount[j]))continue;
            
            food=index.get(discount[j]);
            
            number[food]-=1;
                
            }
        if(check(number))answer++;
        for(int i=10;i<discount.length;i++){
            if(index.containsKey(discount[i-10])){
            last=index.get(discount[i-10]);
            number[last]++;
            }
            if(index.containsKey(discount[i])){
            food=index.get(discount[i]);
            number[food]--;
            }
            if(check(number))answer++;
        }
        return answer;
    }
    
    boolean check(int[] number){
        for(int num: number){
            
            if(num>0)return false;
        }
        return true;
    }
}