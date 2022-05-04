import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1065_한수 {
    public static void main(String args[]) throws IOException {
        int N;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        int count=0;
        if(N<100){
            System.out.println(N);
        }else if(N<=1000){
            if(N==1000)N-=1;
            count=99;
            int a;
            int b;
            int c;
            for( int i=100;i<=N;i++){
                a=i/100;
                b=(i-100*a)/10;
                c=i%10;
               // System.out.println(a+" "+b+" "+c);
                if(a==b&&b==c){
                    count++;}
                        else if(a-b==b-c){

                            count++;
                        }
                    }
            System.out.println(count);
                }
        br.close();
            }
        }


