import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int num=0;
            int index=0;
        for(int i=0;i<9;i++){
            int n=Integer.parseInt(br.readLine());
            if(n>num){
                num=n;
                index=i+1;
            }
        }
        System.out.println(num);
        System.out.println(index);
    }
}
