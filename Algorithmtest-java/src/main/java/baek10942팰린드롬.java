import java.io.*;
import java.util.StringTokenizer;

public class baek10942팰린드롬 {
    static int N;
    static int[] numbers;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        numbers=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }
        //dp[i][j]: i~j까지 가 팰론드롬인지
        boolean[][] dp=new boolean[N][N];

        for(int i=0;i<N;i++){
            dp[i][i]=true;
        }

        for(int i=0;i<N-1;i++){
            dp[i][i+1]=numbers[i]==numbers[i+1];
        }
    for(int k=1;k<N;k++)
            for(int i=0;i<N-k;i++){
                int j=i+k;
                    if(numbers[i]==numbers[j]){
                        dp[i][j]=dp[i+1][j-1];

                }
            }

        st=new StringTokenizer(br.readLine());
        int M=Integer.parseInt(st.nextToken());
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            if(dp[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]){
                bw.write(1+"\n");
            }else{
                bw.write(0+"\n");
            }
        }
        bw.flush();
        bw.close();

    }
}
