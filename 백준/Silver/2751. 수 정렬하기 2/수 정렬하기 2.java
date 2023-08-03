import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] src;
	static int[] tmp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		tmp = new int[N];
		src = new int [N];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			src[i]=Integer.parseInt(br.readLine());
		}
		mergeSort(0,N-1);
		for(int i=0;i<N;i++) {
			sb.append(src[i]+"\n");
		}
		System.out.println(sb);
	}
	
	static void mergeSort(int start, int end) {
		if(start<end) {//start와 end가 같아질떄 까지 split해줌
			int mid = (start +end)/2;
			mergeSort(start,mid);
			mergeSort(mid+1,end);
			
			int p = start;
			int q = mid+1;
			int idx= p;
			
			while(p<=mid ||q<=end) {//p는 시작점부터 미드까지 q는 미드 부터 끝점까지 하라도 끝점 도달안했다면 실행
				if(q>end||(p<=mid&& src[p]<src[q])) {
					tmp[idx++] = src[p++];
				}else {
					tmp[idx++] = src[q++];
				}
				
			}
			
			for(int i=start;i<=end;i++) {
				src[i]=tmp[i];
			}
			
		}
	}
}
