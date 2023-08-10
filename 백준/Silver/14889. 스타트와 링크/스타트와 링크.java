import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] point;
    static int min=Integer.MAX_VALUE;
    static boolean[] visit;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        point=new int[N+1][N+1];
        StringTokenizer st;
        visit=new boolean[N+1];
        for(int i=1;i<N+1;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<N+1;j++){

                point[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);
        System.out.println(min);
    }
    static void dfs(int order,int n){
        if(n==N/2){
            min=Math.min(sums(),min);
        }
        if(order>=N)return;
        order++;
        n++;
        visit[order]=true;
        dfs(order,n);
        n--;
        visit[order]=false;
        dfs(order,n);
    }
    static int sums(){
//        for(int i=1;i<visit.length;i++){
//            System.out.print(visit[i]);
//        }
//        System.out.println();
        int start=0;
        int link=0;
        for(int i=1;i<N+1;i++){
            for(int j=i+1;j<N+1;j++){
                if(visit[i]&&visit[j]){
                    start+=point[i][j]+point[j][i];
                }else if(!visit[i]&&!visit[j]){
                    link+=point[i][j]+point[j][i];
                }
            }
        }
       // System.out.println(start+" "+link);

        return Math.abs(start-link);
    }
}
