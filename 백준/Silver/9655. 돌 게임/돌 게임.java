import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        boolean[] dp=new boolean[N+1];

        //상근이 이기면 1
        dp[1]=true;

        for(int i=2;i<N+1;i++){
            if(!dp[i-1]){
                dp[i]=true;
            }else if(i>3&&!dp[i-3]){
                dp[i]=true;
            }
        }
        if(dp[N]){
            System.out.println("SK");
        }else{
            System.out.println("CY");
        }
    }
}
