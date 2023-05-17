import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) + 1;
        int M = Integer.parseInt(st.nextToken()) + 1;
        HashMap<String, ArrayList<int[]>> map = new HashMap<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int ax = Integer.parseInt(st.nextToken()) + 1;
            int ay = Integer.parseInt(st.nextToken()) + 1;
            int bx = Integer.parseInt(st.nextToken()) + 1;
            int by = Integer.parseInt(st.nextToken()) + 1;
            String key = ax + ay > bx + by ? "a" : "b";
            if (key.equals("a")) {
                if(!map.containsKey(ax+" "+ay))
                    map.put(ax + " " + ay,new ArrayList<int[]>());
                map.get(ax+" "+ay).add(new int[]{bx, by});

            } else {
                if(!map.containsKey(bx+" "+by))
                    map.put(bx + " " + by,new ArrayList<int[]>());
                map.get(bx + " " + by).add( new int[]{ax, ay});
            }
        }
        long[][] dp = new long[N + 1][M + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if(i==1&&j==1)continue;
                if (!map.containsKey(i + " " + j)) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    ArrayList<int[]> noloadarr = map.get(i + " " + j);

                    boolean flag1=false;
                    boolean flag2=false;

                    for(int[] noload:noloadarr) {
                        if (noload[0] == i - 1 && noload[1] == j) {
                            flag1=true;
                        }
                        if (noload[0] == i && noload[1] == j - 1) {
                            flag2=true;
                        }
                    }

                    if(!flag1){
                        dp[i][j]+=dp[i-1][j];

                    }
                    if(!flag2){
                        dp[i][j]+=dp[i][j-1];
                    }
                }
            }

        }
        System.out.println(dp[N][M]);
    }
}

