import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int[] answer=new int[10];
        int[] myanswer=new int[10];
        for(int i=0;i<10;i++){
            answer[i]=Integer.parseInt(stringTokenizer.nextToken());
        }

        dfs(answer,myanswer,0);
        System.out.println(count);
    }

    static void dfs(int[] answer,int[] myanswer, int now){
        if(now==10){
            int score=0;
            for(int i=0;i<10;i++){
                if(answer[i]==myanswer[i]){
                    score++;
                }

            }
            if(score>=5){
                count++;
            }
            return;
        }
        for(int i=1;i<6;i++){
            if(now>=2&&myanswer[now-1]==i&&myanswer[now-2]==i){
                continue;
            }
            myanswer[now]=i;
            dfs(answer,myanswer,now+1);
        }
    }
}
