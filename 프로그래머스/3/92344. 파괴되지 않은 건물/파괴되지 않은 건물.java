class Solution {
    public int solution(int[][] board, int[][] skill) {
        //부분합
        int[][] sum = new int[board.length+1][board[0].length+1];
        
        for(int[] command : skill){
            if(command[0]==1){
                //공격
                update(sum,command[1],command[2],command[3],command[4],command[5]*-1);
            }else if(command[0] ==2){
                //회복
                update(sum,command[1],command[2],command[3],command[4],command[5]);
            }
        }
        
        
        int answer = countDestroy(sum,board);
        return answer;
    }
    
    public int countDestroy(int[][] sum, int[][] board){
        
        
        int count = 0 ;
        for(int row = 0 ; row<sum.length; row++){
            for (int col = 1 ;col<sum[0].length;col++){
                sum[row][col] +=sum[row][col-1];
            }
        }
        
        for(int col = 0 ; col<sum[0].length; col++){
            for (int row = 1 ;row<sum.length;row++){
                sum[row][col] +=sum[row-1][col];
            }
            
        }
        
        for(int row = 0 ; row<board.length; row++){
            for(int col = 0 ; col<board[0].length; col++){
                if(board[row][col]+sum[row][col]>0)count++;
            }
        }
        
        return count;
    }
    
    public void update(int[][] sum,int r1, int c1, int r2, int c2, int degree){
        sum[r2+1][c2+1]+=degree;
        
        sum[r1][c1] +=degree;
        sum[r1][c2+1] -= degree;
        sum[r2+1][c1] -= degree;
    }
    
    
}