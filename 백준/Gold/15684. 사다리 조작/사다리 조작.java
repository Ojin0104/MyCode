import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer=4;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N=Integer.parseInt(stringTokenizer.nextToken());
        int M=Integer.parseInt(stringTokenizer.nextToken());
        int H=Integer.parseInt(stringTokenizer.nextToken());
        int[][] ladder=new int[H][N];
        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int r= Integer.parseInt(stringTokenizer.nextToken())-1;
            int c= Integer.parseInt(stringTokenizer.nextToken())-1;
            ladder[r][c]=1;
            ladder[r][c+1]=-1;
            //1일땐 오른쪽으로
            //-1일땐 왼쪽으로

        }

        dfs(ladder,0);
        if(answer==4)answer=-1;

        System.out.println(answer);
    }
    static void dfs(int[][] ladder, int count){
        //검증해서 가능하면 count return
        if(count>=answer)return;
        if(checkLadder(ladder)){
            answer=Math.min(count,answer);
        }
        if(count==3){
            return;
        }


        //모든 경우의수 한번씩 dfs
        for(int i=0;i<ladder.length;i++){
            for(int j=0;j<ladder[0].length-1;j++){
                if(ladder[i][j]==0&&ladder[i][j+1]==0){//이미 사다리 존재
                    ladder[i][j]=1;
                    ladder[i][j+1]=-1;
                    dfs(ladder,count+1);
                    ladder[i][j]=0;
                    ladder[i][j+1]=0;
                }
                
            }
        }
    }

    static boolean checkLadder(int[][] ladder){

        for(int i=0;i<ladder[0].length;i++){
            int r=0;
            int c=i;
            while(r<ladder.length){
                if(ladder[r][c]==1){
                    c++;
                }else if(ladder[r][c]==-1){
                    c--;
                }
                r++;
            }
            if(c!=i)return false;
        }
        return true;
    }
}
