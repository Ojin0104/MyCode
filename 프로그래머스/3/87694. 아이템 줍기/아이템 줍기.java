class Solution {
    static int itemTimes = 0;
    static int[] dr =new int[]{1,0,-1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        boolean[][] check = new boolean[102][102];
        int[][] map = new int[102][102];
        for(int[] rect: rectangle){
            makeRoad(map,rect);
        }
        map[itemX*2][itemY*2] = 5;
        check[characterX*2][characterY*2] = true;
        int total = dfs(map,check,characterX*2,characterY*2);
        
        return Math.min(total-itemTimes,itemTimes)/2;
        //전체 테두리 길이 - item 마주친 거리, item 마주친 거리 중 큰값 
    }
    public int dfs(int[][] map, boolean[][] check, int x, int y){
            int answer = 1;
        for(int idx = 0 ;idx<4;idx++){
            int nextR = x+dr[idx];
            int nextC = y+dc[idx];
            
            if(check[nextR][nextC])continue;
            
            if((map[nextR][nextC]==1||map[nextR][nextC]==5) && isEdge(map,nextR,nextC)){
                check[nextR][nextC] = true;
                answer+= dfs(map,check,nextR,nextC);
                
                break;
            }
            
        }
        if(map[x][y] ==5) itemTimes = answer;
        return answer;
    }
    
    public boolean isEdge(int[][] map, int row, int col){
        for(int dx = -1; dx<=1;dx++){
            for(int dy= -1;dy<=1;dy++){
                int nextR = row+dx;
                int nextC = col+dy;
            
                if(map[nextR][nextC]==0)return true;
            }
        }
        
        return false;
    }
    
    public void makeRoad(int[][] map , int[] rect){
        int rowStart = rect[0]*2;
        int colStart = rect[1]*2;
        int rowEnd = rect[2]*2;
        int colEnd = rect[3]*2;
        
        for(int row = rowStart ; row<=rowEnd ; row++){
            for(int col = colStart ; col <=colEnd; col++){
                map[row][col] = 1;
            }
        }
    }
}