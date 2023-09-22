import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bufferedReader.readLine());

        int n=Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        int answer=0;
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            if(stack.isEmpty()){

                st.nextToken();
                int h=Integer.parseInt(st.nextToken());
                if(h!=0)
                    answer+=1;
                stack.add(h);

            }else{
                st.nextToken();
                int h=Integer.parseInt(st.nextToken());
                while(true) {
                    if(stack.isEmpty()){
                        if(h!=0){stack.add(h);
                            answer++;}
                        else{
                            stack.add(0);
                        }
                            
                        break;
                    }
                   if (h > stack.peek()) {//층수 높아지면 건물 추가 후 break;
                        answer++;
                        stack.add(h);
                        break;
                    }else if(h==stack.peek()){//층수 같은 건물 나오면 건물 그대로;
                       break;
                   }else {//층수 낮아지면 일단 pop하고 다음 스택 건물값 확인 
                       stack.pop();
                   }
                }
                
                }
            }
            System.out.println(answer);
        }
    }

