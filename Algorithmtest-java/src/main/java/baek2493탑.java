import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek2493탑 {
    public static void main(String args[]) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[] tower=new int[n];
        int[] answer=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            tower[i]=Integer.parseInt(st.nextToken());

        }
        int solved=n-1;
        int now=n-1;
        Stack<Integer> stack=new Stack<>();
        stack.add(n-1);
        for(int i=n-2;i>=0;i--){

            while(tower[i]>tower[stack.peek()]){
                answer[stack.pop()]=i+1;
                if(stack.isEmpty())break;
            }
            stack.add(i);
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++) {
            sb.append(answer[i]+" ");
        }
        System.out.println(sb.toString());


    }

}

