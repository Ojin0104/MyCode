import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());
        int[][] room=new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            room[i][0]=Integer.parseInt(st.nextToken());
            room[i][1]=Integer.parseInt(st.nextToken());

        }

        Arrays.sort(room,(r1,r2)->r1[0]==r2[0]?r1[1]-r2[1]:r1[0]-r2[0]);
        int nowend=room[0][1];
        int count=1;
        for(int i=1;i<N;i++){
            int[] now=room[i];
            if(nowend<=now[0]){
                count++;
                nowend=now[1];
                continue;
            }else if(nowend>now[1]){
                nowend=now[1];


            }
           // System.out.println(nowend);
        }
        System.out.println(count);
    }
}
