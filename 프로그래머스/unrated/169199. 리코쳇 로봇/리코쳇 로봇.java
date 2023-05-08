import java.util.*;
class Solution {
    public int solution(String[] board) {
        int answer = 0;
        Queue<Point> que=new LinkedList<>();
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int n=board.length;
        int m=board[0].length();
        int[][] dp=new int[n][m];
    
        Point target=new Point(0,0,0);
        Point start=new Point(0,0,0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i].charAt(j)=='G')
                    target=new Point(i,j,0);
                if(board[i].charAt(j)=='R')
                    start=new Point(i,j,0);
            }
        }
        
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
                    nx+=dx[i];
                    ny+=dy[i];
                    
                    if(nx<0||nx>=n||ny<0||ny>=m||board[nx].charAt(ny)=='D'){
                        if(nx-dx[i]==target.x&&ny-dy[i]==target.y)return now.dist+1;
                        if(dp[nx-dx[i]][ny-dy[i]]==0)
                            que.add(new Point(nx-dx[i],ny-dy[i],now.dist+1));
                        break;  
                    }
                }
            }
        }
        return -1;
    }
    
    class Point{
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

