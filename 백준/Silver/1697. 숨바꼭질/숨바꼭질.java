import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int N=Integer.parseInt(stringTokenizer.nextToken());
        int M=Integer.parseInt(stringTokenizer.nextToken());

        int answer=bfs(N,M);
        System.out.println(answer);
    }
    static int bfs(int N,int M){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N,0});
        boolean check[]=new boolean[200000];
        while(!queue.isEmpty()){
            int[] now=queue.poll();
            if(now[0]==M)return now[1];
            int next=now[0]+1;
            if(next<200000&&!check[next]){
                check[next]=true;
                queue.add(new int[]{next,now[1]+1});
            }
             if(now[0]==0)continue;
            next=now[0]-1;
            if(next<200000&&!check[next]){
                check[next]=true;
                queue.add(new int[]{next,now[1]+1});
            }
            next=now[0]*2;
            if(next<200000&&!check[next]){
                check[next]=true;
                queue.add(new int[]{next,now[1]+1});
            }




        }
        return -1;
    }
}
