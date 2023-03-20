import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek14940쉬운최단거리 {

    static int n;
    static int m;
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n=Integer.parseInt(stringTokenizer.nextToken());
        m=Integer.parseInt(stringTokenizer.nextToken());
        int[][] map=new int[n][m];
        boolean[][] check=new boolean[n][m];
        Queue<Point> queue = new LinkedList<>();
        int[][] dist=new int[n][m];

        for(int i=0;i<n;i++){
            stringTokenizer=new StringTokenizer(bufferedReader.readLine());

            for(int j=0;j<m;j++){
                map[i][j]=Integer.parseInt(stringTokenizer.nextToken());


                if(map[i][j]==2) {
                    queue.add(new Point(i, j, 0));
                    check[i][j] = true;
                }
            }
        }
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};
        int next_x;
        int next_y;
        while(!queue.isEmpty()){
            Point now=queue.poll();


            dist[now.x][now.y]=now.dist;

            for(int i=0;i<4;i++){
                next_x=now.x+dx[i];
                next_y=now.y+dy[i];
                if(next_x<0||next_x>=n||next_y<0||next_y>=m)continue;
                if(!check[next_x][next_y]&&map[next_x][next_y]!=0){
                    queue.add(new Point(next_x,next_y,now.dist+1));
                    check[next_x][next_y]=true;
                }

            }


        }


    StringBuilder stringBuilder = new StringBuilder();
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(map[i][j]==1&&!check[i][j])
                stringBuilder.append(-1+" ");
            else
                stringBuilder.append(dist[i][j]+" ");
        }
        stringBuilder.append("\n");
    }
    System.out.println(stringBuilder.toString());
    }
}
class Point{
    int x;
    int y;
    int dist;

    public Point(int x, int y, int dist){
        this.x=x;
        this.y=y;
        this.dist=dist;
    }
}
