import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek3830교수님은기다리지않는다dfs {

    static ArrayList<node>[] graph;
    static int N=1;
    static int M=1;

    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();
        while(N!=0||M!=0){
                st=new StringTokenizer(br.readLine());
               N=Integer.parseInt(st.nextToken());
               M=Integer.parseInt(st.nextToken());




            graph=new ArrayList[N+1];
            for(int i=0;i<N+1;i++){
                graph[i]=new ArrayList<>();
            }
            int s;
            int v;
            int w;
            int result;
            for(int i=0;i<M;i++){
                st=new StringTokenizer(br.readLine());

                if(st.nextToken().equals("!")){
                      s=Integer.parseInt(st.nextToken());
                      v=Integer.parseInt(st.nextToken());
                      w=Integer.parseInt(st.nextToken());
                    graph[s].add(new node(v,w));
                    graph[v].add(new node(s,-w));
                }else{
                    s=Integer.parseInt(st.nextToken());
                    v=Integer.parseInt(st.nextToken());
                    result=finddfs(s,v);
                    if(result==0){
                        sb.append("UNKNOWN\n");
                    }else{
                        sb.append(result+"\n");
                    }
                }
            }



        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
    static class node{
        int s;
        int w;

        node(int s, int w){
            this.s=s;
            this.w=w;
        }
    }
    static int finddfs(int a,int b){
//        boolean[] check=new boolean[N+1];
//        check[a]=true;
        int[] weight=new int[N+1];
        Stack<Integer> stack = new Stack<>();
        stack.push(a);
        //찾으면 sum리턴 없으면 0리턴
        while(!stack.isEmpty()){
            int nodeindex=stack.pop();

        for(node next:graph[nodeindex]){
            if(weight[next.s]==0&&next.s!=a){
                stack.push(next.s);
                weight[next.s]=weight[nodeindex]+next.w;
                if(next.s==b){
                    return weight[next.s];
                }


            }
        }}
        return 0;
    }
}
