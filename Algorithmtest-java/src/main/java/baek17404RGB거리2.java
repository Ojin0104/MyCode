import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek17404RGB거리2 {
    static int N;
    static int[][] cost;

    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());

        cost=new int[N][3];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            cost[i][0]=Integer.parseInt(st.nextToken());
            cost[i][1]=Integer.parseInt(st.nextToken());
            cost[i][2]=Integer.parseInt(st.nextToken());
        }
        int[][] dp=new int[N][3];
        int min=Integer.MAX_VALUE;
        //dp[i][j] : i번집에 j색깔을 칠한 최소값

        for(int c=0;c<3;c++){//처음 고정한 집색깔
            dp[0][c]=cost[0][c];
            dp[0][(c+1)%3]=Integer.MAX_VALUE-100000;
            dp[0][(c+2)%3]=Integer.MAX_VALUE-100000;
            for(int i=1;i<N;i++){
                for(int j=0;j<3;j++){
                    dp[i][j]=Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3])+cost[i][j];
                }
            }
            min=Math.min(min,dp[N-1][(c+2)%3]);
            min=Math.min(min,dp[N-1][(c+1)%3]);
        }

        System.out.println(min);

    }
}
