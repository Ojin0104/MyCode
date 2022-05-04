import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek11400_단절선 {//선을 없앴을때 트리가 끊어져야함 -> A에서 B로갈때 경로가 하나인 경우 ,1. 간선이 하나밖에없는 정점의 경우 2. 단절점 이 연결되어있는경
    static int V;           //다른방법 모든 간선 하나씩 제거하면서 dfs진행 모든 노드를 지나지 않앗다 -> 단절선이다.O((E+V)E)
    static int E;           //연결그래프이다 -> 루트노드에서 정점V번반복해서 루트노드에서 가는 경우의수 구하고 count가 2이상일경우 스킵
    //간선 반복 하면서  A B를 볼때 A와 연결되는 다른 정점에서 B로 가는지 확인 하나라도 간다면 ->절단선xx
    //인접행렬을 인접 리스트로 바꾸기
    static int count;//단절선갯수
    static ArrayList<Integer>[] Map;
    static ArrayList<Integer>[] useedge;
    static boolean[] check;
    static edge[] edgecheck;
    //static boolean[][] edgecheck;
    static int checknum;
    static StringBuilder sb;
    static int result = 0;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        check = new boolean[V + 1];
        Map = new ArrayList[V + 1];
        useedge = new ArrayList[V + 1];
        edgecheck = new edge[V + 1];
        for (int i = 0; i < V + 1; i++) {
            Map[i] = new ArrayList();
            useedge[i] = new ArrayList();

        }
        //edgecheck=new HashMap<>();
        //edgecheck=new boolean[V+1][V+1];
        int u;
        int v;
        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
//System.out.println("여긴 간선추가");
            Map[u].add(v);// 간선 추가
            Map[v].add(u);
        }
        int vertexnum;
        sb = new StringBuilder();
        int end;
        for (int i = 1; i < V + 1; i++) {
            dfss(i);//i는 시작점 true는 루트노드확인
        }


        bw.write(result + "\n");
        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }

    public static class edge {
        int s;
        int e;
        int order;

        edge(int s, int e) {
            this.s = s;
            this.e = e;

        }
    }

    static int dfss(int now) {
        checknum++;//방문순서 dfs들어갈때마다 올려줌 몇번째간선인지
        check[now] = true;
        int low;
        int result = checknum;
        for (int next : Map[now]) {

            if (!useedge[now].contains(next)) {//아직방문하지 않은 곳
                     System.out.println(now+" "+next);
                useedge[now].add(next);// 간선 추가
                useedge[next].add(now);//사용 간선확인
                if (now > next)
                    edgecheck[checknum] = new edge(next, now);//간선 order정해줌
                else
                    edgecheck[now] = new edge(now, next);
                low = dfss(next);

                if (low >= result) {//단절선조건
                    count++;
                    if (now > next)
                        sb.append(next + " " + now + "\n");
                    else
                        sb.append(now + " " + next + "\n");
                }
                result = Math.min(low, result);

            } else {
                int order;
                if (now > next) {
                    order = Arrays.binarySearch(edgecheck, new edge(next, now));
                } else {
                    order = Arrays.binarySearch(edgecheck, new edge(now, next));
                }
                result = Math.min(order, result);
            }

        }
        return result;

    }
}
//
//ordernum++;//방문순서 dfs들어갈때마다 올려줌
//        order[now]=ordernum;
//        int low;
//        int result=ordernum;
//
//        int child=0;
//
//        for(int next: Map[now]){
//        if(order[next]==0){//아직방문하지 않은 곳
//        child++;
//        if(isRoot){
//        System.out.println("childnum"+next);
//        }
//        low=dfs(next,false);
//
//        if(isRoot==false&&low>=order[now]){//단절점조건
//        isCutVertex[now]=true;
//        }
//        result=Math.min(result,low);
//
//        }else{//이미 방문한노드는 dfs실행하지않고 방문한노드 순서 값만 가져온다.
//        result=Math.min(result,order[next]);
//        }
//        }
//        if(isRoot==true&&child>=2){
//        System.out.println(child);
//        System.out.println(now);
//        isCutVertex[now]=true;
//        }
//
//        return result;
