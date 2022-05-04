import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek2252 {
    static int N;
    static int M;

    static List<node> node=new ArrayList<>();
    static Queue<Integer> q=new LinkedList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        for(int i=0;i<N+1;i++)
            node.add(new node());//노드추가
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            node.get(s).addedge(s,e);
            node.get(e).hasnode++;//각학생들이 가진 간선수
        }
        for(int i=1;i<N+1;i++){
            if(node.get(i).hasnode==0){//가장작은사람부터 시작
                q.add(i);
            }
        }
        int num;

        while(!q.isEmpty()){
            num=q.poll();
            System.out.print(num+" ");
            for(int i=0;i<node.get(num).edges.size();i++){
                    node.get(node.get(num).edges.get(i).e).hasnode--;
                    if(node.get(node.get(num).edges.get(i).e).hasnode==0)
                        q.add(node.get(num).edges.get(i).e);
                }

            }

        }
        ////위상정렬 사용 큐를 이용하여 0 번째 부터 뺴내고 그것의 인접한 것들을 -1


    static class edge{
        int s;
        int e;
        edge(int s, int e){
            this.s=s;
            this.e=e;
        }
    }
    static class node{
        ArrayList<edge> edges=new ArrayList<>();
        int hasnode;
        node(){
            hasnode=0;
        }
        void addedge(int s,int e){
            edges.add(new edge(s,e));
        }
    }

}


//public class Main {//줄 세우기 인접리스트 방식으로 함
//    static int N,M;
//    static int[] InDegrees;
//    static ArrayList<Integer> [] Map;
//
//    public static void main(String[] args) throws Exception{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        Map = new ArrayList[N+1];
//        InDegrees = new int[N+1];
//        for (int i = 1; i <= N; i++) {
//            Map[i] = new ArrayList<>();
//        }
//        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
//        int from, to;
//        for (int i = 1; i <= M; i++) {
//            st = new StringTokenizer(br.readLine()," ");
//            from = Integer.parseInt(st.nextToken());
//            to = Integer.parseInt(st.nextToken());
//            Map[from].add(to);
//            InDegrees[to]++;
//        }
//        for (int i = 1; i <= N; i++) {
//            if(InDegrees[i] == 0){
//                dq.addLast(i);
//            }
//        }
//        int seq = 0;
//        StringBuilder sb = new StringBuilder();
//        while(dq.isEmpty() == false){
//            int now = dq.pollLast();
//            seq++;
//            if(seq ==N){
//                sb.append(now);
//            }else {
//                sb.append(now);
//                sb.append(" ");
//            }
//            for(int next : Map[now]){
//                if(InDegrees[next] > 0){
//                    InDegrees[next]--;
//                    if(InDegrees[next] == 0){
//                        dq.addLast(next);
//                    }
//                }
//            }
//        }
//        System.out.println(sb.toString());
//
//    }
//
//}
