import java.util.*;
class Solution {
    static int[] dr ={0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        
        initMap(map);
        
        
        int[] answer = new int[queries.length];
        
        for(int idx = 0 ;idx<queries.length;idx++){
            answer[idx] = rotateMap(map,queries[idx]);
        }
        return answer;
    }
    
    int rotateMap(int[][] map, int[] queries){
        int row = queries[0]-1;
        int col = queries[1]-1;
        int dist_r = queries[2]-row-1;
        int dist_c = queries[3]-col-1;
        int answer = Integer.MAX_VALUE;
        
        int next =map[row][col];
        int before = 0;
        for(int dir = 0;dir<4;dir++){
            
            
            if(dir==0||dir==2){
                for(int times=0;times<dist_c;times++){
                    before = next;
                    answer=Math.min(before,answer);
                    row+= dr[dir];
                    col+= dc[dir];
                    next = map[row][col];
                    map[row][col]= before;
                }
            }else{
                for(int times=0;times<dist_r;times++){
                    before = next;
                    answer=Math.min(before,answer);
                    row+= dr[dir];
                    col+= dc[dir];
                    next = map[row][col];
                    map[row][col]= before;
                }
            }
        }
        return answer;
    }
    
    void initMap(int[][] map){
        int count =1;
        for(int x = 0;x<map.length; x++){
            for(int y = 0;y<map[0].length;y++){
                map[x][y]=count++;
            }
        }
    }
}