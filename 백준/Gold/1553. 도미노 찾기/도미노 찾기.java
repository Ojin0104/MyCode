import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map=new int[8][7];
    static boolean[][] check=new boolean[8][7];
    static boolean[][] domino=new boolean[7][7];
    //오른쪽으로만 이동하다가 만약 오른쪽 칸이 차있으면 뛰어넘음 만약 최대범위넘으면 아랫줄 계산
    public static void main(String[] args) throws IOException {


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<8;i++){
           String a=br.readLine();
            for(int j=0;j<a.length();j++){
                map[i][j]=a.charAt(j)-'0';

                }


        }

        System.out.println(dfs(0,0));

    }
    static int dfs(int row,int col){
        if(row==8)return 1;
        int count=0;
        int next_r=row;
        int next_c=col+1;

        if(next_c==7){
            next_r++;
            next_c=0;
        }

        if(check[row][col])return dfs(next_r,next_c);



        int[] d_r={0,1};
        int[] d_c={1,0};

        for(int i=0;i<2;i++){
            int m_r=row+d_r[i];
            int m_c=col+d_c[i];
            if(m_r>7||m_c>6)continue;
            int one=map[m_r][m_c];
            int two=map[row][col];

            if(domino[one][two]||check[m_r][m_c])continue;

            domino[one][two]=true;
            domino[two][one]=true;
            check[m_r][m_c]=true;
            count+=dfs(next_r,next_c);
            check[m_r][m_c]=false;
            domino[one][two]=false;
            domino[two][one]=false;
        }


        return count;

    }

}
