import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> remainClass=new PriorityQueue<>(new Comparator<>(){

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        PriorityQueue<Integer>  nowClass=new PriorityQueue<>();

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());

            st.nextToken();
            remainClass.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});

        }
        int max=0;
        while(!remainClass.isEmpty()){
            int[] now=remainClass.poll();


            while(!nowClass.isEmpty()){
                if(nowClass.peek()<=now[0]){
                    nowClass.poll();
                }else{
                    break;
                }
            }
            nowClass.add(now[1]);
            max=Math.max(max,nowClass.size());
        }
        System.out.println(max);
    }
}
