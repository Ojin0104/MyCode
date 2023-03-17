import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek19637if문좀대신써줘 {
static int N;
static int M;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        String[][] name=new String[N][2];
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());

            name[i][0]=st.nextToken();
            name[i][1]=st.nextToken();

        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            int left=0;
            int right=N-1;

            int num=Integer.parseInt(br.readLine());

            while(left<=right){
                int mid=(left+right)/2;
                if(Integer.parseInt(name[mid][1])<num){
                    left=mid+1;
                }else{
                    right=mid-1;
                }


            }
            sb.append(name[left][0]+"\n");

        }
    System.out.println(sb.toString());
    }
}
