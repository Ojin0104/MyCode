import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class baek1759 {
    static char[] data;
    static int L;
    static int C;
    static List<String> result=new LinkedList<>();
    public static void main(String[] args) throws Exception{
        Scanner scanner= new Scanner(System.in);
        int L= scanner.nextInt();
        int C= scanner.nextInt();
        data=new char[C];

for(int i=0;i<C;i++){
    data[i]=scanner.next().charAt(0);

}
Arrays.sort(data);
System.out.println(Arrays.toString(data));

    }
    static void dfs(int length,int ja, int mo ,int current, String pwd){
        if(length==L) {
            if (ja >= 2 && mo >= 1) {
                result.add(pwd);
            }
        }else{
            for (int nextIndex = current+1; nextIndex < data.length; nextIndex++) {

                char next = data[nextIndex];

                if(next=='a'||next=='e'||next=='i'||next=='o'||next=='u'){
                    dfs(length+1,ja,mo+1,nextIndex,pwd+next);

                }else{
                    dfs(length+1,ja+1,mo,nextIndex,pwd+next);
                }

            }
        }
    }

}
