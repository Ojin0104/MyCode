import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int target;
    static int num;
    static int mincount;
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        num=Integer.parseInt(stringTokenizer.nextToken());
        target= Integer.parseInt(stringTokenizer.nextToken());
        mincount=Integer.MAX_VALUE;
        int max=Math.max(target,num);
        int[] dp=new int[100003];
        boolean[] check=new boolean[100003];

        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[num]=0;
        PriorityQueue<Position> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Position(num,0));
        while(priorityQueue.size()!=0){

            Position now=priorityQueue.poll();
            if(check[now.index])continue;
            check[now.index]=true;
            dp[now.index]=now.time;

            if(now.index>=100001)
                continue;

            if(dp[now.index+1]>now.time+1&&!check[now.index+1])
                priorityQueue.add(new Position(now.index+1,now.time+1));

            if(now.index!=0) {
                if (dp[now.index - 1] > now.time+1&&!check[now.index-1])
                    priorityQueue.add(new Position(now.index - 1, now.time + 1));
            }
            if(2*now.index>=100001)continue;

            if(dp[2*now.index]>now.time&&!check[2*now.index]) {
                priorityQueue.add(new Position(now.index * 2, now.time));
            }

        }
        System.out.println(dp[target]);
    }
}
class Position implements Comparable<Position>{
    int index;
    int time;

    public Position(int index,int time){
        this.index=index;
        this.time=time;
    }

    @Override
    public int compareTo(Position o) {
        return this.time-o.time;
    }
}
