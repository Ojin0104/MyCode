import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int L;
	static int R;
	static int X;
	static int answer=0;
	static int[] A; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		
		st=new StringTokenizer(br.readLine());
		A=new int[N];
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		
		dfs(0,0,Integer.MIN_VALUE,Integer.MAX_VALUE,true);
			
			
		System.out.println(answer);
		
	
		
		
	}
	static void dfs(int now,long sum,int max,int min,boolean check) {
		if(check&&max!=min&&max-min>=X&&sum>=L&&sum<=R) {
			answer++;//조건
			
		}
		
		if(now>=N)return;
		if(sum>R)return;
		
		dfs(now+1,sum,max,min,false);
		max=Math.max(max, A[now]);
		min=Math.min(min, A[now]);
		dfs(now+1,sum+A[now],max,min,true);
	}
}

