import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String s=br.readLine();
        StringBuilder sb=new StringBuilder(s);
        int zero=0;
        int one=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='0')zero++;
            else one++;
        }
        zero/=2;
        one/=2;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='1') {
                sb.setCharAt(i, '2');
                one--;
            }
            if(one==0)break;
        }

        for(int i=sb.length()-1;i>=0;i--){
            if(sb.charAt(i)=='0'){
                sb.setCharAt(i,'2');
                zero--;
            }
            if(zero==0)break;
        }
        StringBuilder sbb=new StringBuilder();
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)!='2')sbb.append(sb.charAt(i));
        }

        System.out.println(sbb);
            }
}
