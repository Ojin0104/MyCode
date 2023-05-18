import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(bufferedReader.readLine());

        int answer=bfs(N,0);
        System.out.println(answer);
    }

    static int bfs(int num,int count){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{num,count});

        while(!queue.isEmpty()){
            int[] now=queue.poll();
            if(now[0]==1){
                return now[1];
            }
            if(now[0]%3==0){
                queue.add(new int[]{now[0]/3,now[1]+1});

            }

            if(now[0]%2==0){
                queue.add(new int[]{now[0]/2,now[1]+1});

            }
            queue.add(new int[]{now[0]-1,now[1]+1});
        }
        return -1;
    }
}
