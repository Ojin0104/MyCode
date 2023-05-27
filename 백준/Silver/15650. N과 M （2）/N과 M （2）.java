import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static int M;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

       N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());


        dfs(1,0,"");
        System.out.println(sb);
    }
    static void dfs(int now,int num,String sbb){
        
        if(num==M){
            sb.append(sbb+"\n");
            return;
        }
        if(now==N+1)return;
        
        dfs(now+1,num+1,sbb+now+" ");
        dfs(now+1,num,sbb);
    }
}
