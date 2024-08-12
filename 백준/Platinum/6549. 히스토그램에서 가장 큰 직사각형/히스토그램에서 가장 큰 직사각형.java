
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =new StringBuilder();
        while(true){
            StringTokenizer st =new StringTokenizer(br.readLine());
            long max = 0L;
            long N = Long.parseLong(st.nextToken());
            ArrayDeque<Status> stack =new ArrayDeque<>();
            if(N==0){
                break;
            }

            for(long idx = 0 ;idx<N;idx++){
                long now = Long.parseLong(st.nextToken());

                while(!stack.isEmpty()&&stack.peek().height>now){
                    Status out = stack.pop();
                    if(stack.isEmpty()) {
                        max = Math.max(max, idx * out.height);
                    } else {
                        max = Math.max(max, (idx - stack.peek().length - 1) * out.height);
                    }
                }

                stack.push(new Status(now,idx));
            }

            while(!stack.isEmpty()){
                Status out = stack.pop();
                if(stack.isEmpty()) {
                    max = Math.max(max, N * out.height);
                } else {
                    max = Math.max(max,(N - stack.peek().length - 1) * out.height);
                }
            }
            sb.append(max+"\n");

        }

        System.out.println(sb);
    }

    static class Status{
        long height;
        long length;

        public Status(long height, long length){
            this.height = height;
            this.length = length;
        }
    }
}
