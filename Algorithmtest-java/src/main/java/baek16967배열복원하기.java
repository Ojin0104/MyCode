import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek16967배열복원하기 {
    //0이 포함된 행과열은 정상적인행렬이다.
    //중복시작지점 == X,Y
    //1.정상값저장후 그걸토대로 계산하면 끝이네
    public static void main(String args[]) throws IOException {
        int H,W,X,Y;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        H=Integer.parseInt(st.nextToken());
        W=Integer.parseInt(st.nextToken());
        X=Integer.parseInt(st.nextToken());
        Y=Integer.parseInt(st.nextToken());

        int[][] map=new int[H+X][W+Y];

        for(int i=0;i<H+X;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<W+Y;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer=new int[H][W];

        for(int i=0;i<X;i++){
            for(int j=0;j<W;j++){
                answer[i][j]=map[i][j];
            }
        }
        for(int i=0;i<H;i++){
            for(int j=0;j<Y;j++){
                answer[i][j]=map[i][j];
            }
        }
        for(int i=X;i<H;i++){
            for(int j=Y;j<W;j++){
                answer[i][j]=map[i][j]-answer[i-X][j-Y];
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());





    }
}
