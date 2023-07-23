import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[] check;
    static int[] answer;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int N=Integer.parseInt(br.readLine());
        check=new boolean[N+1];
        answer=new int[N+1];
        dfs(1,N);
        System.out.println(sb);
    }

    static void dfs(int now, int N){
        if(now>N){
            printStr(answer);
            return;
        }

        for(int i=1;i<=N;i++){
            if(check[i])continue;
            check[i]=true;
            answer[now]=i;
            dfs(now+1,N);
            check[i]=false;
        }


    }

    static void printStr(int[] answer){
        for(int i=1;i<answer.length;i++){
            sb.append(answer[i]+" ");
        }
        sb.append("\n");

    }
}
