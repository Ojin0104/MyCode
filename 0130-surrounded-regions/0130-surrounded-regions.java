class Solution {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};

    public void solve(char[][] board) {
        
        for(int row = 0; row<board.length; row++){
            if(board[row][0] == 'O')dfs(board,row,0);
            if(board[row][board[0].length-1] == 'O')dfs(board,row,board[0].length-1);
        }

        for(int col = 0; col<board[0].length; col++){
            if(board[0][col] == 'O')dfs(board,0,col);
            if(board[board.length-1][col] == 'O')dfs(board,board.length-1,col);
        }


        for(int row =0; row<board.length; row++){
            for(int col = 0 ; col<board[0].length; col++){
                if(board[row][col] =='O')board[row][col]='X';
                if(board[row][col] =='K') board[row][col] ='O';
            }
        }

    }

    public void dfs(char[][] board, int row, int col){
        board[row][col] ='K';

        for(int dir =0; dir<4; dir++){
            int nextRow = row+ dr[dir];
            int nextCol = col + dc[dir];

            if(nextRow<0 || nextCol <0 || nextRow>=board.length || nextCol >= board[0].length)continue;
            if(board[nextRow][nextCol] =='X' || board[nextRow][nextCol] == 'K')continue;

            dfs(board,nextRow,nextCol);
            
        }
    }
}