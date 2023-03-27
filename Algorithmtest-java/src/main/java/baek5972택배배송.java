import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.zip.CheckedInputStream;

public class baek5972택배배송 {

    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N=Integer.parseInt(stringTokenizer.nextToken());
        int M=Integer.parseInt(stringTokenizer.nextToken());

        ArrayList<Point>[] roads=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            roads[i]=new ArrayList<Point>();
        }
        for(int i=0;i<M;i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int left=Integer.parseInt(stringTokenizer.nextToken());
            int right=Integer.parseInt(stringTokenizer.nextToken());
            int cows=Integer.parseInt(stringTokenizer.nextToken());

            roads[left].add(new Point(right,cows));
            roads[right].add(new Point(left,cows));
        }
        int[] dist=new int[N+1];
        boolean[] visited=new boolean[N+1];
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(1,0));
        Arrays.fill(dist,Integer.MAX_VALUE);
        while(!queue.isEmpty()){

            Point point=queue.poll();
            if(visited[point.place])continue;
            visited[point.place]=true;
            dist[point.place]=Math.min(dist[point.place],point.cows);
            if(point.place==N)break;

            for(int i=0;i<roads[point.place].size();i++){
                Point next=roads[point.place].get(i);

                    if(dist[next.place]>point.cows+next.cows)
                    queue.add(new Point(next.place,point.cows+next.cows));


            }
        }
        System.out.println(dist[N]);


    }
    static class Point implements Comparable<Point>{
        int place;
        int cows;
        Point(int place,int cows){
            this.place=place;
            this.cows=cows;
        }



        @Override
        public int compareTo(Point o) {
            return this.cows-o.cows;
        }
    }

}
