import java.util.*;

class Solution {
   
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        
        //d l r u
        
        //S ~ E 합 구함
        int moveR = r-x;
        int moveC = c-y;
        int nowR = x;
        int nowC = y;
        int shortestMove = Math.abs(moveR)+Math.abs(moveC);
        StringBuilder sb = new StringBuilder();
        if((k-shortestMove)%2==1||k<shortestMove)return "impossible";
        for(int idx= 1; idx<=k; idx++){
            
            //System.out.println(moveR+" "+moveC+" "+(k-idx+1));
            if(k-idx+1 == Math.abs(moveR)+Math.abs(moveC)){
                if(moveR>0){
                    sb.append("d");
                    moveR--;
                }else if(moveC<0){
                    sb.append("l");
                    moveC++;
                }else if(moveC>0){
                    sb.append("r");
                    moveC--;
                }else{
                    sb.append("u");
                    moveR++;
                }
                continue;
            }
            
            if(nowR+1<=n){
                sb.append("d");
                nowR++;
                moveR--;
            }else if(nowC-1>=1){
                sb.append("l");
                nowC--;
                moveC++;
            }else if(nowC+1<=m){
                sb.append("r");
                nowC++;
                moveC--;
            }else{
                sb.append("u");
                nowR--;
                moveR++;
            }
           // System.out.println(nowR+" "+nowC);
        }
        return sb.toString();
    }
}
