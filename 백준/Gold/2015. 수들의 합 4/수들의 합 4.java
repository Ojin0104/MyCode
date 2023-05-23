import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());


        int[]sum=new int[N+1];
        HashMap<Integer,Integer> map=new HashMap<>();
        st=new StringTokenizer(br.readLine());
        long count=0;

        for(int i=1;i<=N;i++){
            sum[i]=Integer.parseInt(st.nextToken())+sum[i-1];
            if(sum[i]==K){
                count++;
            }
            count+=map.getOrDefault(sum[i]-K,0);
            map.put(sum[i],map.getOrDefault(sum[i],0)+1);
        }

       System.out.println(count);

    }

}
