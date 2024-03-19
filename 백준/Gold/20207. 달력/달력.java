import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =  new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int[] sum = new int[367];
        int[] num = new int[366];
        for(int i = 0;i<N;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            sum[Integer.parseInt(stringTokenizer.nextToken())]++;
            sum[Integer.parseInt(stringTokenizer.nextToken())+1]--;
             }
        for(int i = 1;i<366;i++){
            num[i] =sum[i]+num[i-1];

        }
        int answer = 0;
        int count = 0 ;
        int max= 0;
        for(int i=1;i<=365;i++){
            if(num[i]==0){
                //정산
                answer+= count*max;
                max =0;
                count=0;
            }else{
                max = Math.max(max,num[i]);
                count++;
            }
        }
        answer+=count*max;
        System.out.println(answer);

    }
}