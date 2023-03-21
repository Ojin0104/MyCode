import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek12919A와B2 {
    static int answer=0;
    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String A=bufferedReader.readLine();
        String B=bufferedReader.readLine();

        check(A,B);

        System.out.println(answer);

    }

    public static int bCount(String a){//B의 갯수
        int bcount=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)=='B')
                bcount++;
        }
        return bcount;
    }

    public static void check(String A,String B){
        if(A.length()==B.length()){
        if(A.equals(B)) {
            answer = 1;
        }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder(B);
        char first=B.charAt(0);
        char end=B.charAt(B.length()-1);
        if(first=='B'&&end=='B'){
            check(A,stringBuilder.reverse().deleteCharAt(stringBuilder.length()-1).toString());
        }else if(first=='A'&&end=='A'){
            check(A,stringBuilder.deleteCharAt(B.length()-1).toString());
        }else if(first=='B'&&end=='A'){
            check(A,stringBuilder.deleteCharAt(B.length()-1).toString());
            stringBuilder.append('A');
            check(A,stringBuilder.reverse().deleteCharAt(stringBuilder.length()-1).toString());
        }




    }
}
