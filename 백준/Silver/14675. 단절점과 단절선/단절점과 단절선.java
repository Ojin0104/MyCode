import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            graph[i] = new ArrayList<Integer>();
        }
        StringTokenizer st;

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph[s].add(e);
            graph[e].add(s);

        }

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb =new StringBuilder();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());

            if(q==1){
                if(graph[point].size()==1){
                    sb.append("no\n");
                }else{
                    sb.append("yes\n");
                }
            }else{
                sb.append("yes\n");
            }
        }
        System.out.println(sb);
    }
    static class Edge{
        int s;
        int e;

    }
}
