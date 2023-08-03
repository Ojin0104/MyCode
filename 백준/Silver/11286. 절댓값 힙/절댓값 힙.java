import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
//람다식쓴케이스
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int times = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Math.abs(a)-Math.abs(b)==0?a-b:Math.abs(a)-Math.abs(b));
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
