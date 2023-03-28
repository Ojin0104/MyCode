import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek74900만들기 {
    static StringBuilder stringBuilder = new StringBuilder();
    public static void main(String arge[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int T= Integer.parseInt(bufferedReader.readLine());

        for(int i=0;i<T;i++){
            int N=Integer.parseInt(bufferedReader.readLine());

            dfs(N,1,"1");
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder.toString());

    }
    static void dfs(int N,int now,String str){
        if(now==N){
            if(calcStr(str)==0)
                stringBuilder.append(str+"\n");
            return;
        }

        now=now+1;

        dfs(N,now,str+" "+now);

        dfs(N,now,str+"+"+now);

        dfs(N,now,str+"-"+now);

    }

    static int calcStr(String str){
        char[] cal=str.toCharArray();

        int i=0;
        int num1=0;
        int num2=0;
        char operator='n';
        while(i<cal.length){
            if(cal[i]==' '){
                i++;
                continue;
            }
            if(cal[i]=='+'||cal[i]=='-'){
                if(operator!='n'){//연산
                    if(operator=='+'){
                        num1+=num2;
                    }else{
                        num1-=num2;
                    }
                    num2=0;
                    operator=cal[i];

                }else{

                operator=cal[i];}
            }else{
                if(operator=='n') {
                    num1 = num1 * 10 + (int) (cal[i]-'0');

                    }
                else{
                    num2=num2*10+(int)(cal[i]-'0');
                }

            }
            i++;
        }

        if(operator=='+'){
            num1+=num2;
        }else{
            num1-=num2;
        }
        return num1;

    }
}
