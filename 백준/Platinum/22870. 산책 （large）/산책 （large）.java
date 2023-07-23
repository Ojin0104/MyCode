import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Edge>[] arr;
    static boolean[] check;
    static int[] dists;
    static int[] parents;
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        arr=new ArrayList[N+1];
        check=new boolean[N+1];
        parents=new int[N+1];
        dists=new int[N+1];
        for(int i=0;i<=N;i++){
            arr[i]=new ArrayList<Edge>();
            parents[i]=i;
            dists[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());

            int s=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int dist=Integer.parseInt(st.nextToken());

            arr[s].add(new Edge(v,dist));
            arr[v].add(new Edge(s,dist));
        }
        for(int i=0;i<N;i++){
            Collections.sort(arr[i],(Edge a, Edge b)->a.v-b.v);
        }

        st=new StringTokenizer(br.readLine());

        int start=Integer.parseInt(st.nextToken());
        int end=Integer.parseInt(st.nextToken());

        dikstra(end);
        check=new boolean[N+1];
        int answer=dists[start];
        int now=start;
        int now_dist=0;
        while(now!=end){
            for(Edge e: arr[now]){
                int next_node=e.v;
                int next_dist=e.dist;

                if(now_dist+next_dist+dists[next_node]==dists[start]){
                    now_dist+=next_dist;
                    now=next_node;
                    check[next_node]=true;
                    break;

                }
            }
        }



        check[start]=false;
        check[end]=false;
        Arrays.fill(dists,Integer.MAX_VALUE);
        dikstra(end);

        answer+=dists[start];

        System.out.println(answer);



    }
    static void dikstra(int start){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->(a[1]==b[1])?a[0]-b[0]:a[1]-b[1]);
        pq.add(new int[]{start,0});
        dists[start]=0;

        while(!pq.isEmpty()){
            int now[]=pq.poll();

            int dist=now[1];
            int node=now[0];
            if(check[node])continue;


            check[node]=true;
            if(dists[node]<dist)
                continue;
            for(Edge e:arr[node]){
                if(check[e.v])continue;

                if(dist+e.dist<dists[e.v]){
                    dists[e.v]=dist+e.dist;
                    //parents[e.v]=node;
                    pq.add(new int[]{e.v,dists[e.v]});
                }
            }



        }

    }
    static class Edge{
        int v;
        int dist;
        public Edge(int v,int dist){
            this.v=v;
            this.dist=dist;
        }
    }
}
