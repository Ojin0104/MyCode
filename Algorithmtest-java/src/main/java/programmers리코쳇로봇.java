import java.util.LinkedList;
import java.util.Queue;

public class programmers리코쳇로봇 {
    public static void main(String args[]){
        String[] board={".D.R","....",".G..","...D"};
        System.out.println(solution(board));
    }
    public static int solution(String[] board) {
        int answer = 0;
        Queue<Point> que=new LinkedList<>();
        Point target=new Point(0,0,0);
        Point start=new Point(0,0,0);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                if(board[i].charAt(j)=='G')
                    target=new Point(i,j,0);
                if(board[i].charAt(j)=='R')
                    start=new Point(i,j,0);
            }
        }
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int[][] dp=new int[board.length][board[0].length()];
        que.add(start);
        while(!que.isEmpty()){
            Point now=que.poll();
            if(dp[now.x][now.y]!=0)continue;
            dp[now.x][now.y]=now.dist;
            int x=now.x;
            int y=now.y;


            for(int i=0;i<4;i++){
                int nx=x;
                int ny=y;
                while(true){
                    System.out.println(now.x+" "+now.y+" "+i);
                    nx+=dx[i];
                    ny+=dy[i];

                    if(nx<0||nx>=board.length||ny<0||ny>=board[0].length()||board[nx].charAt(ny)=='D'){
                        if(nx==target.x&&ny==target.y)return now.dist+1;
                        if(dp[nx-dx[i]][ny-dy[i]]==0)
                            que.add(new Point(nx-dx[i],ny-dy[i],now.dist+1));
                        break;


                    }
                }
            }
        }
        return -1;

    }
    static class Point{
        int x;
        int y;
        int dist;
        public Point(int x,int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
    }
}


