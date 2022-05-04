import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1747소수펠린드롬 {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        for(int i=N;i<=Integer.MAX_VALUE;i++){
            if(isPrime(i)){

                if(isPelindrom(i)){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
    static boolean isPrime(int n){

        for(int i=2;i*i<=n;i++){
            if(n%i==0)return false;
        }
        if(n==1)return false;
        return true;
    }

    static boolean isPelindrom(int n){
        char[] a=String.valueOf(n).toCharArray();

        for(int i=0;i<=(a.length)/2;i++){
            if(a[i]!=a[a.length-1-i]){
                return false;
            }
        }
        return true;
    }
}
