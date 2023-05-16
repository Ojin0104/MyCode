import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringBuilder answer=findComb(N);
        if(answer.length()==0){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }
    }

    static StringBuilder findComb(int N){
        StringBuilder sb=new StringBuilder();

        for(int i=(int)Math.sqrt(N);i>=1;i--){
            if(N%i==0&&(i+N/i)%2==0){
                    if(i==N/i)continue;
                    sb.append((N/i+i)/2+"\n");

            }
        }
        return sb;
    }
}