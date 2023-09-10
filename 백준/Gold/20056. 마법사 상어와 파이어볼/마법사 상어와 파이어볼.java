import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;

    static int[] dr={-1,-1,0,1,1,1,0,-1};
    static int[] dc={0,1,1,1,0,-1,-1,-1};
    static ArrayList<Fireball> balls = new ArrayList<>();
    static Fireball[][] map ;
    public static void main(String[]args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map=new Fireball[N][N];
        //파이어볼 입력
        for(int ball=0;ball<M;ball++){
            st = new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Fireball fire=new  Fireball(balls.size(),r-1,c-1,m,s,d);
            balls.add(fire);
            map[r-1][c-1]=fire;
        }


        for(int times=0;times<K;times++){
            moveFireball();
            checkFireball();
            //파이어볼 이동 0번과 N-1번 연결되어있음


            //파이어볼 여러개 있을시 4개로 복제
        }

        System.out.println(ballSum());
        //질량의 합 출력
    }
    static int ballSum(){
        int answer=0;

        for(Fireball ball:balls){
            if(!ball.dead){
                if(ball.count>=2){
                    answer+=(ball.gram/5)*4;
                }else {
                    answer += ball.gram;
                }}
        }
        return answer;
    }

    static void checkFireball(){
        for(int row=0;row<N;row++){
            for(int col=0;col<N;col++){
                if(map[row][col]!=null&&map[row][col].count>=2){
                    Fireball now =map[row][col];
                    int gram=now.gram/5;
                    now.dead=true;
                    map[now.r][now.c]=null;
                    if(gram==0){
                        continue;
                    }
                    int speed=now.speed/now.count;
                    int plus=0;
                    if(now.status)plus=1;
                    for(int dir=0+plus;dir<8;dir+=2){

                        balls.add(new Fireball(balls.size(),now.r,now.c,gram,speed,dir));
                    }


                }
            }
        }
    }

    static void moveFireball(){
        for(int num=0;num<balls.size();num++){
            Fireball now =balls.get(num);
            if(now.dead)continue;
            int next_r= (now.r+now.speed*dr[now.dir])%N;
            int next_c = (now.c+now.speed*dc[now.dir])%N;


            next_r+=N;
            next_c+=N;

            next_r=next_r%N;
            next_c=next_c%N;


            if(map[now.r][now.c]==now){//이동할꺼
                map[now.r][now.c]=null;
            }

                Fireball next = map[next_r][next_c];
                if(map[next_r][next_c]==null||now.id<next.id){//이동하는자리에 없거나 이동할예정인경우
                    now.r=next_r;
                    now.c=next_c;
                    map[next_r][next_c]=now;
                }else{
                    next.count+=1;
                    next.gram+=now.gram;
                    next.speed+=now.speed;

                    if(next.dir%2!=now.dir%2){
                        next.status=true;
                    }

                    now.dead=true;
                }

        }
    }

    static class Fireball{
        int id;//파이어볼 갱신순서 기록
        int r;
        int c;
        int gram;
        int speed;
        int dir;
        boolean dead;
        boolean status; //방향결정
        int count;
        public Fireball(int id,int r, int c, int gram, int speed, int dir){
            this.id =id;
            this.r=r;
            this.c=c;
            this.gram=gram;
            this.speed=speed;
            this.dir=dir;
            this.dead=false;
            this.count=1;
        }

    }
}
