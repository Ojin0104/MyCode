import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] tree;
	static int N;
	static int S=1;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		StringBuilder sb=new StringBuilder();
		init(br);
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int queryLeft=Integer.parseInt(st.nextToken());
			int queryRight=Integer.parseInt(st.nextToken());
			sb.append(find(1,1,tree.length/2,queryLeft,queryRight)+"\n");
		}
		System.out.println(sb);
	}
	
	static int find(int node,int left,int right,int queryLeft,int queryRight) {
		if(queryLeft>right||queryRight<left) return Integer.MAX_VALUE;
		if(queryLeft<=left&&queryRight>=right) {
			return tree[node];
		}
		int mid=(left+right)/2;
		int a=find(node*2,left,mid,queryLeft,queryRight);
		int b=find(node*2+1,mid+1,right,queryLeft,queryRight);
		
		return Math.min(a, b);
	}
	static void init(BufferedReader br) throws NumberFormatException, IOException {

		while(S<N) {
			S*=2;
		}
		
		tree=new int[2*S];
		
		for(int i=0;i<N;i++) {
			tree[i+S]=Integer.parseInt(br.readLine());
			
		}
		
		for(int i=S-1;i>=1;i--) {
			tree[i]=Math.min(tree[2*i],tree[2*i+1]);
		}
	}

}
