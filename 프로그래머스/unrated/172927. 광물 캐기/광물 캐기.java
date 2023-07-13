import java.util.*;
class Solution {
        static int answer=Integer.MAX_VALUE;
        static int[] turn;
    public int solution(int[] picks, String[] minerals) {
        
        turn=new int[picks[0]+picks[1]+picks[2]];
        int index=0;
        dfs(picks[0],picks[1],picks[2],minerals,index);
        return answer;
        
        //곡갱이 각각 5개 75만회
        //피로도50회 총 3700만회
    }
    static void dfs(int dia,int iron,int stone, String[] minerals,int index){
        if(dia==0&&iron==0&&stone==0){
           
            answer=Math.min(answer,calc(minerals));
            return;
        }
        if(dia!=0){
            turn[index]=1;
            dfs(dia-1,iron,stone,minerals,index+1);
        }
        
        if(iron!=0){
            turn[index]=2;
            dfs(dia,iron-1,stone,minerals,index+1);
        }
        
        if(stone!=0){
            turn[index]=3;
            dfs(dia,iron,stone-1,minerals,index+1);
        }
        
        
        
    }
    static int calc(String minerals[]){
        int sleep=0;
        int mineralcount=0;
        for(int i=0;i<turn.length;i++){
            int stones=0;
            for(int j=0;j<5;j++){
                
                if(minerals[mineralcount].equals("diamond"))stones=1;
                else if(minerals[mineralcount].equals("iron"))stones=2;
                else stones=3;
                
                int size=turn[i]-stones;
                
                if(size<0)size=0;
               // System.out.println(size);
                sleep+=Math.pow(5,size);
              
                mineralcount++;
                if(mineralcount>=minerals.length)return sleep;
            
            }
            
            
        }
        return sleep;
        
    }
}