
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[] start = new int[2];
        int[] end = new int[2];
        boolean flag = false;
        char[][] map = new char[H][W];
        int[][][] dist = new int[H][W][4];

        int[] dr = {0,-1,0,1};
        int[] dc = {1,0,-1,0};
        for(int row = 0;row<H;row++){
            String str = br.readLine();

            for(int col = 0; col<W;col++) {
                map[row][col] = str.charAt(col);
                if(map[row][col]=='C'){
                    if(!flag){
                        start[0] = row;
                        start[1] = col;
                        flag=true;
                    }else{
                        end[0] = row;
                        end[1] = col;
                    }
                }
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                for(int k = 0; k<4;k++){
                dist[i][j][k] = Integer.MAX_VALUE;
            }}
        }

        PriorityQueue<Status> pq =new PriorityQueue<>((o1,o2)->o1.times-o2.times);
        dist[start[0]][start[1]][0] = 0;
        dist[start[0]][start[1]][1] = 0;
        dist[start[0]][start[1]][2] = 0;
        dist[start[0]][start[1]][3] = 0;

        for(int dir = 0;dir<4;dir++){
            int next_r = start[0]+dr[dir];
            int next_c = start[1] +dc[dir];

            if(next_r<0||next_r>=H||next_c<0||next_c>=W){
                continue;
            }
            if(map[next_r][next_c]=='*')continue;

            pq.add(new Status(next_r,next_c,0,dir));
            dist[next_r][next_c][dir] = 0;
        }

        while(!pq.isEmpty()){
            Status now = pq.poll();
            if(now.row==end[0]&& now.col ==end[1]){
                System.out.println(now.times);
                return;
            }
            if(dist[now.row][now.col][now.dir]<now.times){
                continue;
            }


            for(int dir = 0; dir<4;dir++){
                int next_r = now.row+dr[dir];
                int next_c = now.col +dc[dir];

                if(next_r<0||next_r>=H||next_c<0||next_c>=W){
                    continue;
                }
                if(map[next_r][next_c]== '*')continue;

                if(dir==now.dir){
                    if(dist[next_r][next_c][dir]>now.times){
                        pq.add(new Status(next_r,next_c,now.times,dir));
                        dist[next_r][next_c][dir] = now.times;
                    }
                }else if(dir==now.dir%2) {
                }else{
                        if(dist[next_r][next_c][dir]>now.times+1){
                            pq.add(new Status(next_r,next_c,now.times+1,dir));
                            dist[next_r][next_c][dir] = now.times+1;
                        }
                    }
                }

            }


        }




    static class Status{
        int row;
        int col;
        int times;
        int dir;//0은 좌우 1은 위아래

        public Status(int row, int col, int times, int dir){
            this.row = row;
            this.col = col;
            this.times = times;
            this.dir = dir;
        }
    }
}
