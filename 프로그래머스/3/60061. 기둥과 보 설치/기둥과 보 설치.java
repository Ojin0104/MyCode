import java.util.*;
class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        
        
        int[][] map = new int[n+1][n+1];
        
        for(int[] build :build_frame){
            if(build[3]==0){
                removeBuild(build,map);
            }else if(build[2]==0){
                if(buildPillar(build[0],build[1],map)){
                    map[build[1]][build[0]]=map[build[1]][build[0]]|2;
                }
            }else{
                if(buildBeam(build[0],build[1],map)){
                    map[build[1]][build[0]]=map[build[1]][build[0]]|1;
                }
            }
        }
        
        ArrayList<int[]> result = new ArrayList<>();
         for(int col = 0;col<map[0].length;col++){
               for(int row=0;row<map.length;row++){//기둥먼저
                    if((map[row][col]&2)==2){
                        result.add(new int[]{col,row,0});
                    }
                   
                   if((map[row][col]&1)==1){
                       result.add(new int[]{col,row,1});
                   }
        } 
            }
        int[][] answer = new int[result.size()][3];
        
        for(int idx = 0;idx<answer.length;idx++){
            answer[idx] = result.get(idx);
        }
        return answer;
        //조건만족 확인
    }
    
    
    void removeBuild(int[] build,int[][] map){
        int x= build[0];
        int y = build[1];
       
        if(build[2]==0){//기둥의경우 기둥 바로위와 왼쪽위의 보가 해당기둥없이 존재할 수 있어야함, 바로위 기둥또한 체크
            map[y][x]-=2;
            if(isRange(x,y+1,map)&&((map[y+1][x]&1)==1)&&!buildBeam(x,y+1,map)){
                map[y][x]+=2;
                
                return;
            }
            
            if(isRange(x-1,y+1,map)&&((map[y+1][x-1]&1)==1)&&!buildBeam(x-1,y+1,map)){
                
                map[y][x]+=2;
                return;
            }
            
            if(isRange(x,y+1,map)&&((map[y+1][x]&2)==2)&&!buildPillar(x,y+1,map)){
                 
                map[y][x]+=2;
                return;
            }
            
            
            
        }else{//보의 경우 왼쪽 오른쪽의 보와 현재위치,오른쪽위치 기둥 체크
          map[y][x]-=1;
            if(isRange(x-1,y,map)&&((map[y][x-1]&1)==1)&&!buildBeam(x-1,y,map)){
                 map[y][x]+=1;
                return;
            }
            
            if(isRange(x+1,y,map)&&((map[y][x+1]&1)==1)&&!buildBeam(x+1,y,map)){
                 map[y][x]+=1;
                return;
            }
            
            if(isRange(x,y,map)&&((map[y][x]&2)==2)&&!buildPillar(x,y,map)){
                 map[y][x]+=1;
                return;
            }
            
             if(isRange(x+1,y,map)&&((map[y][x+1]&2)==2)&&!buildPillar(x+1,y,map)){
                  map[y][x]+=1;
                return;
            }
            
           
        }
    }
    //map 상태 이진법 기준 (기둥)(보) 11 이면 둘다 설치된 곳 10 이면 기둥만 설치된곳
    //기둥 설치가능
    boolean buildPillar(int x,int y,int[][] map){
        if(y==0){
            return true;
        }
        if((map[y-1][x]&2)==2||(map[y][x]&1)==1){
            return true;
        }
        if(isRange(x-1,y,map)&&(map[y][x-1]&1)==1){
            return true;
        }
        
        return false;
        
    }
    //보 설치가능
    boolean buildBeam(int x,int y,int[][] map){
        if(isRange(x,y-1,map)&&(map[y-1][x]&2)==2){
            return true;
        }
        
        if(isRange(x+1,y-1,map)&&(map[y-1][x+1]&2)==2){
            return true;
        }
        
        if(isRange(x-1,y,map)&&isRange(x+1,y,map)&&((map[y][x-1]&1)==1)&&((map[y][x+1]&1)==1)){
            return true;
        }
        return false;
    }
    
    boolean isRange(int x,int y,int[][] map){
        if(x<0||y<0)return false;
        
        if(y>=map.length||x>=map[0].length)return false;
        return true;
    }
}