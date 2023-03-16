import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baek2075N번째큰수 {
    static int n;

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n=Integer.parseInt(stringTokenizer.nextToken());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j=0;j<n;j++) {
                if(priorityQueue.size()<n)
                    priorityQueue.add(Integer.parseInt(stringTokenizer.nextToken()));
                else{
                    priorityQueue.poll();
                    priorityQueue.add(Integer.parseInt(stringTokenizer.nextToken()));
                }
            }
        }


        System.out.println(priorityQueue.poll());
    }
}
