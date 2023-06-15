import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        ArrayList<Integer>[] map=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            map[i]=new ArrayList<>();
        }
        answer=new int[N+1];
        check=new boolean[N+1];
        for(int i=0;i<N-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());

            int s=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            map[s].add(v);
            map[v].add(s);
        }

        dfs(map,1);
        StringBuilder sb=new StringBuilder();
        for(int i=2;i<N+1;i++){
            sb.append(answer[i]+"\n");
        }
        System.out.println(sb);
    }


    static void dfs( ArrayList<Integer>[] map,int now){
        check[now]=true;
        for(int i:map[now]){
            if(!check[i]) {
                answer[i] = now;
                dfs(map, i);
            }
        }
    }
}
