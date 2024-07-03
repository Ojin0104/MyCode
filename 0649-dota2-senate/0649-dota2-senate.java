import java.util.*;
class Solution {

    //뒤에 남은게 있으면 뒤에걸 없애고 뒤에 남은게 없으면 앞에 것의 권리를 박탈시킴
    boolean flag = true;
    public String predictPartyVictory(String senate) {
        Queue<Character> que = new LinkedList<>();
        int radiant = 0;
        int dire = 0;
        for(int idx = 0 ;idx< senate.length(); idx++){
            if(senate.charAt(idx)=='R')radiant++;
            que.add(senate.charAt(idx));
        }

        dire = senate.length()-radiant;

        int del_radiant=0;
        int del_dire= 0 ;
        while(dire!=0&&radiant!=0){
            Character now = que.poll();

            if(now=='R'){
                if(del_radiant==0){
                    que.add('R');
                    del_dire++;
                    continue;
                }
                del_radiant--;
                radiant--;
            }

            if(now=='D'){
                if(del_dire ==0){
                    que.add('D');
                    del_radiant++;
                    continue;
                }
                del_dire--;
                dire--;
            }
        }

        if(radiant>0){
            return "Radiant";
        }
        return "Dire";
    }

    

    
    
}