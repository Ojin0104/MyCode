import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        StringTokenizer st =new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map =new int[N][M];
        visit = new boolean[N][M];
        for(int row = 0; row<N ; row++){
            st = new StringTokenizer(bufferedReader.readLine());

            for(int col = 0; col<M ; col++){
                map[row][col] = Integer.parseInt(st.nextToken());
                if(map[row][col]==0)visit[row][col]=true;
            }
        }



        for(int row = 0; row<N ; row++){
            for(int col = 0; col<M ; col++) {

               if(!visit[row][col]&&dfs(map,row,col,map[row][col])){
                   answer++;
               }


            }
        }

        System.out.println(answer);

    }
    static boolean dfs(int[][] map,int row,int col,int top){

        visit[row][col] = true;
        boolean flag = true;
        for(int r = row-1;r<=row+1;r++){
            for(int c = col-1 ; c<=col+1;c++){

                if(r<0||c<0||r>=map.length||c>=map[0].length)continue;

                if(map[r][c]==0)continue;

                if(top<map[r][c])flag =false;

                if(!visit[r][c]&&map[r][c] ==top ) {
                    if(dfs(map,r,c,top)){
                        visit[r][c] =true;
                    }else{
                        flag =false;
                    }
                }
            }
        }
        return flag;
    }
}
