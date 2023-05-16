import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int count=0;
    static boolean[] isNotPrime;
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long A=Long.parseLong(st.nextToken());
        long B=Long.parseLong(st.nextToken());
        int n=2;
        isNotPrime=new boolean[(int)Math.sqrt(B)+1];
        while((long)Math.pow(n,2)<=B){

            if(!isNotPrime[n]){

                int i=2;

                while(Math.pow(n,i)<=B){
                    if(Math.pow(n,i)>=A){
                        count++;
                    }
                    i++;
                }
            }
            isPnum(n);
            n++;
        }
        System.out.println(count);
    }
    static void isPnum(int a){
        if(isNotPrime[a])return;
        for(int i=2;i*a< isNotPrime.length;i++){
            isNotPrime[i*a]=true;
        }

    }
}
