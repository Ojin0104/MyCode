import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 
 * @author SSAFY
 *	1.위상정렬 사용하여 각 학생의 뒤와 부모노드들의 사이즈를 저장한다. (사이즈가 0인노드들은 큐에저장)
 *  2.사이즈가 0인 노드를 출력하면서 뒤노드들의 부모 사이즈를 -1해준다.
 *  3.만약 사이즈가 0이 된다면 큐에 넣어 저장한다.
 *  
 */
public class Main {
	static int[] taller;//자기보다 앞에서는 무조건 앞에서야하는 사람수 저장
	static ArrayList<Integer>[] myBack;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		taller = new int[N+1];
		myBack = new ArrayList[N+1];
		for(int index=1;index<=N;index++) {
			myBack[index]=new ArrayList<Integer>();
		}
		
		for(int times=1;times<=M;times++) {
			st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			taller[back]++;
			myBack[front].add(back);
		}
		
		topologicalSort();
		
		System.out.println(sb);
	}
	
	static void topologicalSort() {
		ArrayDeque que=new ArrayDeque<Integer>();
	
		//0인 노드들 큐에 넣어줌
		for(int index=1;index<taller.length;index++) {
			if(taller[index]==0) {
				que.addLast(index);
			}
		}
		
		while(!que.isEmpty()) {
			int now = (int) que.pollFirst();
			
			sb.append(now+" ");
			
			for(Integer next: myBack[now]) {
				taller[next]--;
				if(taller[next]==0) {
					que.addLast(next);
				}
			}
		}
	}
}
