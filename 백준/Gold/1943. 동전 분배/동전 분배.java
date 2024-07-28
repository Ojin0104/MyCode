import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        for(int times =0;times<3;times++){
            boolean flag = false;
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] coin = new int[N][2];
            int cost = 0;
            for(int i = 0; i<N ; i++){
                StringTokenizer stringTokenizer =new StringTokenizer( bufferedReader.readLine());

                coin[i][0] = Integer.parseInt(stringTokenizer.nextToken());
                coin[i][1] = Integer.parseInt(stringTokenizer.nextToken());

                cost += coin[i][0]*coin[i][1];
            }

            if(cost%2!=0){
                stringBuilder.append("0\n");
                continue;
            }

            Arrays.sort(coin,((o1, o2) ->o1[0]-o2[0]));
            boolean[][] dp = new boolean[N][cost/2+1];

             for(int i = 0 ;i<=coin[0][1];i++){
                 if(coin[0][0]*i>cost/2)break;
                 dp[0][coin[0][0]*i]= true;
             }
             if(dp[0][cost/2]){
                 stringBuilder.append("1\n");
                 continue;
             }
             for(int row = 0;row<dp.length-1;row++){


                 for(int money = 0; money<=cost/2;money++){
                     if(dp[row][money]){
                         for(int count = 0;count<=coin[row+1][1];count++){
                             if(money+coin[row+1][0]*count>cost/2)break;
                             dp[row+1][money+coin[row+1][0]*count]= true;
                         }

                     }
                 }

                 if(dp[row+1][cost/2]){
                     flag = true;
                     break;
                 }

             }
             if(flag){
                 stringBuilder.append("1\n");
             }else{
                 stringBuilder.append("0\n");
             }
        }

        System.out.println(stringBuilder);
    }
}
