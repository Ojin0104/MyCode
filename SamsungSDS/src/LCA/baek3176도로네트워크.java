package LCA;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek3176도로네트워크 {
    static int N;
    static int[][] max;
    static int[][] min;
    static int[][] parent;
    static int[] depth;
    static int logN;
    static boolean[] check;
    static ArrayList<node>[] tree;
    static int K;
    static int resultmax;
    static int resultmin;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        logN=0;
        int n=N;
        while(n>=1){
            n/=2;
            logN++;
        }

        tree=new ArrayList[N+1];
        depth=new int[N+1];
        check=new boolean[N+1];
        parent=new int[logN+1][N+1];
        max=new int[logN+1][N+1];
        min=new int[logN+1][N+1];

        for(int i=0;i<N+1;i++){
            tree[i]=new ArrayList<>();
        }
        StringTokenizer st;
        int a;
        int b;
        int c;
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            tree[a].add(new node(b,c));
            tree[b].add(new node(a,c));
        }
        dfs(1);

        for(int i=1;i<=logN;i++){

            for(int j=1;j<=N;j++){
                parent[i][j]=parent[i-1][parent[i-1][j]];
                max[i][j]=Math.max(max[i-1][j],max[i-1][parent[i-1][j]]);
                if(min[i-1][parent[i-1][j]]==0)min[i][j]=min[i-1][j];
                else{
                min[i][j]=Math.min(min[i-1][j],min[i-1][parent[i-1][j]]);}

            }

        }
        st=new StringTokenizer(br.readLine());
        K=Integer.parseInt(st.nextToken());
        int A;
        int B;
        for(int i=0;i<K;i++){
            st=new StringTokenizer(br.readLine());
            A=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            findLCA(A,B);
            bw.write(resultmin+" "+resultmax+"\n");
        }
bw.flush();
        bw.close();

    }
    static class node{
        int s;
        int w;
        node(int s,int w){
            this.s=s;
            this.w=w;
        }
    }

    static void dfs(int i){
        check[i]=true;
        for(node next:tree[i]){
            if(!check[next.s]){
                depth[next.s]=depth[i]+1;
                parent[0][next.s]=i;
                max[0][next.s]=next.w;
                min[0][next.s]=next.w;

                dfs(next.s);
            }
        }
    }
    static void findLCA(int a,int b){
        //키높이 맞춰주고 logN만큼 반복하면서 해당깊이에있는 노드 바로위가 LCA가됨
        //a에서 LCA노드까지 최대거리 값
        if(depth[a]<depth[b]) {findLCA(b,a);
            return;}
        //미리 max min 값 빼두기
        resultmax=max[0][a];
        resultmin=min[0][a];

        for(int i=0;i<logN;i++){
            if(((depth[a]-depth[b])&(1<<i))>=1){
                resultmax=Math.max(max[i][a],resultmax);
                resultmin=Math.min(min[i][a],resultmin);
                a=parent[i][a];
            }
        }
        if(a==b) {//a가 공통부모}
            //공통부모에서

                return;
        }else {


            for (int i = logN; i >= 0; i--) {
              //  System.out.println("a"+a+" b"+b);
                if (parent[i][a] != parent[i][b]) {
                    resultmax=Math.max(resultmax,max[i][a]);
                    resultmax=Math.max(resultmax,max[i][b]);
                    resultmin=Math.min(min[i][a],resultmin);
                    resultmin=Math.min(min[i][b],resultmin);
//                    System.out.println(resultmax+" "+resultmin);
//                    System.out.println(i);
//                    System.out.println(a+" "+b);
//                    System.out.println(i);
                    a = parent[i][a];
                    b = parent[i][b];
                   // System.out.println("good a"+a+" b"+b);
                }
            }
//            System.out.println("resultmin"+resultmin);
//            System.out.println(a+" "+b);
            resultmax=Math.max(resultmax,max[0][a]);
            resultmax=Math.max(resultmax,max[0][b]);
            resultmin=Math.min(min[0][a],resultmin);
            resultmin=Math.min(min[0][b],resultmin);

            //parent[0][a];
        }

    }
}
