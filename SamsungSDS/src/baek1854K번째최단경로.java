import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek1854K번째최단경로 {//다익스트라구조에서  배열안에 k만큼크기의 우선순위큐를 넣어
//같은정점 여러번 반복되도 되므로check필요 x
    static int n;
    static int m;
    static int k;
    static ArrayList<edge>[] tree;
    static PriorityQueue<Integer>[] pq;//k번째까지만
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        tree=new ArrayList[n+1];
        pq=new PriorityQueue[n+1];
        for(int i=0;i<=n;i++){
            tree[i]=new ArrayList();
            pq[i]=new PriorityQueue<>(Collections.reverseOrder());
        }
        int s;
        int e;
        int w;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            s=Integer.parseInt(st.nextToken());
            e=Integer.parseInt(st.nextToken());
            w=Integer.parseInt(st.nextToken());
            tree[s].add(new edge(e,w));

        }
        checkroute(1);
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1;i<=n;i++){
            if(pq[i].size()==k){
                bw.write(pq[i].peek()+"\n");
            }else{
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
    }
    static class edge implements Comparable<edge>{
        int s;
        int v;
        edge(int s,int v){
            this.s=s;
            this.v=v;
        }


        @Override
        public int compareTo(edge o) {
            return Integer.compare(v,o.v);
        }
    }
    static void checkroute(int n){//모든정점 및 모든 경로를 돌거고

       PriorityQueue<edge> queue=new PriorityQueue<>();
       queue.add(new edge(n,0));
       pq[n].add(0);
       while(!queue.isEmpty()){
           edge now=queue.poll();
//           if(now.v>pq[now.s].peek()){//선택한 간선의 가중치가 도착지점까지의 경로가중치합보다 크면 이미 실행된것 이므로 띄어넘음
//               continue;//->직선거리보다 돌아서 간것이 짧다는 것은 이미 구한값이라서 똑같은거 해줄필요없음
//           }
          // System.out.println(now.v);
           for(edge next:tree[now.s]){
               if(pq[next.s].size()<k){//그냥넣어주면됨
                   pq[next.s].add(now.v+next.v);
                   queue.add(new edge(next.s,now.v+next.v));
               }else if(pq[next.s].peek()>next.v+now.v){
                   pq[next.s].poll();
                   pq[next.s].add(next.v+now.v);
                   queue.add(new edge(next.s,now.v+next.v));
               }
           }
        }
    }

}
