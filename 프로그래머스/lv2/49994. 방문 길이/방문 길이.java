import java.util.*;
class Solution {
    static HashMap<String,Boolean> map=new HashMap<>();
    static int[] now=new int[]{0,0};
    static int answer=0;
    public int solution(String dirs) {
        
        
        for(int i=0;i<dirs.length();i++){
            char ch=dirs.charAt(i);
            move(ch);
        }
        
        return answer;
    }
    
    static void move(char dir){
        String start=now[0]+" "+now[1];
        
        if(dir=='U'){
            now[1]+=1;
            if(now[1]==6){
                now[1]--;
                return;
            }
        }else if(dir=='D'){
            now[1]-=1;
            if(now[1]==-6){
                now[1]++;
                return;
            }
        }else if(dir=='R'){
            now[0]++;
            if(now[0]==6){
                now[0]--;
                return;
            }
        }else{
            now[0]--;
            if(now[0]==-6){
                now[0]++;
                return;
            }
        }
        
        String end=now[0]+" "+now[1];
        
        if(!map.containsKey(start+end)){
            answer++;
        
            map.put(start+end,true);
            map.put(end+start,true);
        }
        return;
    }
}