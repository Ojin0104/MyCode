import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek2668숫자고르기 {
    static boolean [] answer;
    static int[] num;

    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        num=new int[N+1];
        answer=new boolean[N+1];

        for(int i=1;i<N+1;i++){
            num[i]=Integer.parseInt(br.readLine());
        }
        //순환되는 것 찾기
        for(int i=1;i<N+1;i++){
            boolean[] check=new boolean[N+1];
            dfs(check,i,i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count=0;
        for(int i=1;i<N+1;i++) {
            if(answer[i]==true) {
                count++;
                stringBuilder.append(i+"\n");
            }

        }
        System.out.println(count);
        System.out.println(stringBuilder.toString());
    }
    static void dfs(boolean[] check, int target, int now){
        if(answer[now])return;
        if(check[now]) {
            if (now == target) {
                for (int i = 0; i < check.length; i++) {
                    if (check[i])
                        answer[i] = true;
                }

            }
            return;
        }



        check[now]=true;

        dfs(check,target,num[now]);
    }
}
