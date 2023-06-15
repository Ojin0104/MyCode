import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder answer=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[] degree=new int[N+1];
        ArrayList<Integer>[] map=new ArrayList[N+1];
        for(int i=0;i<N+1;i++){
            map[i]=new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int before=0;
            int size=Integer.parseInt(st.nextToken());
            for(int j=0;j<size;j++){
                int now = Integer.parseInt(st.nextToken());
                if(before!=0){
                    map[before].add(now);
                    degree[now]++;
                }
                before=now;
            }

        }

        Queue<Integer> que=new LinkedList<>();

        for(int i=1;i<N+1;i++){
            if(degree[i]==0)que.add(i);
        }

        degreeSort(que,map,degree);


    }

    static void degreeSort(Queue<Integer> que,ArrayList<Integer>[] map,int[] degree){
        int count=0;
        int L=degree.length-1;

        while(!que.isEmpty()){
            int now=que.poll();
            answer.append(now+"\n");
            count++;
            for(Integer next:map[now]){
                degree[next]--;
                if(degree[next]==0)que.add(next);


            }
        }
        
        if(count!=L){
            System.out.println(0);
        }else{
            System.out.println(answer);
        }
    }
}
