class Solution {
    static int[] dr ={1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public int numIslands(char[][] grid) {
        int answer =0 ;
        for(int row = 0; row< grid.length; row++){
            for(int col = 0; col <grid[0].length; col++){
                if(grid[row][col]=='1'){
                    answer++;
                    dfs(row,col,grid);
                }
            }
        }

        return answer;
    }

    static void dfs(int row, int col, char[][] grid){
        grid[row][col] ='2';
        for(int dir =0 ;dir<4 ; dir++){
            int next_r = row+dr[dir];
            int next_c= col+dc[dir];

            if(next_r<0 || next_r>=grid.length || next_c<0 || next_c >=grid[0].length)continue;

            if(grid[next_r][next_c] =='1'){
                dfs(next_r,next_c,grid);
            }
        }
    }
}