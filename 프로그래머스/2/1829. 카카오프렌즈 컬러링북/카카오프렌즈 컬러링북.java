class Solution {
    static int[] dr = new int[]{1,0,-1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public int[] solution(int m, int n, int[][] picture) {
        
        
        int[][] map = new int[picture.length][picture[0].length];
        int maxArea = 0;
        int count = 0;
        for(int row = 0 ;row< picture.length; row++){
            for(int col = 0; col<picture[0].length; col++){
                if(map[row][col]==0&&picture[row][col]!=0){
                    maxArea = Math.max(maxArea,dfs(map,picture,picture[row][col],row,col));
                    count++;
                }
                    
            }
        }
        
        return new int[]{count,maxArea};
    }
    
    static int dfs(int[][] map ,int[][] picture, int value, int row , int col){
        int count = 1;
        map[row][col] = -1;
        for(int dir = 0; dir<4; dir++){
            int next_r = row+dr[dir];
            int next_c = col+dc[dir];
            
            if(next_r<0||next_c<0||next_r>=map.length||next_c>=map[0].length)continue;
            
            if(map[next_r][next_c]!=0)continue;
            
            if(picture[next_r][next_c]!=value) continue;
            
            count+=dfs(map,picture,value,next_r,next_c);
        }
        
        return count;
    }
}