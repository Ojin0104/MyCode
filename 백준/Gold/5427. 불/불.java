import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w;
    static int h;
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            w=Integer.parseInt(st.nextToken());
            h=Integer.parseInt(st.nextToken());

            char[][] map=new char[h][w];
            check=new boolean[h][w];
            int s_x=0;
            int s_y=0;
            for(int j=0;j<h;j++){
                String str=br.readLine();
                map[j]=str.toCharArray();
            }
        Queue<int[]> que=new LinkedList<>();
            for(int j=0;j<h;j++){
                for(int k=0;k<w;k++){
                    if(map[j][k]=='@'){
                        s_x=j;
                        s_y=k;
                    }else if(map[j][k]=='*'){
                        que.add(new int[]{j,k,0});
                    }
                }
            }
            que.add(new int[]{s_x,s_y,1});
            check[s_x][s_y]=true;
            map[s_x][s_y]='.';
            bfs(que,map);


        }
    }
    static void bfs(Queue<int[]> que,char[][] map){
        int[] dr={0,1,0,-1};
        int[] dc={1,0,-1,0};
        while(!que.isEmpty()){
            int[] now=que.poll();

            for(int i=0;i<4;i++){
                int next_r=now[0]+dr[i];
                int next_c=now[1]+dc[i];
                if(next_r>=h||next_c>=w||next_r<0||next_c<0){
                    if(now[2]!=0){
                        System.out.println(now[2]);
                        return;
                    }
                    continue;
                }
                if(map[next_r][next_c]!='.')continue;
                if(now[2]==0){
                    map[next_r][next_c]='*';
                    que.add(new int[]{next_r,next_c,now[2]});
                }else{
                    if(check[next_r][next_c])continue;
                    check[next_r][next_c]=true;
                    que.add(new int[]{next_r,next_c,now[2]+1});
                }

            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
