import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[] map=new int[N+1];
        int[] dp=new int[N+1];
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=1;i<N+1;i++){
            map[i]=Integer.parseInt(st.nextToken());
        }
        int max=0;
        for(int i=1;i<N+1;i++){
            for(int j=0;j<i;j++){
                if(map[i]>map[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            max=Math.max(dp[i],max);
        }
        System.out.println(max);
    }
}