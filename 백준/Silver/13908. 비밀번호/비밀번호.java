import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer = 0;
    static int N;
    static int[] check = new int[10];
    static int[] checkNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        checkNum = new int[M];
        int[] key = new int[N];


        if(M!=0)
            st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            checkNum[i] = Integer.parseInt(st.nextToken());
        }
        if(M==0){
            answer=(int)Math.pow(10,N);
        }else {
            dfs(0, key);
        }
        System.out.println(answer);
    }

    static void dfs(int now, int[] key) {
        if (now == N) {



            if (haveNum(key)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            key[now] = i;
            check[i]++;
            dfs(now + 1, key);
            check[i]--;
        }
    }

    static boolean haveNum(int[] key) {


        for (Integer num : checkNum) {
            if (check[num]<=0)
                return false;
        }
        return true;
    }
}
