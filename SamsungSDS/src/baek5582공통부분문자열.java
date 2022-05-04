import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek5582공통부분문자열 {
    static char[] A;
    static char[] B;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        A=(br.readLine()).toCharArray();
        B=(br.readLine()).toCharArray();
        System.out.println(A.length);

    }

}
