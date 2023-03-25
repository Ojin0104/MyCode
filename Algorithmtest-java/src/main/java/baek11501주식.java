import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek11501주식 {
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T= Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){

            int N=Integer.parseInt(br.readLine());
            PriorityQueue<Point> pq=new PriorityQueue<>();
            int[] nums=new int[N];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                nums[j]=Integer.parseInt(st.nextToken());
                pq.add(new Point(j,nums[j]));

            }
            int total=0;//번돈
            int count=0;//산주식갯수
            int money=0;//사용한돈
            int index=0;
            while(index<nums.length&&!pq.isEmpty()){
                Point max=pq.poll();

                if(max.x<index)continue;
                for(int j=index;j<max.x;j++){
                    money+=nums[j];
                    count++;
                }
                total+=count*max.cost-money;
                index=max.x+1;
                count=0;
                money=0;
            }

            sb.append(total+"\n");

        }
        System.out.println(sb.toString());
    }
    static class Point implements Comparable<Point> {
        int x;
        int cost;

        public Point(int x, int cost){
            this.x=x;
            this.cost=cost;
        }



        @Override
        public int compareTo(Point o) {
            return o.cost-this.cost;
        }
    }
}
