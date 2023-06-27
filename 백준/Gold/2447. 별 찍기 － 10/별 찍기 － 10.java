import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());
        map=new char[N][N];
        makeStar(N,new Point(0,0),new Point(N-1,N-1));
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]!='*')map[i][j]=' ';
                stringBuilder.append(map[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }
    static public void makeStar(int size,Point start,Point end){
        if(size==1){
            map[start.r][start.c]='*';
            return;
        }
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==1&&j==1)continue;
                Point nextStart=new Point(start.r+(end.r-start.r+1)/3*i,start.c+(end.c-start.c+1)/3*j);
                Point nextEnd=new Point(start.r+(end.r-start.r+1)/3*(i+1)-1,start.c+(end.c-start.c+1)/3*(j+1)-1);
                makeStar(size/3,nextStart,nextEnd);
            }
        }
    }


    static class Point{
        int r;
        int c;

        public Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}
