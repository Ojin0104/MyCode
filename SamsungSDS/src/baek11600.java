import java.io.*;
import java.util.StringTokenizer;

public class baek11600 {
    static int M;

    static int N;
    static int[][] num;
    static int[][] sum;

    public static void main(String args[]) throws IOException {
        int i;
        int j;
        int x;
        int y;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        num=new int[N+1][N+1];
        sum=new int[N+1][N+1];

        for(int s=1;s<N+1;s++){
            st=new StringTokenizer(br.readLine());
            for(int k=1;k<N+1;k++){
                num[s][k]=Integer.parseInt(st.nextToken());
            }
        }

        for(int s=1;s<N+1;s++){

            for(int k=1;k<N+1;k++){
                sum[s][k]=num[s][k]-sum[s-1][k-1]+sum[s-1][k]+sum[s][k-1];

            }
        }
        StringBuilder sb=new StringBuilder();
        for(int s=0;s<M;s++){
            st=new StringTokenizer(br.readLine());
            i=Integer.parseInt(st.nextToken());
            j=Integer.parseInt(st.nextToken());
            x=Integer.parseInt(st.nextToken());
            y=Integer.parseInt(st.nextToken());
           // System.out.println(sum[4][4]);
           sb.append(sum[x][y]+sum[i-1][j-1]-sum[i-1][y]-sum[x][j-1]+"\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
