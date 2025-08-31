class Solution {

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public boolean exist(char[][] board, String word) {
        
        for(int row = 0; row<board.length; row++){
            for(int col = 0 ;col<board[0].length; col++){
                boolean[][] visit = new boolean[board.length][board[0].length];
                visit[row][col] = true;
                if(dfs(board,word,row, col, 0,visit))return true;
                visit[row][col] = false;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int row, int col, int idx, boolean[][] visit){
        boolean status = false;
        if(word.charAt(idx) != board[row][col])return false;
        
        if(idx == word.length()-1) return true;


        for(int dir = 0; dir<4; dir++){
            int nextRow = row+dr[dir];
            int nextCol = col + dc[dir];

            if(nextRow <0 || nextCol<0 || nextRow>board.length-1 || nextCol> board[0].length-1)continue;
            if(visit[nextRow][nextCol])continue;
            visit[nextRow][nextCol] = true;
            if(dfs(board,word,nextRow,nextCol,idx+1,visit)){
                return true;
            }
            visit[nextRow][nextCol] = false;
        }

        return status;

    }
}