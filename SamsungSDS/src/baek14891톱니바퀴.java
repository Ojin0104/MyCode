
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek14891톱니바퀴 {
    static int[][] map=new int[5][8];
    static int[] map_index=new int[5];
    static int[] check=new int[5];

    static public void main(String args[]) throws IOException {
        int answer=0;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=1;i<5;i++){
            st=new StringTokenizer(br.readLine());
            String line=st.nextToken();
            for(int j=0;j<8;j++){
                map[i][j]=Integer.parseInt(String.valueOf(line.charAt(j)));

            }

        }
        st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());

            //톱니바퀴 움직이는 함수
            topniTurncheck(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));

        }
        for(int i=1;i<5;i++){
            if(map[i][map_index[i]]==1)
                answer+=Math.pow(2,i-1);
        }
        System.out.println(answer);
    }

    static void topniTurncheck(int n,int dir){
        //먼저 모든 톱니 도는 방향 결정 후 한번에 돌림
        //돌리기 전 맞닿은 극 같을때만 반대로 돌림
        //오른쪽먼저
        int k=n;
        check[n]=dir;

        while(k<4){
            if(map[k][(map_index[k]+2)%8]!=map[k+1][(map_index[k+1]+6)%8]){
                check[k+1]=-check[k];
            }
            k+=1;
        }
        k=n;

        while(k>0){
            if(map[k][(map_index[k]+6)%8]!=map[k-1][(map_index[k-1]+2)%8]){
                check[k-1]=-check[k];
            }
            k-=1;
        }

        for(int i=1;i<5;i++){

            if(check[i]!=0){
                topniTurn(i,check[i]);
                check[i]=0;}
        }

    }

    static void topniTurn(int n,int dir){
        if(dir==1){
            if(map_index[n]==0)
                map_index[n]=8;
            map_index[n]=(map_index[n]-1);
        }else{
            map_index[n]=(map_index[n]+1)%8;
        }

    }

}
