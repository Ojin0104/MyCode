import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {//그냥 방문시 1 a열쇠들고 방문시 11 b열쇠만 들고 방문시 101
    static int N;
    static int M;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static int[][] check;// 체크 배열에 어떤 열쇠들고 방문했었는지 체크// 똑같거나 포함되는 상태이면 큐에 추가 xx
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] map = new char[N][M];
        check = new int[N][M];
        Point startPoint= new Point(0,0);
        //맵 생성
        for(int row=0;row<N;row++){
            String str = br.readLine();
            for(int col=0; col<M;col++){
                map[row][col]=str.charAt(col);
                if(map[row][col]=='0'){
                    startPoint = new Point(row,col);
                    map[row][col]='.';
                }
            }
        }

        int answer = bfs(map,startPoint);

        System.out.println(answer);



    }

    static int bfs(char[][] map, Point startPoint){
        ArrayDeque<Status> queue = new ArrayDeque<>();
        Status start = new Status(0,1,startPoint);
        queue.addLast(start);
        check[startPoint.row][startPoint.col]=1;// 맨몸 방문 체크
        while(!queue.isEmpty()){
            Status now = queue.pollFirst();
            Point nowPoint = now.point;
            //방문했는지 체크

            for(int dir=0;dir<4;dir++){
                int nextR = nowPoint.row+dr[dir];
                int nextC = nowPoint.col+dc[dir];

                if(nextR<0||nextR>=N||nextC<0||nextC>=M)continue;//범위 벗어나는 경우

                //벽인경우
                if(map[nextR][nextC]=='#')continue;


                //방문 검사
                if(checkVisit(check[nextR][nextC],now.visit)) {
                    continue;
                }

                //정답인경우
                if(map[nextR][nextC]=='1')return now.times+1;

                if(map[nextR][nextC]=='.'){
                    check[nextR][nextC]=now.visit;
                    Status nextStatus= new Status(now.times+1,now.visit,new Point(nextR,nextC));
                    queue.addLast(nextStatus);

                }else if(map[nextR][nextC]<='F' &&map[nextR][nextC]>='A'){//열쇠 있는지 체크
                    //몇번째 열쇠인지
                    int key = map[nextR][nextC]-'A';

                    if((now.visit>>(key+1)&1)==1){//해당열쇠 가지고 있는 경우
                        check[nextR][nextC]=now.visit;
                        Status nextStatus= new Status(now.times+1,now.visit,new Point(nextR,nextC));
                        queue.addLast(nextStatus);

                    }
                }else{//열쇠 줍는경우
                    int key = map[nextR][nextC]-'a';
                    int nextVisit= now.visit|1<<(key+1);
                    check[nextR][nextC]=nextVisit;
                    Status nextStatus= new Status(now.times+1,nextVisit,new Point(nextR,nextC));
                    queue.addLast(nextStatus);
                }


            }

        }
        return -1;
    }

    static boolean checkVisit(int ground, int node){//이동할 위치의 땅, 현재 Queue에서 뽑은 민식이가지고 있는 키 상태

        if(ground==0)return false;
        while(ground>0||node>0){
            ground= ground>>1;
            node = node>>1;
            if(node%2==1&&ground%2==0){//해당 열쇠를 들고 처음 방문하는 경우

                return false;
            }

        }

        return true;
    }

    static class Point{
        int row;
        int col;

        public Point(int row, int col){
            this.row=row;
            this.col=col;
        }
    }
    static class Status{
        int times;
        int visit;
        Point point;
        public Status(int times,int visit,Point point){
            this.times= times;
            this.visit=visit;
            this.point=point;
        }
    }
}
