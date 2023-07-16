import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {//숫자를 앞뒤로배열해서 30의 배수로 만들기  n%30=0이면 됨 배열 일일이 다하면 5x4x3x2x1 120
        //3의배수조건 모든 열 합 3의배수 10의 배수조건 0이포함
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        char[] N=st.nextToken().toCharArray();
        int sum=0;
        int ten=0;
        //System.out.println("1");
        for(int i=0;i<N.length;i++){
            //System.out.println("1");
            sum+=Integer.parseInt(String.valueOf(N[i]));
            if(N[i]=='0')ten=i;
        }

        if(ten>0&&sum%3==0){//0을젤밑에두고 큰수부터 위로
//            for(int i=1;i<N.length;i++){
//                for(int j=0;j<N.length-1;j++){
//                    if(N[j]<N[j+1]){
//                    char temp=N[j];
//                    N[j]=N[j+1];
//                    N[j+1]=temp;
//                    }
//                }
//            }
            Arrays.sort(N);
            char[] n=new char[N.length];
            for(int i=0;i<N.length;i++){
                n[i]=N[N.length-1-i];
            }
            System.out.println(n);
        }else{
            System.out.println(-1);
        }

    }
}
