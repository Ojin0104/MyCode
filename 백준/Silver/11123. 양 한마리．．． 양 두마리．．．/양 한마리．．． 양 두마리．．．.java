import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    static int[] dr={0,1,0,-1};
    static int[] dc={1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(bufferedReader.readLine());
StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<T;i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int H=Integer.parseInt(stringTokenizer.nextToken());
            int W=Integer.parseInt(stringTokenizer.nextToken());
            char[][] map=new char[H][W];
            boolean[][] check=new boolean[H][W];
            answer=0;
            for(int j=0;j<H;j++){
                String str=bufferedReader.readLine();
                for(int k=0;k<W;k++){
                    map[j][k]=str.charAt(k);
                }
            }
            int count=0;
            for(int j=0;j<H;j++){
                for(int k=0;k<W;k++){
                    dfs(j,k,map,check);
                    if(answer>0)count++;
                    answer=0;
                }
            }
            stringBuilder.append(count+"\n");
        }
        System.out.println(stringBuilder);
    }
    static void dfs(int row,int col,char[][] map,boolean[][] check){
        if(check[row][col])return;
        check[row][col]=true;
        if(map[row][col]=='.')return;

        answer++;
        for(int i=0;i<4;i++){
            int next_r=row+dr[i];
            int next_c=col+dc[i];
            if(next_r<0||next_c<0||next_r>=map.length||next_c>=map[0].length)continue;
            dfs(row+dr[i],col+dc[i],map,check);
        }

    }
}
