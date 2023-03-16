import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baek3055 {
    public static void main(String[] args) {
        int[][] gates = {{5, 4, 4, 2}};
        int[] airlines = {8, 5, 2};
        System.out.println(Arrays.toString(solution(gates,airlines)));
    }


    public static int[] solution(int[][] gates, int[] airlines) {
        ArrayList<Integer> answer=new ArrayList<>();
        for(int i=0;i<gates.length;i++){
            //
            int[] gate=gates[i];
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
            for(Integer airline:airlines){
                if(airline!=0)
                    pq.add(airline);
            }
            Arrays.sort(gate);
            for(int j=gate.length-1;j>=0;j--){
                if(pq.isEmpty())
                    break;
                int airplane=pq.poll();
                if(airplane>gate[j]){
                    pq.add(airplane-gate[j]);

                }
            }
            if(pq.isEmpty())
                answer.add(i+1);

        }

        if(answer.size()!=0){
            int[] result=new int[answer.size()];
            for(int i=0;i<answer.size();i++){
                result[i]=answer.get(i);
            }
            return result;
        }
        else
        {
            int[] result=new int[1];
            result[0]=-1;
            return result;
        }


    }

}
