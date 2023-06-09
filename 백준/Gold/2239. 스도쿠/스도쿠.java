import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean flag=false;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        char[][] map=new char[9][9];
        for(int i=0;i<9;i++){
            String line=br.readLine();
            for(int j=0;j<9;j++){
                map[i][j]=line.charAt(j);
            }
        }
        dfs(map,0,0);
    }
    static void dfs(char[][] map,int x,int y){
        if(flag)return;
        if(x==9&&y==0){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            flag=true;
            return;
        }

        int next_x=x;
        int next_y=y+1;
        if(next_y>=9){
            next_y=0;
            next_x+=1;
        }
        if(map[x][y]!='0'){
            dfs(map,next_x,next_y);
        }else{
            for(int i=1;i<=9;i++){
                if(checkLine(map,x,y,i)&&checkSquare(map,x,y,i)){
                    
                    map[x][y]=(char)(i+'0');
                    dfs(map,next_x,next_y);
                    map[x][y]='0';
                    if(flag)return;
                }
            }
        }
    }

   
    static boolean checkLine(char[][] map,int x,int y,int num){
        char numch=(char)(num+'0');
        for(int i=0;i<9;i++){
            if(map[x][i]==numch)return false;
            if(map[i][y]==numch)return false;
        }
        return true;
    }

    static boolean checkSquare(char[][] map,int x,int y,int num) {
        char numch = (char) (num + '0');
        int startx=x/3;
        int starty=y/3;
        for(int i=startx*3;i<startx*3+3;i++){
            for(int j=starty*3;j<starty*3+3;j++){
                if(map[i][j]==numch)return false;
            }
        }
        return true;
    }
}
