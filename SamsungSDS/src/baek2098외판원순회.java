import java.io.*;
import java.util.StringTokenizer;

public class baek2098외판원순회{
    static int[][] W;
    static int N;
    static int visitall;
    static int min=Integer.MAX_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(br.readLine());
        W=new int[N+1][N+1];
        visitall=(1<<N)-1;
        StringTokenizer st;
        int child;
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                child=Integer.parseInt(st.nextToken());

                W[i][j]=child;

            }

        }

        min=dfs(1,1);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();

    }

    static int dfs(int n,int visited){//n은 현재 정점 num은 거쳐간 정점의수



        if(visited==visitall){
            if(W[n][1]!=0){
               return W[n][1];}
            else return Integer.MAX_VALUE;
        }

        int ret=Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            if(W[n][i]!=0) {

                int nex = (1 << (i - 1));
                int nextvisited = nex | visited;
                if (nextvisited != visited) {

                   ret=Math.min(ret, W[n][i]+dfs(i, nextvisited));
                }

            }
        }

        return ret;
    }

}
