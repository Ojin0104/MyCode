import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek1446지름길 {
    static int N;
    static int D;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        D=Integer.parseInt(st.nextToken());

         Road[] roads=new Road[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            roads[i]=new Road(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        }
        int[] dp=new int[D+1];
        Arrays.sort(roads);
        int now=1;
        Arrays.fill(dp,10001);
        dp[0]=0;
        int i=0;
        int fastroad=roads[i].end;
        while(now<=D){


            if(now<fastroad){
                dp[now]=dp[now-1]+1;
                now++;
                continue;
            }
            while(now==fastroad) {
                dp[now] = Math.min(dp[now],Math.min(dp[now - 1] + 1, dp[roads[i].start] + roads[i].len));
                i++;

                if (i >= N)
                    fastroad = D + 1;
                else
                    fastroad = roads[i].end;
            }
            now++;

        }




        System.out.println(dp[D]);
    }


}
class Road implements Comparable<Road>{
    int start;
    int end;
    int len;

    public Road(int start,int end,int len){
        this.start=start;
        this.end=end;
        this.len=len;
    }

    @Override
    public int compareTo(Road o) {
        return this.end-o.end;
    }
}
