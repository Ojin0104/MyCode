import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {//해렬로 안받고 집 배열 치킨배열따로 받은후 치킨집 중에 M개를 받아 그때의 각각의 집마다 가장가까운 치킨집 값 저장 아니면 M개의 거리값 저장할까
    static ArrayList<point> home=new ArrayList<>();
    static ArrayList<point> chicken=new ArrayList<>();
    static ArrayList<Integer>[] distance;
    static ArrayList<int[]> combnum=new ArrayList<>();
   
    static int N;
    static int M;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());


    for(int i=1;i<=N;i++){
        st=new StringTokenizer(br.readLine());
        for(int j=1;j<=N;j++){
            int type=Integer.parseInt(st.nextToken());
            if (type == 1) {//집일때
                home.add(new point(i,j));

            }else if(type==2){//치킨집일때
                chicken.add(new point(i,j));
            }

        }
    }

   
    //치킨거리구하기
        distance=new ArrayList[home.size()];
    for(int i=0;i<home.size();i++){
        distance[i]=new ArrayList<>();
    }
    int length;
    for(int i=0;i<home.size();i++){

        for(int j=0;j<chicken.size();j++){//distance의 i,j에 i번쨰마을에서 j번째 치킨집 까지의 거리 구함
            length=Math.abs(home.get(i).x-chicken.get(j).x)+Math.abs(home.get(i).y-chicken.get(j).y);
            distance[i].add(length);
        }
    }
    //이제 M 개의 치킨집 선정후 각 집의 최소값 구해 더해주면 끝 치킨집에 각 번호가 0~M-1까지 있다고 생각
    boolean[] visited=new boolean[chicken.size()];
     comb(visited,0,M);//combnum배열에 모두 저장

int summin=Integer.MAX_VALUE;
        //이제 각 선정한 치킨집들과 집까지의 거리의 최소값들을 집마다 구하고 모든합을 leastcomb에 넣어줌 그안에서 최소값을 출력
        for(int i=0;i<combnum.size();i++){//조합별
            int sum=0;
            for(int j=0;j<home.size();j++){//집별
                int min=100000;
                int dist=0;
                for(int k=0;k<M;k++){//치킨집별
                     dist=distance[j].get(combnum.get(i)[k]);//j번쨰집에서 k번째 치킨집 까지 거리
                     if(min>dist)min=dist;

                 }
                sum+=min;
            }
            if(summin>sum)summin=sum;
        }
        System.out.println(summin);
    }
    static class point{
        int x;
        int y;
        point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }//visited 는 크기 치킨집 갯수만큼
    static void comb(boolean[] visited,int depth,int r){//depth==arr.length가 되면 그냥 return  r은 몇개뽑는지
        if(r==0){//다뽑혔으면 새로운 배열에
            int[] result=new int[M];
            int j=0;
            for(int i=0;i<chicken.size();i++){
                if(visited[i]==true) {
                    result[j]=i;
                            j++;
                }
            }
            combnum.add(result);
            return;
        }
        if(depth==visited.length){
            return;
        }
        visited[depth]=true;
        comb(visited,depth+1,r-1);
        visited[depth]=false;
        comb(visited,depth+1,r);

    }
}
