import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
//comparator식쓴케이스
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int times = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1,Integer o2) {
				if(Math.abs(o1)==Math.abs(o2)) {
					return o1-o2;
				}else {
					return Math.abs(o1)-Math.abs(o2);
				}
			}
		});
		StringBuilder sb =new StringBuilder();
		
		
		for(int i=0;i<times;i++) {
			int now=Integer.parseInt(br.readLine());
			
			if(now==0) {
				
				if(pq.isEmpty()) {
					sb.append(0+"\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}else {
				pq.add(now);
			}
			
		}
		
		System.out.println(sb);
		
	}
}
