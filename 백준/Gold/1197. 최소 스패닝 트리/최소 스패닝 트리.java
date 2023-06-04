import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        PriorityQueue<Node> pq=new PriorityQueue<>();
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        parent =new int[V+1];
        for(int i=0;i<V+1;i++){
            parent[i]=i;
        }
        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            pq.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Long.parseLong(st.nextToken())));

        }
        long answer=0;
        while(!pq.isEmpty()){
            Node now=pq.poll();
            if(union(now.s,now.v)){
                answer+=now.g;
            }
        }
        System.out.println(answer);
    }
    static int find(int a){
        if(parent[a]==a)return a;

        return parent[a]=find(parent[a]);
    }

    static boolean union(int a, int b){
        int A=find(a);
        int B=find(b);

        if(A==B)return false;

        if(A<B){
            parent[A]=B;
        }else{
            parent[B]=A;
        }
        return true;
    }
    static class Node implements Comparable<Node> {
        int s;
        int v;
        long g;
        Node(int s,int v,long g){
            this.s=s;
            this.v=v;
            this.g=g;
        }

        

        @Override
        public int compareTo(Node o) {
            if(this.g>o.g){
                return 1;
            }else if(this.g<o.g){
                return -1;
            }
            return 0;
        }
    }
}
