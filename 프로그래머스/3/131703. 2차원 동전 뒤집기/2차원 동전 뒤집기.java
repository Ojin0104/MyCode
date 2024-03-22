import java.util.*;
class Solution {
    static int answer = 100;
    static int rSize = 0;
    static int cSize = 0;
    public int solution(int[][] beginning, int[][] target) {
      //어떤열을 먼저 뒤집든 결과에 상관이 없음
        //20개 중에 n개를 고르는 경우(조합) 
        rSize = beginning.length;
        cSize = beginning[0].length;
        int[] dif = new int[rSize];
        //1. 둘의 차이를 이차원 배열로 찾기
        for(int row = 0; row<rSize;row++){
            for(int col = 0;col<cSize;col++){
                if(beginning[row][col]!=target[row][col]){
                    dif[row]+=1<<cSize-col-1;
                }
            }
        }
        
        dfs(0,0,dif);
        if(answer==100)answer =-1;
        return answer;
    }
    
    public void dfs(int idx,int count,int[] dif){
        if(idx>=rSize+cSize){
            //다 0인지 확인
            check(dif,count);
            return;
        }
        //배열 갱신
        rotate(idx,dif);
        dfs(idx+1,count+1,dif);
        //다시돌리기
        rotate(idx,dif);
        dfs(idx+1,count,dif);
    }
    
    public void check(int[] dif,int count){
        for(int row = 0;row<rSize;row++){
            for(int col = 0; col < cSize; col++){
                if(((dif[row]>>col)&1)==1)return ;
            }
        }
        
        answer= Math.min(answer,count);
    }
    
    public void rotate(int idx, int[] dif){
        if(idx<rSize){//행을 돌리기
            int mask = (1<<cSize) -1;
            dif[idx] = dif[idx]^mask;
            
        }else{
            idx-=rSize;
            for(int row = 0;row<rSize;row++){
                dif[row]= dif[row]^(1<<idx);
            }
        }
        
    }
}