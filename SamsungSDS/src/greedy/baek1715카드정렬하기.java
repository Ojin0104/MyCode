package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class baek1715카드정렬하기 {
	
	static int N;
	static PriorityQueue<Long> pq=new PriorityQueue<>();
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
	
		for(int i=0;i<N;i++) {
			pq.add(Long.parseLong(br.readLine()));
		}
		
		long sum=0;
		long count=0;
		if(pq.size()==1) {
			count=pq.poll();
		}
		while(pq.size()>=2) {
			sum=pq.poll()+pq.poll();
			count+=sum;
			pq.add(sum);
			//System.out.println(sum);
			//
		}
		
		System.out.println(count);
	}

}
