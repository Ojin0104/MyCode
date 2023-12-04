import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken())-1;
        int W = Integer.parseInt(st.nextToken());

        int[][] dp =new int[R+W+1][R+W+2];
        dp[1][0]=1;
        for(int row=2;row<dp.length;row++){
            for(int col=0;col<row;col++){
                if(col==0){
                    dp[row][col] = 1;
                }else {
                    dp[row][col] = dp[row - 1][col - 1] + dp[row - 1][col];
                }
               

            }
        }

        long answer = 0;

        for(int row= R;row<R+W;row++){
            for(int col=C;col<=C+Math.abs(R-row);col++){
                
                answer+=dp[row][col];
            }
        }

        System.out.println(answer);

    }
}
