import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int[] dr={0,0,-1,1};
    static int[] dc={1,-1,0,0};
    static int[][] map;
    static int[][] horsemap;
    static int N;
    static int K;
    static Horse[] horses;
    static boolean flag=false;
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N=Integer.parseInt(stringTokenizer.nextToken());
        K=Integer.parseInt(stringTokenizer.nextToken());

        map=new int[N][N];
        horsemap=new int[N][N];

        for(int i=0;i<N;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<N;j++){
                map[i][j]= Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        horses=new Horse[K+1];
        for(int i=1;i<K+1;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int row=Integer.parseInt(stringTokenizer.nextToken());
            int col=Integer.parseInt(stringTokenizer.nextToken());
            int dir=Integer.parseInt(stringTokenizer.nextToken());
            horses[i]=new Horse(row-1,col-1,dir,i);
            horsemap[row-1][col-1]=i;
        }

        int answer=0;

        while(answer<=1000){
            if(flag)break;
            answer++;
            for(int i=1;i<K+1;i++){
                Horse now=horses[i];
                //아빠있으면 pass
                if(now.father)continue;
                moveCheck(now);

            }

        }
        if(answer>1000)answer=-1;
        System.out.println(answer);


    }

    static void moveCheck(Horse horse){
        int next_r=horse.row+dr[horse.dir-1];
        int next_c=horse.col+dc[horse.dir-1];

        if(next_r<0||next_r>=N||next_c<0||next_c>=N){

            if(horse.dir%2==0)horse.dir--;
            else{
                horse.dir++;
            }

            next_r=horse.row+dr[horse.dir-1];
            next_c=horse.col+dc[horse.dir-1];

        }

        if(map[next_r][next_c]==2){
            if(horse.dir%2==0)horse.dir--;
            else{
                horse.dir++;
            }
            next_r=horse.row+dr[horse.dir-1];
            next_c=horse.col+dc[horse.dir-1];
            if(next_r<0||next_r>=N||next_c<0||next_c>=N){
                return;}

            }
        int fatherhorse=horsemap[next_r][next_c];
        if(map[next_r][next_c]==0){
            horsemap[horse.row][horse.col]=0;
            if(horsemap[next_r][next_c]!=0){


                horses[fatherhorse].addStack(horse.child);

                horse.setFather(true);
            }else{
                horse.row=next_r;
                horse.col= next_c;
                horsemap[next_r][next_c]=horse.num;
            }
        }else if(map[next_r][next_c]==1){
            horsemap[horse.row][horse.col]=0;
            if(horsemap[next_r][next_c]!=0){//순서반대로


                horses[fatherhorse].addrevStack(horse.child);

                horse.setFather(true);
            }else{
                horse.row=next_r;
                horse.col= next_c;
                if(horse.child.size()>1) {
                    int father = horse.child.pop();
                    horsemap[next_r][next_c]=father;
                    horses[father].addrevStack(horse.child);
                    horses[father].row=next_r;
                    horses[father].col=next_c;
                    horses[father].setFather(false);
                    horse.setFather(true);
                    if(horses[father].child.size()>=4)flag=true;
                }else {
                    horsemap[next_r][next_c] = horse.num;
                }
            }
        }

        if(fatherhorse!=0) {

            if (horses[fatherhorse].child.size() >= 4) flag = true;

        }





    }

    static class Horse{
        int row;
        int col;
        int dir;
        int num;
        boolean father;
        Stack<Integer> child;
        Horse(int row,int col,int dir,int num){
            this.row=row;
            this.col=col;
            this.dir=dir;
            this.num=num;
            child=new Stack<>();
            child.add(num);
        }
        void setFather(boolean father){
            this.father=father;
        }

        void addStack(Stack<Integer> horses){
            for(int i=0;i<horses.size();i++){
                child.add(horses.get(i));
            }
        }
        void addrevStack(Stack<Integer> horses){
            while(horses.size()>1){
                child.add(horses.pop());
            }
            child.add(horses.peek());
        }
    }
}
