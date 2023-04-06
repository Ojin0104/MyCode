import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baek9935문자열폭발 {

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb= new StringBuilder(br.readLine());
        Stack<StringBuilder> stack=new Stack<>();

        String find=br.readLine();
        int index=0;
        index=sb.indexOf(find);
        int start=0;
        while(index>=0) {
            index+=start;
            sb = sb.delete(index, index + find.length());

            start=index-find.length()+1;

            if(start<0){
                start=0;
            }

            index=sb.substring(start,sb.length()).indexOf(find);//substring 사용시

        }
        if(sb.toString().equals("")){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }

    }
}
