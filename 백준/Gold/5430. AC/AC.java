import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder answer=new StringBuilder();
        for(int i=0;i<T;i++){
            String command=br.readLine();
            int N=Integer.parseInt(br.readLine());
            String num=br.readLine();
            StringBuilder sb=new StringBuilder();

            num=num.substring(1,num.length()-1);
            String[] nums=num.split(",");
            Deque<Integer> deque=new ArrayDeque<>();
            for(int j=0;j<N;j++){
                deque.add(Integer.parseInt(nums[j]));
            }
            boolean flag=false;
            boolean end=false;
            for(int j=0;j<command.length();j++){
                if(command.charAt(j)=='R'){
                    flag=!flag;
                }else{
                    if(deque.isEmpty()){
                        answer.append("error\n");
                        end=true;
                        break;
                    }
                    if(flag){
                        deque.pollLast();
                    }else{
                        deque.pollFirst();
                    }
                }
            }
            if(end)continue;
            sb.append("[");
            while(!deque.isEmpty()){
                if(flag){
                    sb.append(deque.pollLast());
                }else{
                    sb.append(deque.pollFirst());
                }
                if(!deque.isEmpty()){
                    sb.append(",");
                }
            }


            sb.append("]\n");
            answer.append(sb);
        }
        System.out.println(answer);
    }
}
