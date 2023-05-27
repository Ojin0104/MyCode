import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> answer=new ArrayList<>();
    static boolean[] check;
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        ArrayList<int[]>[] graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            graph[i]=new ArrayList<int[]>();
        }

        check=new boolean[graph.length+1];

        for(int i=0;i<n-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b,v});
            graph[b].add(new int[]{a,v});
        }

        check[1]=true;


        dfs(1,graph);
        System.out.println(max);



    }
    static int dfs(int now,ArrayList<int[]>[] graph){


        if(graph[now].size()==1&&now!=1){
            return 0;
        }

        int[] child=new int[graph[now].size()];
        int index=-1;
        for(int[] next:graph[now]){
            if(check[next[0]])continue;
            index++;
            check[next[0]]=true;
            int nextsize=dfs(next[0],graph)+next[1];
            child[index]=nextsize;

        }

       Arrays.sort(child);
        if(child.length>=2) {
            int sum = child[child.length - 1] + child[child.length - 2];
            max = Math.max(sum, max);

        }
       

        if(now==1){

            max=Math.max(child[child.length-1],max);
        }


        return child[child.length-1];

    }
}
