class Solution {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];

        for(int row = 0 ;row<board.length ; row++){
            for( int col = 0; col<board[0].length; col++){
                int count = nearLiveCount(board,row,col);

                if(board[row][col]==1){
                    if(count<2){
                        newBoard[row][col]=0;
                    }else if(count<4){
                        newBoard[row][col]=1;
                    }
                }else{

                    if(count==3){
                        newBoard[row][col]=1;
                    }

                }
            }
        }

        for(int row=0; row<board.length;row++){
            
                board[row] = newBoard[row].clone();
            
        }
    }

    static int nearLiveCount(int[][] board,int row, int col){
        int answer = 0 ;
        for(int r = row-1;r<=row+1;r++){
            if(r< 0|| r>=board.length)continue;
            for(int c = col-1; c<=col+1;c++){
                if(c<0||c>=board[0].length)continue;
                if(r==row && c==col)continue;

                if(board[r][c]==1)answer++;
            }
        }

        return answer;
    }
}