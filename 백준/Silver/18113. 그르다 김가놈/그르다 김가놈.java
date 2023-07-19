import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		long[] gimbab=new long[N];
		long len=0;
		for(int i=0;i<N;i++) {
			gimbab[i]=Long.parseLong(br.readLine());
			len+=gimbab[i];
			if(gimbab[i]>=2*K) {
				gimbab[i]-=2*K;
			}else if(gimbab[i]>K) {
				gimbab[i]-=K;
			}else {
				gimbab[i]=0;
			}
		}
		
		//N개 나눌수 잇는 최대 김밥 크기
		long answer=binary(gimbab,M,K,len);
		if(answer==0)answer=-1;
		System.out.println(answer);
	}
	
	static long binary(long[] gimbab,int M,int K,long len) {
		long left=1;
		long right=len-1;
		long answer=-1;
		//count는 M개중 가장 오른쪽
		while(left<=right) {
			long mid=(left+right)/2;//김밥길이 P
			
			long count=findCount(gimbab,mid,K);
			
			if(count>=M) {
				answer=Math.max(mid, answer);
				left=mid+1;
			}else {
				right=mid-1;
			}
			
		}
		return answer;
	}
	
	static long findCount(long[] gimbab,long size, int K) {
		long answer=0;
		for(Long len:gimbab) {
			
			answer+=len/size;
		}
		
		return answer;
	}
}
