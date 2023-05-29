import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int answer=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(bufferedReader.readLine());
        if(N==1){
            System.out.println(0);
            System.out.println(1);
            return;
        }
        StringBuilder arrayList = bfs(N);
        
        System.out.println(answer);

        System.out.print(arrayList);

    }
    static StringBuilder bfs(int N){
        Queue<Node> queue = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(N);

        queue.add(new Node(N,0,stringBuilder));

        while(!queue.isEmpty()){

            Node next=queue.poll();

            int num= next.N;
            int count=next.count;
            StringBuilder stringBuilder1 = next.stringBuilder;

            if(num%3==0){
                int i=num/3;
                StringBuilder stringBuilder2=new StringBuilder(stringBuilder1);
                stringBuilder2.append(" "+i);
                if(i==1){
                    answer=count+1;
                    return stringBuilder2;
                }
                queue.add(new Node(i,count+1,stringBuilder2));
            }
            if(num%2==0){
                int i=num/2;
                StringBuilder stringBuilder2=new StringBuilder(stringBuilder1);

                stringBuilder2.append(" "+i);
                if(i==1){
                    answer=count+1;
                    return stringBuilder2;
                }
                queue.add(new Node(i,count+1,stringBuilder2));
            }
            int i=num-1;

            StringBuilder stringBuilder2=new StringBuilder(stringBuilder1);
            stringBuilder2.append(" "+i);
            if(i==1){
                answer=count+1;
                return stringBuilder2;
            }
            queue.add(new Node(i,count+1,stringBuilder2));


        }
        return null;
    }

    static class Node{
        int N;
        int count;
        StringBuilder stringBuilder;
        Node(int N,int count, StringBuilder stringBuilder){
            this.N=N;
            this.count=count;
            this.stringBuilder=stringBuilder;
        }
    }
}
