import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb=new StringBuilder();
    static int M;
    static int N;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

       N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[N];
        check=new boolean[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        dfs(0,0,"");
        System.out.println(sb);
    }
    static void dfs(int now,int num,String sbb){

        if(num==M){
            sb.append(sbb+"\n");
            return;
        }
       // if(N-now+num<M)return;
        if(now==N)return;
        for(int i=0;i<arr.length;i++) {

            if(check[i])continue;

            check[i]=true;
            dfs(i, num + 1, sbb + arr[i] + " ");
            check[i]=false;

        }
    }
}
