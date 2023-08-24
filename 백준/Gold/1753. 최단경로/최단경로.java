import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V;
    static int E;
    static int startpoint;
    static int[] shortest;
    static boolean[] check;
    static ArrayList<edge>[] list;
    static PriorityQueue<point> pq=new PriorityQueue<>(new Comparator<point>() {
        @Override
        public int compare(point o1, point o2) {
            return o1.b>o2.b? 1:-1;
        }
    });
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        startpoint=Integer.parseInt(br.readLine());
        int u,v,w;
        list=new ArrayList[V+1];
        shortest=new int[V+1];
        check=new boolean[V+1];
        for(int i=0;i<V+1;i++){
            list[i]=new ArrayList<>();
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            u=Integer.parseInt(st.nextToken());
            v=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());

            list[u].add(new edge(u,v,w));
        }

        Arrays.fill(shortest,Integer.MAX_VALUE);
        shortest[startpoint]=0;
        pq.add(new point(startpoint,0));

        //startpoint에서 시작해서 우선순위큐 에서 하나씩 빼내며 반복
        while(!pq.isEmpty()){

            point node=pq.poll();
            if(check[node.a]==false){
                check[node.a]=true;
            int start=node.a;
            int weight=node.b;

            for(int i=0;i<list[start].size();i++){
                int end=list[start].get(i).v;
                if(shortest[end]>weight+list[start].get(i).w) {
                    shortest[end] = weight + list[start].get(i).w;
                    pq.add(new point(end, shortest[end]));
                }
            }

            }
        }
        for(int i=1;i<=V;i++){
            if(shortest[i]==Integer.MAX_VALUE){
                System.out.println("INF");
            }else{
                System.out.println(shortest[i]);
            }
        }
    }
    static class edge{
        int u;
        int v;
        int w;
        edge(int u,int v,int w){
            this.v=v;
            this.u=u;
            this.w=w;
        }
    }
    static class point{
        int a;
        int b;
        point(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
}
