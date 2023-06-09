import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] value;
    static int[] degree;
    static ArrayList<Integer>[] map;
    static int W;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());



        for(int i=0;i<T;i++){

            StringTokenizer st=new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());

            value=new int[N+1];
            degree=new int[N+1];
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){
                value[j]=Integer.parseInt(st.nextToken());
            }
            map=new ArrayList[N+1];
            for(int j=0;j<N+1;j++){
                map[j]=new ArrayList<Integer>();
            }
            for(int j=0;j<K;j++){
                st=new StringTokenizer(br.readLine());
                int s=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());
                map[s].add(v);
                degree[v]++;
            }
            Queue<int[]> que=new LinkedList<>();
            for(int j=1;j<N+1;j++){
                if(degree[j]==0){
                    que.add(new int[]{j,0});
                }
            }
            W=Integer.parseInt(br.readLine());
            pologist(que);
        }
        System.out.println(sb);
    }
    static void pologist(Queue<int[]>que){
        int max=0;
        int[] sum=new int[degree.length];
        while(!que.isEmpty()){
            int[] now=que.poll();

            
            sum[now[0]]=now[1]+value[now[0]];
          
            if(now[0]==W){
                sb.append(sum[now[0]]+"\n");
                return;
            }
            for(int i:map[now[0]]){
                degree[i]--;
                sum[i]=Math.max(sum[i],sum[now[0]]);
                if(degree[i]==0){
                    que.add(new int[]{i,sum[i]});
                }
            }

        }
    }
}
