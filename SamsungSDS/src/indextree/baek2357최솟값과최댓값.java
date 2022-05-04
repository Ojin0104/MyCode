package indextree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek2357최솟값과최댓값 {
static int N;
static int M;
static int S;
static Long[] mintree;
static Long[] maxtree;
public static void main(String args[]) throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st=new StringTokenizer(br.readLine());
	N=Integer.parseInt(st.nextToken());
	M=Integer.parseInt(st.nextToken());
	 S=1;
	while(S<N) {
		S*=2;
	}
	mintree=new Long[2*S];
	maxtree=new Long[2*S];
	long n=0;
	for(int i=S;i<S+N;i++) {
		n=Long.parseLong(br.readLine());
		mintree[i]=n;
		maxtree[i]=n;
	}
	for(int i=S+N;i<2*S;i++) {
		mintree[i]=(long) 1100000000;
		maxtree[i]=(long)0;
	}
	for(int i=S-1;i>0;i--) {
		
		mintree[i]=Math.min(mintree[2*i], mintree[2*i+1]);
		maxtree[i]=Math.max(maxtree[2*i], maxtree[2*i+1]);
	}
	int a;
	int b;
	StringBuilder sb=new StringBuilder();
	for(int i=0;i<M;i++) {
		st=new StringTokenizer(br.readLine());
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		sb.append(minquery(1,S,a,b,1)+" "+maxquery(1,S,a,b,1)+"\n");
	
	}
	bw.write(String.valueOf(sb));
	bw.flush();
	bw.close();
}
static long minquery(int left,int right,int a,int b,int node) {
	if(left>=a&&right<=b)return mintree[node];
	int mid=(left+right)/2;
	
	if(a>mid) {
		return minquery(mid+1,right,a,b,node*2+1);
	}else if(b<=mid){
		return minquery(left,mid,a,b,node*2);
	}else {// a,b�� �����ִ°��
		long first=minquery(left,mid,a,mid,node*2);
		long second=minquery(mid+1,right,mid+1,b,node*2+1);
		return Math.min(first, second);
	}
	
	
}
static long maxquery(int left,int right,int a,int b,int node) {
	if(left>=a&&right<=b)return maxtree[node];
	int mid=(left+right)/2;
	
	if(a>mid) {
		return maxquery(mid+1,right,a,b,node*2+1);
	}else if(b<=mid){
		return maxquery(left,mid,a,b,node*2);
	}else {// a,b�� �����ִ°��
		long first=maxquery(left,mid,a,mid,node*2);
		long second=maxquery(mid+1,right,mid+1,b,node*2+1);
		return Math.max(first, second);
	}
	
	
}
}
