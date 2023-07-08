import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int K;
    static int answer=0;
    static int[] n_row={1,0,-1,0};
    static int[] n_col={0,1,0,-1};
    static boolean check[][];
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        R=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        char[][] arr=new char[R][C];
        check=new boolean[R][C];
        for(int i=0;i<R;i++){
            st=new StringTokenizer(br.readLine());
            String s=st.nextToken();
            for(int j=0;j<C;j++){
                arr[i][j]=s.charAt(j);
            }
        }
        check[R-1][0]=true;
        dfs(arr,R-1,0,1);
        System.out.println(answer);
    }
    static void dfs(char[][] arr,int row,int col,int count){
        if(count>K){

            return;

        }
        
        if(row==0&&col==C-1){
            
            if(count==K){
                answer++;
            }

            return;
        }

        for(int i=0;i<4;i++){
            if(row+n_row[i]<0||col+n_col[i]<0||row+n_row[i]>=R||col+n_col[i]>=C)
                continue;
            if(check[row+n_row[i]][col+n_col[i]]||arr[row+n_row[i]][col+n_col[i]]=='T')
                continue;
            check[row+n_row[i]][col+n_col[i]]=true;
            dfs(arr,row+n_row[i],col+n_col[i],count+1);
            check[row+n_row[i]][col+n_col[i]]=false;
        }
    }
}