import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static String[] map;
    static int max=0;
    static int R;
    static int C;
    static int[] dx={0,1,-1,0};
    static int[] dy={1,0,0,-1};
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        map=new String[R];

        for(int i=0;i<R;i++){

            map[i]=br.readLine();
        }
        boolean[] check=new boolean[26];
        check[map[0].charAt(0)-'A']=true;
        dfs(check,0,0,0);
        System.out.println(max);
    }
    static void dfs(boolean[] check,int x, int y,int num){


        int next_x;
        int next_y;
        for(int i=0;i<4;i++){
            next_x=x+dx[i];
            next_y=y+dy[i];
            if(next_x<0||next_x>=R||next_y<0||next_y>=C)continue;

            if(check[(map[next_x].charAt(next_y)-'A')]){
                max=Math.max(max,num+1);
                continue;
            }
            check[(map[next_x].charAt(next_y)-'A')]=true;
            dfs(check,next_x,next_y,num+1);
            check[(map[next_x].charAt(next_y)-'A')]=false;
        }

    }
}
