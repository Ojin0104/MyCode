import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * 1. 물이 몇초에 해당 지점에 덮치게 되는지 int 배열에 기록해둔다. bfs사용
 * 2. 물웅덩이가 여러개 이므로 bfs 시작 시 queue에  여러개 넣고 시작한다.
 * 3. 고슴도치 시간초 고려하여 물웅덩이 피해 이동 (bfs)
 */
public class Main {
    static int R;
    static int C;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        char[][] map =new char[R][C];
        int[][] water = new int[R][C];//몇초에 물이 차는지 저장
        List<Point> waterPoints =new ArrayList();
        Point startPoint= null;
        for(int row = 0 ;row<R;row++){
            String nextLine=  br.readLine();
            Arrays.fill(water[row],Integer.MAX_VALUE);

            for(int col = 0 ;col<C;col++){
                map[row][col]=nextLine.charAt(col);
                if(map[row][col]=='*'){//물 시작
                    waterPoints.add(new Point(row,col));
                }else if(map[row][col]=='S'){//고슴도치 시작
                    startPoint = new Point(row,col);
                }
            }
        }

        //bfs로 물 차는 시간 계산
        waterBfs(waterPoints,map,water);
        //bfs로 고슴도치굴에 도착하는 최단 시간 계산
        int answer = findBfs(startPoint,map,water);
        if(answer==-1){
            System.out.println("KAKTUS");
        }else{
            System.out.println(answer);
        }
    }

    static int findBfs(Point startPoint, char[][] map, int[][] water ){//고슴도치 움직이기
        Queue<Gosumdochi> que = new ArrayDeque<>();
        que.add(new Gosumdochi(startPoint,0));
        boolean[][] check = new boolean[R][C];
        check[startPoint.row][startPoint.col]=true;
        while(!que.isEmpty()){

            Gosumdochi now = que.poll();


            for(int dir =0 ; dir<4 ; dir++){
                int nextR = now.point.row+dr[dir];
                int nextC = now.point.col + dc[dir];
                if(nextR<0||nextR>=R||nextC<0||nextC>=C)continue;//범위 벗어나는 경우

                if(map[nextR][nextC]=='X')continue;
                if(map[nextR][nextC]=='D'){
                    return now.time+1;
                }
                if(check[nextR][nextC]||water[nextR][nextC]<=now.time+1)continue;

                check[nextR][nextC]=true;
                que.add(new Gosumdochi(new Point(nextR,nextC),now.time+1));


            }
        }

        return -1;
    }




    static void waterBfs(List<Point> waterPoints, char[][] map, int[][] water){//물 퍼뜨리는 메소드
        Queue<Point> que = new ArrayDeque<>();
        for(Point waterPoint: waterPoints){//큐에 모든 물웅덩이 지점을 넣어줌
            que.add(waterPoint);
            water[waterPoint.row][waterPoint.col]=0;//물웅덩이 시작지점 0으로 초기화

        }

        while(!que.isEmpty()){

            Point now = que.poll();

            for(int dir =0; dir<4;dir++){
                int nextR = now.row+dr[dir];
                int nextC = now.col + dc[dir];

                if(nextR<0||nextR>=R||nextC<0||nextC>=C)continue;//범위 벗어나는 경우

                if(map[nextR][nextC]=='X'||map[nextR][nextC]=='D')continue;//돌덩이나 굴 일경우 pass

                if(water[nextR][nextC]>water[now.row][now.col]+1){
                    //아직 방문하지 않은 경우
                    water[nextR][nextC] = water[now.row][now.col]+1;
                    que.add(new Point(nextR,nextC));

                }


            }
        }
    }
    static class Point{
        int row;
        int col;
        public Point(int row, int col){
            this.row=row;
            this.col=col;
        }
    }

    static class Gosumdochi{
        Point point;
        int time;

        public Gosumdochi(Point point,int time){
            this.point = point;
            this.time = time;
        }
    }
}
