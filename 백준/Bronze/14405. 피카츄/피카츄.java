import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String str=br.readLine();
        int index=0;
        while(index<str.length()){
            int size=checkWord(str,index);
            if(size==0){
                System.out.println("NO");
                return;
            }
            index+=size;
        }
        System.out.println("YES");


    }
    static int checkWord(String str,int index){
        String[] strs={"pi","ka","chu"};
        for(int i=0;i<strs.length;i++){
            boolean flag=true;
            for(int j=0;j<strs[i].length();j++){
                if(index+j>=str.length()) {
                    flag=false;
                    break;
                };
                if(str.charAt(index+j)!=strs[i].charAt(j)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return strs[i].length();
            }
        }
        return 0;
    }
}
