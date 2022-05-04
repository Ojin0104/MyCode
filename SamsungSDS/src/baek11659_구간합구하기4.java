import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class baek11659_구간합구하기4 {
    static int M;
    static int N;
    static int[] num;
    static int[] sum;
    public static void main(String args[]) throws IOException {

        int i;
        int j;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        num=new int[N+1];
        sum=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int s=1;s<=N;s++){
            num[s]=Integer.parseInt(st.nextToken());
        }
        for(int s=1;s<=N;s++){
            sum[s]=sum[s-1]+num[s];
        }

        StringBuilder sb=new StringBuilder();
        for(int s=0;s<M;s++){
            st=new StringTokenizer(br.readLine());
            i=Integer.parseInt(st.nextToken());
            j=Integer.parseInt(st.nextToken());

            sb.append(sum[j]-sum[i-1]+"\n");
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
