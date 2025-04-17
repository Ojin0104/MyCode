import java.util.*;
class Solution {
    static int[] dr = new int[]{1,0,-1,0};
    static int[] dc = new int[]{0,-1,0,1};
    static int answer = Integer.MAX_VALUE;
    public int solution(int[][] board, int r, int c) {
        Position[][] map =new Position[7][2];
        
        initMap(board,map);
        boolean[] visit = new boolean[7];
        // System.out.println(calcShortTimes(board, new Position(0,0),new Position(0,3)));
        dfs(board,map,new Position(r,c), 0,0 ,visit);
        return answer;
    }
    
    void dfs(int[][] board, Position[][] map,Position now, int times, int idx, boolean[] visit){
        if(idx==6){
            answer = Math.min(times,answer);
            return;
        }
        
        for(int num=1; num<=6; num++){
            if(visit[num])continue;
            
            visit[num] = true;
            
            if(map[num][0]==null){
                dfs(board,map,now, times,idx+1,visit);
                visit[num] = false;
                continue;
            }
            
            Position firstCard = map[num][0];
            Position secondCard = map[num][1];
            int count = calcShortTimes(board, firstCard,secondCard);
            int firstCount = calcShortTimes(board, now,firstCard);
            //0에서 1로
            setBoard(board,firstCard,secondCard,0);
            dfs(board,map,secondCard, times+ count + firstCount+2,idx+1,visit);
            setBoard(board,firstCard,secondCard,num);
            
            //1에서 0으로
            count = calcShortTimes(board, secondCard,firstCard);
            int secondCount = calcShortTimes(board, now,secondCard);
                
            setBoard(board,firstCard,secondCard,0);
            dfs(board,map,firstCard, times+count+secondCount+2,idx+1,visit);
            setBoard(board,firstCard,secondCard,num);
            
            visit[num] = false;
        }
    }
    
    public void setBoard(int[][] board,Position first, Position second, int num){
        board[first.row][first.col] = num;
        board[second.row][second.col] = num;
    }
    
    public int calcShortTimes(int[][] board, Position first, Position second){
        
        Queue<Position> que = new LinkedList<>();
        que.add(first);
        boolean visit[][] = new boolean[board.length][board[0].length];
        
        visit[first.row][first.col]=true;
        while(!que.isEmpty()){
            Position now = que.poll();
            if(now.row== second.row && now.col ==second.col){
                return now.times;
            }
                for(int idx = 0; idx<4; idx++){
                int nextR = now.row + dr[idx];
                int nextC = now.col + dc[idx];
                
                if(nextR <0 || nextR >=board.length || nextC <0 || nextC >=board[0].length)continue;
                if(!visit[nextR][nextC]){
                que.add(new Position(nextR,nextC,now.times+1));
                visit[nextR][nextC] = true;
                }
                while(board[nextR][nextC]==0){
                    int n_r = nextR+dr[idx];
                    int n_c = nextC+dc[idx];
                    
                    if(n_r<0 ||n_c<0 || n_r>=4 || n_c>=4)break;
                    
                    nextR = n_r;
                    nextC = n_c;
                }
                if(visit[nextR][nextC])continue;
                que.add(new Position(nextR,nextC,now.times+1));
                visit[nextR][nextC] = true;
            }
            
        }
        return 0;
    }
        
    
    
    public void initMap(int[][]board, Position[][] map){
        for(int row = 0 ;row<board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if(board[row][col]==0)continue;
                int num = board[row][col];
                if(map[num][0] == null){
                    map[num][0] = new Position(row,col);
                }else{
                    map[num][1] = new Position(row,col);
                }
            }
        }
    }
    
    class Position{
        int row;
        int col;
        int times;
        public Position(int row, int col){
            this.row = row;
            this.col = col;
            this.times =0;
        }
        
        public Position(int row, int col, int times){
            this.row = row;
            this.col = col;
            this.times = times;
        }
    }
}