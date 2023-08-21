import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진 
 * 1.큐에 각초마다 세가지경우를 넣어준다. 
 * 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int subin = Integer.parseInt(st.nextToken());
		int sister = Integer.parseInt(st.nextToken());
        if(sister<subin){
            System.out.println(subin-sister);
        }else{
		int answer = bfs(subin, sister);

		System.out.println(answer);
        }
    }

	static int bfs(int subin, int sister) {
		ArrayDeque<Status> que = new ArrayDeque<>();
		que.add(new Status(0, subin));
		boolean[] check = new boolean[sister*2+1];
		while (!que.isEmpty()) {//큐는 앞에 넣은 값부터 검증하므로 position == sister가 되는순간이 가장 빠른시간이다.
			Status now = que.pollFirst();
			check[now.position]=true;
			if (now.position == sister) {//찾자마자 return
				return now.time;
			}
			
			
			if(now.position<=sister&&!check[now.position*2]) {
				check[now.position*2]=true;
				que.add(new Status(now.time + 1, now.position * 2));
			}
			if(now.position<sister*2-1&&!check[now.position+1]) {
				check[now.position+1]=true;
				que.add(new Status(now.time + 1, now.position + 1));
			}
			
			if (now.position > 1&&!check[now.position-1]) {//0보다 작아질경우 xx}
				check[now.position-1]=true;
				que.add(new Status(now.time + 1, now.position - 1));
				
		
			}
		}

		return 0;
	}

	static class Status {
		int time;
		int position;

		public Status(int time, int position) {
			this.time = time;
			this.position = position;
		}
	}
}
