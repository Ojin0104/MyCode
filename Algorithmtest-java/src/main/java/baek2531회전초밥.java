import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek2531회전초밥 {

    public static void main(String args[]) throws IOException {

        int N,d,k,c;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        c=Integer.parseInt(st.nextToken());

        int[] belt=new int[N];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            belt[i]=Integer.parseInt(st.nextToken());
        }
        int[] eat=new int[d];
        int eatnum=0;
        int maxnum=0;
        //처음 k개
        for(int i=0;i<k;i++){
            if(eat[belt[i]-1]==0)
                eatnum++;
            eat[belt[i]-1]++;
        }
        maxnum=eatnum;
        if(eat[c-1]==0)
            maxnum++;

        for(int i=1;i<N;i++){
            eat[belt[i-1]-1]--;
            if(eat[belt[i-1]-1]==0)
                eatnum--;
            if(eat[belt[(i+k-1)%N]-1]==0)
                eatnum++;
            eat[belt[(i+k-1)%N]-1]++;
            if(eat[c-1]==0)
                maxnum=Math.max(maxnum,eatnum+1);
            else
                maxnum=Math.max(maxnum,eatnum);
        }

        System.out.println(maxnum);
    }
}
