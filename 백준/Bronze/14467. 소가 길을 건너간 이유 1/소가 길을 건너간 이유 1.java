import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[] cows=new int[11];
        boolean[] check=new boolean[11];
        int answer=0;
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int now=Integer.parseInt(st.nextToken());
            int point=Integer.parseInt(st.nextToken());

            if(!check[now]){
                cows[now]=point;
                check[now]=true;
            }else{
                if(cows[now]!=point){
                    answer++;
                    cows[now]=point;
                }
            }
        }
        System.out.println(answer);
    }
}
