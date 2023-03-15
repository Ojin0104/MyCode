import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek1436영화감독숌 {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n=Integer.parseInt(stringTokenizer.nextToken());
        int count=0;
        int i=0;
        while(count<n){
            i++;
            String check=Integer.toString(i);

            if(check.contains("666"))
                count++;

        }
        System.out.println(i);
    }
}
