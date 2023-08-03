import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int Q;
	static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		StringBuilder sb=new StringBuilder();
		N=Integer.parseInt(st.nextToken());
		Q=Integer.parseInt(st.nextToken());
		
		init(br);
		
		for(int i=0;i<Q;i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y= Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(x>y) {
				int temp=x;
				x=y;
				y=temp;
			}
			
			sb.append(sum(1,1,tree.length/2,x,y)+"\n");
			update(1,1,tree.length/2,a,b);
		}
		System.out.println(sb);
	}
	static void update(int node,int left,int right,int target,int change) {
		
		if(left==target&&right==target) {
			tree[node]=change;
			return;
		}
		
		if(left>target||right<target) {
			return;
		}
		int mid=(left+right)/2;
		update(node*2,left,mid,target,change);
		update(node*2+1,mid+1,right,target,change);
		tree[node]=tree[node*2]+tree[node*2+1];
	}
	static long sum(int node,int left,int right,int queryLeft,int queryRight) {
		
		if(left>=queryLeft&&right<=queryRight) {
			//모두 포함
			return tree[node];
		}
		
		
		if(queryRight<left||queryLeft>right) {//범위벗어난경우
			return 0;
		}
		
		int mid=(left+right)/2;
		return sum(node*2,left,mid,queryLeft,queryRight)+sum(node*2+1,mid+1,right,queryLeft,queryRight);
	}
	public static void init(BufferedReader br) throws IOException {
		int size =1;
		while(size<N) {
			size*=2;
		}
		
		tree=new long[2*size];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			tree[i+size]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=size-1;i>=1;i--) {
			tree[i]=tree[i*2]+tree[i*2+1];
		}
		
	}
}
