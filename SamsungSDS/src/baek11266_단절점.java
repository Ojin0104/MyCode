import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek11266_단절점 {
    static int V;
    static int E;
    static ArrayList<Integer>[] Map;
    static boolean[] isCutVertex;
    static int[] order;
    static int ordernum=0;
    static int vertexnum=0;
    static StringBuilder sb;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st=new StringTokenizer(br.readLine());
        V=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        order=new int[V+1];
        isCutVertex=new boolean[V+1];
        Map=new ArrayList[V+1];
        for(int i=0;i<V+1;i++){
            Map[i]=new ArrayList<>();
        }
        int u;
        int v;
        for(int i=0;i<E;i++){//간선 모두 입력해줌
            st=new StringTokenizer(br.readLine());
            u=Integer.parseInt(st.nextToken());
            v=Integer.parseInt(st.nextToken());
            Map[u].add(v);
            Map[v].add(u);
        }
        for(int i=1;i<V+1;i++){
            if(order[i]==0){//그래프여러개면 여러개 모두 단절점구하기위해
            dfs(i,true);//i는 시작점 true는 루트노드확인
            }
        }

        sb=new StringBuilder();

        for(int i=1;i<V+1;i++){
            if(isCutVertex[i]==true){
                vertexnum++;
                sb.append(i+ " ");
            }
        }
        bw.write(vertexnum+"\n");
        if(vertexnum>0){
            bw.write(sb+"\n");
        }
        bw.flush();
        bw.close();

        ////dfs로 구현, 연결그래프가 아닐 수도 있다.
        //단절절점의 조건 1 시작점일때 연결된 child가 2개 이상이면
        /////         2. 시작점아닐땐 해당노드의 순서뒤에 한번이라도 더 낮은 순서에 접근하려고 한다면(이미 갔던곳 확인할때!)
        ///  구현법 DFS를 이용하여 정점들의 방문 순서 기록하면서 해당 정점의 low 값을 찾을건데
        ///  low값에 아직 순서가 정해지지않은값-> 정점보다 같거나 아래 순환 없기 때문에 단절점 아님
        /// low<=order[now] 이면 단절점이다.

    }
    static int dfs(int now,boolean isRoot){
        ordernum++;//방문순서 dfs들어갈때마다 올려줌
        order[now]=ordernum;
        int low;
        int result=ordernum;

       int child=0;

            for(int next: Map[now]){
                if(order[next]==0){//아직방문하지 않은 곳
                    child++;
                    if(isRoot){
                        System.out.println("childnum"+next);
                    }
                    low=dfs(next,false);

                    if(isRoot==false&&low>=order[now]){//단절점조건
                        isCutVertex[now]=true;
                    }
                    result=Math.min(result,low);

                }else{//이미 방문한노드는 dfs실행하지않고 방문한노드 순서 값만 가져온다.
                    result=Math.min(result,order[next]);
                }
            }
        if(isRoot==true&&child>=2){
            System.out.println(child);
            System.out.println(now);
            isCutVertex[now]=true;
        }

        return result;
    }
}
