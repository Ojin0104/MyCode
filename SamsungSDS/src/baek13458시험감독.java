import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek13458시험감독 {
static int N;
static int[] A;
static int B;
static int C;
public static void main(String args[]) throws NumberFormatException, IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	N=Integer.parseInt(br.readLine());
	A=new int[N];
	StringTokenizer st=new StringTokenizer(br.readLine());
	for(int i=0;i<N;i++) {
		A[i]=Integer.parseInt(st.nextToken());
	}
	st=new StringTokenizer(br.readLine());
	B=Integer.parseInt(st.nextToken());
	C=Integer.parseInt(st.nextToken());
	int num=0;
	int need=0;
	for(int i=0;i<N;i++){
		need=A[i];
		need-=B;
		if(need<=0) {num++;
		continue;
		}
		num++;
		num+=need/C;
		if(need%C!=0)num++;
		
	}
	System.out.println(num);
}
}
