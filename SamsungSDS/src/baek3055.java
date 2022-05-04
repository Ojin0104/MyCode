import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek3055 {
    static int R,C;
    static String[][] map;
    public static void main(String args[][]) throws IOException {
        //1.R행 C열 입력받기(이중배열로)
        //2.한턴이 지날때 바다 물(*)주변의 (.)은 물로 바뀜
        //3.고슴도치는 4방향의 (.)으로 이동가능
        //4.고슴도치는 D와 인접하게되면 종료 ->최소시간 출력
        //5.재귀를 이용하여 출력
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());

        map=new String[R][C];
        for(int i=0;i<R;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                map[i][j]=st.nextToken();
            }
        }

        //1번끝


    }
}
