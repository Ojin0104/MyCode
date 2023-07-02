import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int fuel=Integer.parseInt(st.nextToken());
        int[][] map=new int[N][N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        st=new StringTokenizer(br.readLine());
        int[] now=new int[3];
        now[0]=Integer.parseInt(st.nextToken())-1;
        now[1]=Integer.parseInt(st.nextToken())-1;
        now[2]=0;

        ArrayList<Integer>[] arrive=new ArrayList[N*N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arrive[i*N+j]=new ArrayList<>();
            }
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int s_r=Integer.parseInt(st.nextToken())-1;
            int s_c=Integer.parseInt(st.nextToken())-1;
            int e_r=Integer.parseInt(st.nextToken())-1;
            int e_c=Integer.parseInt(st.nextToken())-1;
            if(map[s_r][s_c]==-1){
                map[s_r][s_c]=(i+2)*-1;
            }else {
                map[s_r][s_c] = i + 2;
            }
            if(map[e_r][e_c]==0)
                map[e_r][e_c]=-1;
            else
                map[e_r][e_c]=Math.abs(map[e_r][e_c])*-1;
            arrive[e_r*N+e_c].add(-(i+2));

        }


        for(int i=0;i<M;i++){
            fuel=taxiOn(map,fuel,now,arrive);
            if(fuel==-1)break;
        }

        System.out.println(fuel);




    }
    static int taxiOn(int[][] map,int fuel,int[] now,ArrayList<Integer>[] arrive){
        int find=0;
        int[] dr={-1,0,0,1};
        int[] dc={0,-1,1,0};

        Queue<int[]> queue=new LinkedList<>();
        queue.add(now);

        boolean[][] check=new boolean[map.length][map.length];

        check[now[0]][now[1]]=true;
        int count = 0;
        if(map[now[0]][now[1]]>1||map[now[0]][now[1]]<-1){
            count++;
            find = Math.abs(map[now[0]][now[1]]) * -1;
        }else {

            int row = Integer.MAX_VALUE;
            int col = Integer.MAX_VALUE;
            int end = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                int[] n = queue.poll();
                if (n[2] > end) break;

                if (map[n[0]][n[1]] > 1 || map[n[0]][n[1]] < -1) {
                    if (n[0] < row || n[1] < col && row == n[0]) {
                        find = Math.abs(map[n[0]][n[1]]) * -1;
                        now[0] = n[0];
                        now[1] = n[1];
                        now[2] = n[2];
                        row = n[0];
                        col = n[1];
                        count++;
                        end = now[2];
                        continue;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int n_r = n[0] + dr[i];
                    int n_c = n[1] + dc[i];

                    if (n_r < 0 || n_c < 0 || n_r >= map.length || n_c >= map.length) {
                        continue;
                    }
                    if (map[n_r][n_c] == 1) {
                        continue;
                    }
                    if (check[n_r][n_c]) continue;
                    queue.add(new int[]{n_r, n_c, n[2] + 1});
                    check[n_r][n_c] = true;
                }




            }
        }
        if(map[now[0]][now[1]]>1)
            map[now[0]][now[1]] = 0;
        else if(map[now[0]][now[1]]<-1)
            map[now[0]][now[1]] = -1;
        fuel-=now[2];

        if(fuel<0||count==0)return -1;

        //System.out.println(fuel);
        now[2]=0;

        queue=new LinkedList<>();
        queue.add(now);
        check=new boolean[map.length][map.length];
        check[now[0]][now[1]]=true;
        count=0;



        while(!queue.isEmpty()){
            int[] n=queue.poll();

            if(map[n[0]][n[1]]<=-1){

               if(arrive[n[0]*map.length+n[1]].contains(find)) {
                   
                   now[0] = n[0];
                   now[1] = n[1];
                   now[2] = n[2];
                   count++;
                   break;
               }

            }
            for(int i=0;i<4;i++){
                int n_r=n[0]+dr[i];
                int n_c=n[1]+dc[i];

                if(n_r<0||n_c<0||n_r>=map.length||n_c>=map.length){
                    continue;
                }
                if(map[n_r][n_c]==1){
                    continue;
                }
                if(check[n_r][n_c])continue;

                queue.add(new int[]{n_r,n_c,n[2]+1});
                check[n_r][n_c]=true;
            }

        }

        fuel-=now[2];
        if(fuel<0||count==0)return -1;


        fuel+=now[2]*2;
        now[2]=0;
        return fuel;
    }

}
