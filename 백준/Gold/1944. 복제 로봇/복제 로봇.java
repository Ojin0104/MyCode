import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[] map;
    static boolean[][] robotCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        map=new String[N];
        int[] start=new int[2];
        robotCheck=new boolean[N][N];
        for(int i=0;i<N;i++){
            map[i]=br.readLine();
            for(int j=0;j<N;j++){
                if(map[i].charAt(j)=='S'){
                    start[0]=i;
                    start[1]=j;
                }
            }
        }
        ArrayList<int[]> arr=new ArrayList<>();
        arr.add(start);
        int answer=0;
        int size=0;
        for(int i=0;i<M;i++){
            size=bfs(arr,N);
            if(size==-1){
                System.out.println(-1);
                return;
            }
            
            answer+=size;
        }
        System.out.println(answer);

    }
    static int bfs(ArrayList<int[]>arr,int N){
        Queue<int[]> que=new LinkedList<>();
        int[] dx={1,0,-1,0};
        int[] dy={0,1,0,-1};
        for(int[] robot:arr){
           que.add(new int[]{robot[0],robot[1],0});
        }
        boolean[][] check=new boolean[N][N];
        while(!que.isEmpty()){
            int[] now=que.poll();

            for(int i=0;i<4;i++){
                int next_x=now[0]+dx[i];
                int next_y=now[1]+dy[i];
                if(next_x<0||next_y<0||next_x>=N||next_y>=N||check[next_x][next_y])continue;
                if(map[next_x].charAt(next_y)=='1')continue;

                if(map[next_x].charAt(next_y)=='K'&&!robotCheck[next_x][next_y]){
                    arr.add(new int[]{next_x,next_y});
                    robotCheck[next_x][next_y]=true;
                    return now[2]+1;
                }
                que.add(new int[]{next_x,next_y,now[2]+1});
                check[next_x][next_y]=true;
            }

        }
        return -1;
    }

}
