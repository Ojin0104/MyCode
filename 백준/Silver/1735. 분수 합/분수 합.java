import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A;
    static int B;
    static int X;
    static int Y;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A=Integer.parseInt(st.nextToken());
        B=Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        X=Integer.parseInt(st.nextToken());
        Y=Integer.parseInt(st.nextToken());
        int mom;
        int son;
        if(B%Y==0){//큰수가 최소공배수
            mom=Math.max(B,Y);
            if(mom==B)son=B/Y*X+A;
            else
            son=Y/B*A+X;
        }else{
            mom=B*Y;
            son=A*Y+B*X;

        }
        //gcd구해서 나눠줌
        int div=gcd(son,mom);
        System.out.println(son/div+" "+mom/div);
    }
    static int gcd(int a,int b){
if(a==0)return b;

return gcd(b%a,a);
    }
}
