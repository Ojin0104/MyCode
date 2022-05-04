import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class baek1655가운데를말해요 {

    static int N;
    static PriorityQueue<Integer> low=new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> high=new PriorityQueue();
    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        int num;
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<N;i++){
            num=Integer.parseInt(br.readLine());
            if(i==0) {
                low.add(num);
            }else if(low.peek()>num){
                low.add(num);
                if(low.size()>high.size()+1)
                high.add(low.poll());

            }else if(low.peek()==num){
                if(low.size()==high.size())
                    low.add(num);
                else
                    high.add(num);

            }else{
                high.add(num);
                if(high.size()>low.size()){
                  low.add(high.poll());
                }

            }
            bw.append(low.peek()+"\n");
        }
        bw.flush();
        bw.close();
    }
}
