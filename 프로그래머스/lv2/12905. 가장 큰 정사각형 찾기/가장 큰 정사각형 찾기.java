class Solution
{
    public int solution(int [][]board)
    {
        int answer = 1;
        int count=0;
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==0){
                    count++;
                    continue;
                }
                if(i==0||j==0)continue;
                board[i][j]=Math.min(Math.min(board[i-1][j],board[i][j-1]),board[i-1][j-1])+1;
                answer=Math.max(board[i][j],answer);
            }
        }
       if(count==board.length*board[0].length)return 0;
        return (int)Math.pow(answer,2);
    }
}