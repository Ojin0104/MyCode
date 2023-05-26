import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int white=0;
    static int blue=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(bufferedReader.readLine());
        char[][] map=new char[N][N];
        for(int i=0;i<N;i++){
            String s=bufferedReader.readLine();

            for(int j=0;j<N;j++){
                map[i][j]=s.charAt(2*j);
            }
        }

        cutPaper(map,0,N,0,N);

        System.out.println(white);
        System.out.println(blue);

    }
    static void cutPaper(char[][] map,int r_start,int r_end,int c_start,int c_end){

        if(r_end-r_start==1||checkPaper(map,r_start,r_end,c_start,c_end)){
            if(map[r_start][c_start]=='1'){
                blue+=1;
            }else{
                white+=1;
            }

            return;
        }

        cutPaper(map,r_start,(r_start+r_end)/2,c_start,(c_start+c_end)/2);
        cutPaper(map,r_start,(r_start+r_end)/2,(c_start+c_end)/2,c_end);
        cutPaper(map,(r_start+r_end)/2,r_end,c_start,(c_start+c_end)/2);
        cutPaper(map,(r_start+r_end)/2,r_end,(c_start+c_end)/2,c_end);
    }
    static boolean checkPaper(char[][] map,int r_start,int r_end,int c_start,int c_end){

        char init=map[r_start][c_start];

        for(int i=r_start;i<r_end;i++){
            for(int j=c_start;j<c_end;j++){
                if(map[i][j]!=init)return false;
            }

        }

        return true;
    }
}
