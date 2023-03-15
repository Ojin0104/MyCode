import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class ehlfk {
    static char[][] map;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int size=Integer.parseInt(st.nextToken());
        int jump=Integer.parseInt(st.nextToken());
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] dp=new int[size];
        for(int i=0;i<jump;i++){
            st=new StringTokenizer(br.readLine());
            int first=Integer.parseInt(st.nextToken());
            int second=Integer.parseInt(st.nextToken());
            map.put(second,first);
        }

        for(int i=0;i<6;i++){
            dp[i]=1;
            if(map.containsKey(0)){//0에서점프판있으면
                if(map.get(0)==i)
                    dp[i]=0;
            }
        }
        for(int i=6;i<size;i++){
            dp[i]=Integer.MAX_VALUE/4;
            if(map.containsKey(i)){
                if(map.get(i)>i)
                    continue;
                dp[i]=dp[map.get(i)];
            }
            for(int j=1;j<=6;j++){
                dp[i]=Math.min(dp[i-j]+1,dp[i]);
            }
        }

    }
}
