import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 비트로 양을셌는지 확인한다.
 */
public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int correct = (1<<10)-1;
        //correct와 센숫자가 and 했을떄도 correct면 정답

        for(int test_case =1 ; test_case<=T; test_case++){
            int now=0;
            int startNum=Integer.parseInt(br.readLine());
            int nowNum=startNum;
            while((correct&now)!=correct){
                int num= nowNum;
                while(num>0){
                    now=now|(1<<(num%10));
                    num/=10;
                }
                nowNum+=startNum;
            }
            nowNum-=startNum;//더해지고 while문빠져나오므로 한번빼줌

            sb.append("#"+test_case+" "+nowNum+"\n");
        }

        System.out.println(sb);


    }
}
