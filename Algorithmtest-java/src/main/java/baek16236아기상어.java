import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek16236아기상어 {
    static int N;
    static int babysize;
    public static void main(String args[]) throws IOException {

        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int answer=0;
        babysize = 2;
        int babyfeed=0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] map = new int[N][N];
        Point baby = new Point(0, 0, 0);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){
                    baby = new Point(i, j, 0);
                    map[i][j]=0;
                }
            }
        }


        while (true) {

            Queue<Point> que = new LinkedList<>();
            que.add(baby);
            ArrayList<Point> caneat=new ArrayList<>();
            boolean[][] check=new boolean[N][N];
            int max=Integer.MAX_VALUE;
            while (!que.isEmpty()) {

                Point now = que.poll();

                if(now.dist>max)break;
                if(check[now.x][now.y])continue;

                check[now.x][now.y]=true;

                if(map[now.x][now.y]!=0&&map[now.x][now.y]<babysize){//먹방

                                caneat.add(now);
                                max=now.dist;
                                continue;
                        }
                for (int i = 0; i < 4; i++) {
                    int n_x = now.x + dx[i];
                    int n_y = now.y + dy[i];

                    if (mapcheck(n_x, n_y, map,check)) {//범위&&물고기크기 체크
                        que.add(new Point(n_x,n_y,now.dist+1));
                    }
                }
            }
            if(caneat.isEmpty())break;
            Collections.sort(caneat);
            Point feed=caneat.get(0);
            babyfeed++;
            if(babyfeed==babysize){
                babysize++;
                babyfeed=0;
            }
            map[feed.x][feed.y]=0;
            answer+=feed.dist;
            baby=new Point(feed.x,feed.y,0);

            //가장 위이고 왼쪽에 있는 묽괴먹음
            //그냥 자기자신에서 bfs로 가장가까운애 arraylist에 넣어줌
            //구하고 sort해줌 앞에꺼 먹으면됨 먹을떄 마다 새로 거리구해야함
            //

        }
        System.out.print(answer);
    }
    static boolean mapcheck(int n_x, int n_y, int[][] map,boolean[][] check){
        if(n_x<0||n_y<0||n_x>=N||n_y>=N)return false;

        if(map[n_x][n_y]>babysize||check[n_x][n_y])return false;

        return true;
    }
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dist;
        Point(int x, int y,int dist){
            this.x=x;
            this.y=y;
            this.dist=dist;
        }
        @Override
        public int compareTo(Point o) {
            if(o.x==this.x){
                return this.y-o.y;
            }
            return this.x-o.x;
        }
    }
}
