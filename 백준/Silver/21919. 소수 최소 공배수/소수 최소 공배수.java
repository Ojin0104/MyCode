import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        long answer = 1;
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(isSosu(num)){
                if(answer%num!=0) {
                    answer *= num;
                }
            }

        }
        if(answer==1){
            answer=-1;
        }
        System.out.println(answer);
    }

    static boolean isSosu(int num){
        for(int i=2;i<=Math.sqrt(num);i++ ){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}
