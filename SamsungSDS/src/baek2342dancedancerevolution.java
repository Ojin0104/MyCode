import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2342dancedancerevolution {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[][][] dp=new int[100001][5][5];
        int num;

        int c=0;

        int n=-1;
        num=1;
        while(true){//0에서바뀌면 2점
            num=Integer.parseInt(st.nextToken());

            if (num == 0) break;
            n++;


            if(n==0) {//처음에는
                dp[n][num][0]=2;
                continue;
            }
            for(int i=1;i<5;i++){
                for(int j=0;j<5;j++){
                   if(i==j)continue;
                    if(dp[n-1][i][j]!=0) {//전에값이있는거만 실행


                        if (i == num||j==num) {//발같은곳 그대로
                            dp[n][i][j]=dp[n-1][i][j]+1;

                        }
                        for (int k = 0; k < 2; k++) {
                            if(k==0)c=i;
                            else c=j;


                             if(j==0&&k==1) {//처음에 뒤에0일때
                                 if(dp[n][i][num]!=0)dp[n][i][num]=Math.min(dp[n][i][num],dp[n-1][i][j]+4);
                                 else
                                 dp[n][i][num]=dp[n-1][i][j]+2;

                            }else if (Math.abs(c - num) == 2) {//한칸이동

                                 if(k==0){
                                     if(dp[n][num][j]!=0)dp[n][num][j]=Math.min(dp[n][num][j],dp[n-1][i][j]+4);
                                     else dp[n][num][j]=dp[n-1][i][j]+4;
                                 }
                                 else {
                                     if(dp[n][i][num]!=0)dp[n][i][num]=Math.min(dp[n][i][num],dp[n-1][i][j]+4);
                                     else
                                         dp[n][i][num]=dp[n-1][i][j]+4;
                                 }


                            }else if(Math.abs(c-num)==0) {
                                 continue;
                             }
                             else{


                                 if(k==0){
                                     if(dp[n][num][j]!=0)dp[n][num][j]=Math.min(dp[n][num][j],dp[n-1][i][j]+3);
                                     else dp[n][num][j]=dp[n-1][i][j]+3;
                                 }
                                 else {
                                     if(dp[n][i][num]!=0)dp[n][i][num]=Math.min(dp[n][i][num],dp[n-1][i][j]+3);
                                     else
                                         dp[n][i][num]=dp[n-1][i][j]+3;
                                 }
                             }

                        }
                    }
                }
            }

        }
        int min=Integer.MAX_VALUE;
if(n==-1)System.out.println(0);
else{
        for(int i=1;i<5;i++){
            for(int j=0;j<5;j++){
                //System.out.println(i+" "+j+"  "+ dp[s][i][j]);
                if(dp[n][i][j]!=0) {

                    min = Math.min(min, dp[n][i][j]);
                }
            }
        }
        System.out.println(min);
    }}
}
