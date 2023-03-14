import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek14502연구소 {
    static class point{
        int y;
        int x;
        public point(int y,int x){
            this.y=y;
            this.x=x;
        }
    }
    static int N;
    static int M;

    static int[] dx={0,1,0,-1};
    static int[] dy={1,0,-1,0};

    static int max_num=Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        int[][] map=new int[N][M];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }


        }
        dfs(0,map);
        System.out.println(max_num);
    }

    static void dfs(int count, int[][] nmap){
        if(count==3){
            //안전영역 크기 구하는 함수
            int [][] new_map=new int[N][M];
            for(int i=0 ; i<N;i++){
                for(int j=0;j<M;j++){

                    new_map[i][j]=nmap[i][j];
                }
            }
            max_num=Integer.max(max_num,safeAreaSize(new_map));

            return ;
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(nmap[i][j]==0){
                    nmap[i][j]=1;
                    dfs(count+1,nmap);
                    nmap[i][j]=0;
                }

            }


        }


    }

    public static int safeAreaSize(int[][] nmap){
        //바이러스 퍼지게 한 후 안전영역의 크기 구함
        int safeArea=0;
        Queue<point> que=new LinkedList<>();
        for(int i=0 ; i<N;i++){
            for(int j=0;j<M;j++){
                if(nmap[i][j]==2)
                    que.add(new point(i,j));
            }
        }

        while(!que.isEmpty()){//바이러스 퍼짐
            point now=que.poll();
            int next;
            int next_y;
            int next_x;

            for(int i=0;i<4;i++){
                next_y=now.y+dy[i];
                next_x=now.x+dx[i];

                if(next_y<0||next_y>=N||next_x<0||next_x>=M)
                    continue;
                next=nmap[next_y][next_x];

                if(next==0){
                    nmap[now.y+dy[i]][now.x+dx[i]]=2;
                    que.add(new point(next_y,next_x));
                }
            }
        }
        for(int i=0 ; i<N;i++){
            for(int j=0;j<M;j++){
                if(nmap[i][j]==0)
                    safeArea++;
            }
        }

        return safeArea;
    }


}
