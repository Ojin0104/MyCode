import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek17281야구 {

    static boolean[] check=new boolean[10];
    static int N;
    static int[][] board;
    static int max=Integer.MIN_VALUE;
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N=Integer.parseInt(stringTokenizer.nextToken());
        board=new int[N+1][10];
        for(int i=1;i<=N;i++){
            stringTokenizer =new StringTokenizer(bufferedReader.readLine());

            for(int j=1;j<10;j++){
                board[i][j]=Integer.parseInt(stringTokenizer.nextToken());
            }

        }
        int[] player=new int[10];
        player[4]=1;//4번타자는 1번으로 고정
        check[1]=true;
        dfs(player,1);
        System.out.println(max);
    }

    public static void dfs(int[] player,int num){
        if(num==4)
            num++;

        for(int i=2;i<=9;i++) {
            if (!check[i]) {
                player[num] = i;
                check[i] = true;
                dfs(player, num + 1);
                check[i] = false;

            }
        }

        if(num==9)
               countScore(player);//점수계산
    }
    public static void countScore(int[] player){
        int now=1;
        int turn=1;
        int out=0;
        boolean[] room=new boolean[4];
        room[0]=true;
        int point =0;
        while(now<=N){
            if(board[now][player[turn]]==0){
                out++;
                if(out==3){
                    out=0;
                    now++;
                    for(int i=1;i<=3;i++)
                        room[i]=false;
                }


            }else{
                for(int i=3;i>=0;i--){
                    if(room[i]) {
                        if (i + board[now][player[turn]] >= 4)
                            point++;

                        else {
                            room[i + board[now][player[turn]]] = true;
                        }
                        if(i!=0)
                            room[i]=false;
                    }
                }

            }

            turn++;
            if(turn==10)
                turn=1;




        }

        max=Math.max(max,point);



    }
}
