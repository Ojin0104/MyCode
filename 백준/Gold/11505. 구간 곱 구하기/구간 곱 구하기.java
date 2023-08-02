import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] tree;
	static int N;
	static int M;
	static int K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N= Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K= Integer.parseInt(st.nextToken());
		
		init(br);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M+K;i++) {
			st=new StringTokenizer(br.readLine());
			if(Integer.parseInt(st.nextToken())==1){
				update(1,1,tree.length/2,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}else {
				sb.append(result(1,1,tree.length/2,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()))+"\n");
			}
		}
		System.out.println(sb);
	}
	static long result(int node,int left, int right, int queryLeft,int queryRight) {
		if(left>queryRight||right<queryLeft)return 1;
		if(left>=queryLeft&&right<=queryRight) {
			return tree[node];
		}
		int mid=(left+right)/2;
		//System.out.println(node);
		return (result(node*2,left,mid,queryLeft,queryRight)*result(node*2+1,mid+1,right,queryLeft,queryRight))%1000000007;
		
	}
	static void update(int node,int left, int right,int target,int change) {
		if(left>target||right<target)return;
		if(left==target&&right==target) {
			tree[node]=change;
			return;
		}
		
		if(target>=left&&target<=right) {
			int mid=(left+right)/2;
			update(node*2,left,mid,target,change);
			update(node*2+1,mid+1,right,target,change);
			tree[node]=(tree[node*2]*tree[node*2+1])%1000000007;
			return;
		}
		
	}
	static void init(BufferedReader br) throws NumberFormatException, IOException {
		int size=1;
		while(size<N) {
			size*=2;
		}
		tree = new long[2*size];
		
		for(int i=0;i<N;i++) {
			tree[size+i]=Integer.parseInt(br.readLine());
		}
		for(int i=size-1;i>=1;i--) {
			tree[i]=(tree[i*2]*tree[i*2+1])%1000000007;
		}
	}
}
