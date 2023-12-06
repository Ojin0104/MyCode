import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                for(int k = 0 ;k<N;k++){
                    map[j][k]=Math.max(map[j][k],Math.min(map[j][i],map[i][k]));
                }
            }
        }

        StringBuilder sb= new StringBuilder();

        for(int row =0;row<N;row++){
            for(int col=0;col<N;col++){
                sb.append(map[row][col]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
