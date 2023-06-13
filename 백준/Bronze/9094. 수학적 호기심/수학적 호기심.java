import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<T;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int n=Integer.parseInt(stringTokenizer.nextToken());
            int m=Integer.parseInt(stringTokenizer.nextToken());
            int count=0;
            for(int j=1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if((j*j+k*k+m)%(j*k)==0){
                        count++;
                    }
                }

            }
            stringBuilder.append(count+"\n");

        }
        System.out.println(stringBuilder);
    }
}
