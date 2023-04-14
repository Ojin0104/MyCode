import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class baek2932표회전 {

    public static void main(String args[]) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N=Integer.parseInt(stringTokenizer.nextToken());
        int T=Integer.parseInt(stringTokenizer.nextToken());
        ArrayList<String> arrayList = new ArrayList<>();
        //0: ,행회전횟수, 고른행, 회전횟수,고른열 고르지 않았을경우
        StringBuilder stringBuilder = new StringBuilder();
        int[][] map=new int[N][N];
        int now=0;
        //ArrayList<>
        for(int i=0;i<N ;i++){
            for(int j=0;j<N ;j++){
                now++;
                map[i][j]=now;
            }
        }
        for(int t=0;t<T;t++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int findnum=Integer.parseInt(stringTokenizer.nextToken())-1;
            int moved_r=Integer.parseInt(stringTokenizer.nextToken())-1;
            int moved_c=Integer.parseInt(stringTokenizer.nextToken())-1;
            int r=findnum/N;
            int c=findnum%N;

            //현재위치찾기
            for(String movestr:arrayList){
                String[] movs=movestr.split(" ");
                int[] move=new int[movs.length];
                for(int i=0;i<movs.length;i++){
                    move[i]=Integer.parseInt(movs[i]);
                }

                if(r==move[1]){
                    c=(c+move[0])%N;

                }
                if(c==move[3]){
                    r=(r+move[2])%N;
                }
            }
            //옮기기

            int n_r=0;
            int n_c=0;

            if(moved_c>=c){
                n_c=moved_c-c;
            }else{
                n_c=N-c+moved_c;
            }


            if(moved_r>=r){
                n_r=moved_r-r;
            }else{
                n_r=N-r+moved_r;
            }
            stringBuilder.append(n_r+n_c+"\n");
            arrayList.add(n_c+" "+r+" "+n_r+" "+moved_c);

        }
        System.out.println(stringBuilder);
    }
}
