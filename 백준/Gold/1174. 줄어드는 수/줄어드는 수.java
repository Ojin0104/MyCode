import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static ArrayList<Long> arr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr.add(0L);
        for(long i=1;i<=9;i++){
            dfs(i);
            arr.add(i);
        }

        Collections.sort(arr);
       
        if(arr.size()<N){
            System.out.println(-1);
        }else{
            System.out.println(arr.get(N-1));
        }
    }
    static void dfs(long num){


        for(long i=0; i<num%10;i++){
            arr.add(num*10+i);
            dfs(num*10+i);
        }
    }
}
