import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

       // int[] choices = new int[C];
        Picture[] picture = new Picture[N];
        for(int i=0;i<N;i++){
            picture[i] = new Picture(-1,-1);
        }
        StringTokenizer st= new StringTokenizer(br.readLine());

        for(int time= 0 ;time<C;time++){
           int pic= Integer.parseInt(st.nextToken());
           findPic(picture,pic,time);
        }

        Arrays.sort(picture,(a,b)->a.num-b.num);

        StringBuilder sb = new StringBuilder();

        for(int i =0;i<N;i++){
            if(picture[i].time!=-1)
                sb.append(picture[i].num+" ");
        }
        System.out.println(sb);
    }

    public static void findPic(Picture[] picture, int pic, int time){
        for(int i=0;i<idx;i++){
            if(picture[i].num ==pic){
                picture[i].upLike();

                return;
            }
        }

        if(idx<picture.length){
            picture[idx++] = new Picture(time,pic);
        }else{
            Arrays.sort(picture,(a,b)->{
                if(a.like==b.like){
                    return a.time-b.time;
                }else{
                    return a.like-b.like;
                }
            });
            picture[0] = new Picture(time,pic);
        }
    }

    static class Picture{
        int time;
        int like;
        int num;
        Picture(int time,int num){
            this.time=time;
            this.num=num;
            this.like =1;
        }

        public void setTime(int time){
            this.time = time;
        }

        public void upLike(){
            this.like++;
        }

        public void reset(){
            this.like=0;
        }
    }
}
