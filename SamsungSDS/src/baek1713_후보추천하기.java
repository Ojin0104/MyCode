import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek1713_후보추천하기 {//priorityqueue 두번넣어서 
    public static void main(String args[]) throws IOException {
        int N;
        int S;
        int[] order;
        int[] now;
        ArrayList<photo> pq=new ArrayList<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        S=Integer.parseInt(br.readLine());
        order=new int[N];
        now=new int[N+1];//현재액자에 들어와있는 수
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            order[i]=Integer.parseInt(st.nextToken());
            if(pq.size()<N){
                pq.add(new photo(order[i]));
                now[order[i]]=pq.size();
            }else{
                if(now[order[i]]>=1){//이미 pq안에 존재함
                    pq.get(now[order[i]]-1).goods();
                }else{//pq안에 없다면 가장 추천낮은것중에 오래된거 추천 0으로하고 새로운거 넣어줌

                }
            }
        }


    }
    public static class photo{
        int good;
        int num;
        photo(int num){
            this.num=num;
            this.good=1;
        }
        void goods(){
            this.good++;
        }
    }
}
