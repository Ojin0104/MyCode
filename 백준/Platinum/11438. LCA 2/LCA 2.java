import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int k;
    static int[] depth;
    static boolean[] check;
    static int[][] parent;
    static ArrayList<Integer>[] tree;

    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree=new ArrayList[N+1];


        k = 0;
        for (int i = 1; i < N; i *= 2) {
            k++;
        }
       // System.out.println(k);
        parent=new int[k+1][N+1];
        check=new boolean[N+1];
        depth=new int[N+1];
        for(int i=0;i<N+1;i++){
            tree[i]=new ArrayList<>();
        }
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }
        //행렬만들어주기 k,N
        dfs(1);
          for(int i=1;i<=k;i++){//k는 2^n depth위의 부모 부모의 부모의 부모 로 적용한다생각
              for(int j=1;j<N+1;j++){
                  parent[i][j]=parent[i-1][parent[i-1][j]];

              }
          }


        M=Integer.parseInt(br.readLine());
        //System.out.println("m" +M);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){

            st=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            sb.append(LCA(a,b)+"\n");


        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int a){

        check[a]=true;
        for(int i=0;i<tree[a].size();i++){
            if(!check[tree[a].get(i)]) {

                depth[tree[a].get(i)]=depth[a]+1;
                parent[0][tree[a].get(i)]=a;

                dfs(tree[a].get(i));



            }
        }
    }
    static int LCA(int a,int b){

        if((depth[a]<depth[b])){
            return LCA(b,a);
        }
        //높이맞춰주기

        for(int i=0;i<=k;i++) {
            if (((depth[a] - depth[b]) & (1 << i)) >= 1) {

                a = parent[i][a];// 1,3

            }
        }

        //높이맞는데 그 부모가 같으면 바로 return
        if(a==b)return b;

        //
        for(int i=k;i>=0;i--){
            if(parent[i][a]!=parent[i][b]){
                a=parent[i][a];
                b=parent[i][b];
            }
        }
      // System.out.println(parent[0][a]);
return parent[0][a];
    }
}
