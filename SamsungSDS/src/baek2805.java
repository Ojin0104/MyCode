import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2805 {
    static long M;
    static int N;
    static Long[] tree;

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new Long[N];
        st = new StringTokenizer(br.readLine());
long best=0;
        for (int i = 0; i < N; i++) {
            tree[i] = Long.parseLong(st.nextToken());
            if(tree[i]>best)best=tree[i];
        }



        long length = 0;//나무길이
        long max = 0;//절단기 높이
        long low=0;
        long high=best;
        long mid;
      //  System.out.println(tree[1]);
        while (low<=high) {
            mid=(low+high)/2;
            length=0;
            for(int i=0;i<N;i++){
                if(tree[i]-mid<=0)continue;
                length+=tree[i]-mid;

            }
            if(length==M){
                max=mid;
                break;
            }else if(length>M){
                max=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }



            }

        System.out.println(max);
        }

    }


