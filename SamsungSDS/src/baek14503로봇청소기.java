import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14503로봇청소기 {

    static int d;
    static int[] dy={-1,0,1,0};
    static int[] dx={0,1,0,-1};
    static int count=0;
    static int N;
    static int M;

    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int i=Integer.parseInt(st.nextToken());
        int j=Integer.parseInt(st.nextToken());

        d=Integer.parseInt(st.nextToken());

        int[][] map= new int[N][M];
        for(int y=0;y<N;y++){
            st=new StringTokenizer(br.readLine());
            for(int x=0;x<M;x++){
                    map[y][x]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(i,j,map);

        System.out.println(count);

    }
    static void dfs(int i,int j,int[][] map){

        if(map[i][j]==0){
            map[i][j]=2;
            count++;
        }
        int n_y;
        int n_x;

        for(int x=1;x<5;x++){
            int dir=(d-x+4)%4;
            n_y=dy[dir]+i;
            n_x=dx[dir]+j;
            if(n_y<0||n_x<0||n_y>=N||n_x>=M)
                continue;
            if(map[n_y][n_x]==0){
                d=dir;
                dfs(n_y,n_x,map);
                return;
            }
            //if(x==3)return;
        }
        n_y=-dy[d]+i;
        n_x=-dx[d]+j;
        if(n_y<0||n_x<0||n_y>=N||n_x>=M)
            return;
        if(map[n_y][n_x]==1)
            return;
        dfs(n_y,n_x,map);//후진

    }
}
