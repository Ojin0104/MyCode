import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1522문자열교환 {
    //결국 총a의갯수 범위 안에 있는 b를 밖으로 옮겨야하므로 a갯수범위안에있는 b의 갯수가 최소가 되는 값이 정답이다.
    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str=bufferedReader.readLine();
        char[] strArr=str.toCharArray();
        int acount=0;
        for(int i=0;i<strArr.length;i++){
            if(strArr[i]=='a')
                acount++;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<strArr.length;i++){
            int bcount=0;
            for(int j=i;j<i+acount;j++){
                int k=j%strArr.length;
                if(strArr[k]=='b')
                    bcount++;
            }
            min=Math.min(min,bcount);
        }
        System.out.println(min);
        }
}
