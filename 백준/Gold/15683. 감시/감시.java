import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int min=Integer.MAX_VALUE;
    static int[] dr={-1,0,1,0};
    static int[] dc={0,1,0,-1};
    static int num=0;
    static ArrayList<CCTV> cctvs;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bufferedReader.readLine());
        cctvs=new ArrayList<CCTV>();
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int[][] map=new int[N][M];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<M;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
                if(map[i][j]!=0&&map[i][j]!=6){
                    num++;
                    cctvs.add(new CCTV(i,j,map[i][j]));
                }
            }
        }
        dfs(map,0);
        System.out.println(min);
    }

    static void dfs(int[][] map,int count){
        if(count==num) {
            int answer = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[0].length; j++) {

                    if (map[i][j] == 0) {
                        answer++;
                    }
                }
            }
            
            min = Math.min(min, answer);

            return;
        }

            CCTV now=cctvs.get(count);
            for(int i=0;i<4;i++){
                int[][] newmap=copyMap(map);
                if(now.type==2&&i>=2){
                    return;
                }else if(now.type==5&&i>=1){
                    return;
                }
                fillMap(newmap,now,i);
                dfs(newmap,count+1);
            }
    }
    static void fillMap(int[][] newmap,CCTV now,int dir){

        if(now.type==1){
            int r=now.r;
            int c=now.c;
            while(true){

                if(r+dr[dir]<0||c+dc[dir]<0||r+dr[dir]>=newmap.length||c+dc[dir]>=newmap[0].length)break;
                if(newmap[r+dr[dir]][c+dc[dir]]==6)break;
                if(newmap[r+dr[dir]][c+dc[dir]]==0)
                    newmap[r+dr[dir]][c+dc[dir]]=now.type;
                r=r+dr[dir];
                c=c+dc[dir];
            }
        }else if(now.type==2) {
            for (int i = 0; i < 2; i++) {

                    int d=(dir+2*i)%4;
                    int r = now.r;
                    int c = now.c;
                    while (true) {
                        if(r+dr[d]<0||c+dc[d]<0||r+dr[d]>=newmap.length||c+dc[d]>=newmap[0].length) break;
                        if (newmap[r + dr[d]][c + dc[d]] == 6) break;
                        if (newmap[r + dr[d]][c + dc[d]] == 0)
                            newmap[r + dr[d]][c + dc[d]] = now.type;
                        r=r+dr[d];
                        c=c+dc[d];
                    }


            }
        }else if(now.type==3){
            for (int i = 0; i < 2; i++) {
                int d=(dir+i)%4;
                int r = now.r;
                int c = now.c;
                while (true) {
                    if(r+dr[d]<0||c+dc[d]<0||r+dr[d]>=newmap.length||c+dc[d]>=newmap[0].length) break;
                    if (newmap[r + dr[d]][c + dc[d]] == 6) break;
                    if (newmap[r + dr[d]][c + dc[d]] == 0)
                        newmap[r + dr[d]][c + dc[d]] = now.type;
                    r=r+dr[d];
                    c=c+dc[d];
                }
            }
        }else if(now.type==4){
            for (int i = 0; i < 3; i++) {
                int d=(dir+i)%4;
                int r = now.r;
                int c = now.c;
                while (true) {
                    if(r+dr[d]<0||c+dc[d]<0||r+dr[d]>=newmap.length||c+dc[d]>=newmap[0].length) break;
                    if (newmap[r + dr[d]][c + dc[d]] == 6) break;
                    if (newmap[r + dr[d]][c + dc[d]] == 0)
                        newmap[r + dr[d]][c + dc[d]] = now.type;
                    r=r+dr[d];
                    c=c+dc[d];
                }
            }
        }else if(now.type==5){
            for (int i = 0; i < 4; i++) {
                int d=(dir+i)%4;
                int r = now.r;
                int c = now.c;
                while (true) {
                    if(r+dr[d]<0||c+dc[d]<0||r+dr[d]>=newmap.length||c+dc[d]>=newmap[0].length) break;
                    if (newmap[r + dr[d]][c + dc[d]] == 6) break;
                    if (newmap[r + dr[d]][c + dc[d]] == 0)
                        newmap[r + dr[d]][c + dc[d]] = now.type;
                    r=r+dr[d];
                    c=c+dc[d];
                }
            }
        }

    }

    static int[][] copyMap(int[][] map){
        int[][] newmap=new int[map.length][map[0].length];
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[0].length;j++){
                newmap[i][j]=map[i][j];
            }
        }
        return newmap;
    }
    static class CCTV{
        int r;
        int c;
        int type;

        public CCTV(int r,int c, int type){
            this.r=r;
            this.c=c;
            this.type=type;
        }
    }
}
