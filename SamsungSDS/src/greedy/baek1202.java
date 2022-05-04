package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
//////////작은 가방부터해서 넣을 수 있는 것 중에 가장 비싼 보석을 넣기
public class baek1202 {
    static int N;
    static int K;
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        Jewelry[] jewelries=new Jewelry[N];
        int[] bags=new int[K];
        for(int i=0;i<N;i++){//보석정보저장
            st=new StringTokenizer(br.readLine());
            jewelries[i]=new Jewelry(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }


        for(int i=0;i<K;i++){//가방정보저장

            bags[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
        Arrays.sort(jewelries,Comparator.comparingInt(Jewelry::getGram));

        PriorityQueue<Jewelry> pq=new PriorityQueue<>();
        int jIndex=0;
        long result=0;

        for(int i=0;i<K;i++){
                int bag=bags[i];
                //2.선택된 가방에 넣을 수 있는 가장비싼보석
                while(jIndex<N&&jewelries[jIndex].gram<=bag){
                    pq.add(jewelries[jIndex++]);

                    }
                if(!pq.isEmpty()){
                    result+=pq.poll().price;
                }
            }
            System.out.println(result);


    }
    static class Jewelry implements Comparable<Jewelry>{
        int gram;
        int price;
        Jewelry(int g,int p){
            this.gram=g;
            this.price=p;
        }
        public int getGram(){return gram;}
        public int getPrice(){return price;}
        @Override
        public int compareTo(Jewelry o) {
            if(this.price<o.price)return 1;
            else if(this.price==o.price)return 0;
            return -1;
        }
    }
}
