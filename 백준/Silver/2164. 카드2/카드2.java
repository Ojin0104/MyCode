import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Queue를 사용하는 문제
 * @author 한영진
 *
 */
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int N=Integer.parseInt(br.readLine());

        
        Queue<Integer> que=new LinkedList<>();
        for(int i=1;i<=N;i++){
            que.add(i);//큐에 순서대로 값넣어줌
        }

        while(que.size()!=1){//한개 버리고 한개는 밑으로 넣어줌
            que.poll();
            que.add(que.poll());
        }
        System.out.println(que.poll());
    }
	
}
