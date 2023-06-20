import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());
        int[] num=new int[45];
        for(int i = 1; i < 45; i++) {
            num[i]=i*(i+1)/2;
        }
        
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int answer = eureka(n, num);
            System.out.println(answer);
        }
        
    }

    public static int eureka(int N, int[] num) {
        
        for(int i=1;i<45;i++) {
            for (int j=1;j<45;j++) {
                for (int k=1; k<45;k++) {
                    int sum=num[i]+num[j]+num[k];
                    if (sum==N) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
