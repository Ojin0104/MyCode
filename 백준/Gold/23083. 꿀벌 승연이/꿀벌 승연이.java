import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N=Integer.parseInt(stringTokenizer.nextToken());
        int M=Integer.parseInt(stringTokenizer.nextToken());

        int K=Integer.parseInt(bufferedReader.readLine());

        long[][] map=new long[N][M];
        for(int i=0;i<K;i++){
            stringTokenizer=new StringTokenizer(bufferedReader.readLine());
            map[Integer.parseInt(stringTokenizer.nextToken())-1][Integer.parseInt(stringTokenizer.nextToken())-1]=-1;

        }
        map[0][0]=1;

            for(int j=0;j<M;j++){
                for(int i=0;i<N;i++){
                if(map[i][j]==-1)continue;
               // System.out.println(map[i][j]);

                if(i<N&&j+1<M){
                    if(map[i][j+1]!=-1){
                        map[i][j+1]=map[i][j+1]+map[i][j]%((long)Math.pow(10,9)+7);
                    }
                        }
                if(i+1<N&&j<M){//아래
                    if(map[i+1][j]!=-1)
                        map[i+1][j]=(map[i+1][j]+map[i][j])%((long)Math.pow(10,9)+7);}

                if(j%2==0) {//홀수일때 위옆{
                    if(i-1>=0&&i-1<N&&j+1<M){
                        if(map[i-1][j+1]!=-1)
                            map[i-1][j+1]=(map[i-1][j+1]+map[i][j])%((long)Math.pow(10,9)+7);}

                }else{
                    if(i+1<N&&j+1<M){
                        if(map[i+1][j+1]!=-1)
                            map[i+1][j+1]=(map[i+1][j+1]+map[i][j])%((long)Math.pow(10,9)+7);}
                }


            }


        }



        System.out.println(map[N-1][M-1]);
    }
}
