import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {//다익스트라
    static int money;
    static int[][] map;

    static int answer=Integer.MAX_VALUE;
    static boolean[] check;
    static int[] shortest;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());
        money=Integer.parseInt(st.nextToken());
        check=new boolean[N+1];
        map=new int[N+1][N+1];
        shortest=new int[N+1];
        Arrays.fill(shortest,1000000);
        for(int i=0;i<N+1;i++){
            for(int j=0;j<N+1;j++){
                map[i][j]=1000000;
            }
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            int cost=Integer.parseInt(st.nextToken());
            map[s][e]=cost;
            map[e][s]=cost;
        }
        dikstra(start,end);
        if(answer==Integer.MAX_VALUE)answer=-1;
        System.out.println(answer);

    }

    static void dikstra(int start,int end){
        PriorityQueue<int[]> pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        pq.add(new int[]{start,0,0});//노드, shortest, 최대수치심
        shortest[start]=0;
        while(!pq.isEmpty()){
            int[] now=pq.poll();
      
            if(now[1]>money){
                return;
            }
            if(now[0]==end){
                    answer = Math.min(now[2],answer);
            }

            if(check[now[0]])continue;
            check[now[0]]=true;
            for(int i=1;i<map.length;i++){

                
                if(shortest[i]>map[now[0]][i]+shortest[now[0]]){
                    shortest[i]=map[now[0]][i]+shortest[now[0]];
                    pq.add(new int[]{i,shortest[i],Math.max(now[2],map[now[0]][i])});
                    
                }
            }
        }
    }
}
