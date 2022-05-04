import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek15684사다리조작 {
static int N;
static int M;
static int H;
static int[][] bridge;
static int[] num;
public static void main(String args[]) throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	N=Integer.parseInt(st.nextToken());
	M=Integer.parseInt(st.nextToken());
	H=Integer.parseInt(st.nextToken());
	//M�� 0�̸� 0���
	bridge=new int[H+1][N+1];//���� ������ġ 1�̸� ���ʿ��� ������ 2�̸� �����ʿ�������
	num=new int[N+1];
	int s;
	int e;
	for(int i=0;i<M;i++) {//���ٿ� 2���� ������ ���� ���ӵ� ���μ��� ä������ �� �ִ� ���μ��� �ִ��� �Ǵ��ϸ��
		st=new StringTokenizer(br.readLine());
		s=Integer.parseInt(st.nextToken());
		e=Integer.parseInt(st.nextToken());
		bridge[s][e]=1;
		num[e]++;
		
	}
	int r=0;
	//1���� N���� num��� ¦�� �Ǿ����
	for(int i=1;i<=N;i++) {
		r+=num[i]%2;
	}
	 if(r>3) {
		System.out.println(-1);
	}else if(dfs(1,r)) {
		System.out.println(r);
	}else {
		System.out.println(-1);
	}
}
static boolean dfs(int n,int r) {
	if(n>N)return false;
	if(r==0)return true;
	if(num[n]%2==0) {
		return dfs(n+1,r);
	}
	for(int i=1;i<N+1;i++) {
		if(check(i,n)) {//��ٸ� ���ų� �ȳ��ų� ����Ǽ����
			bridge[i][n]=1;
			if(dfs(n+1,r-1))return true;
			bridge[i][n]=0;
			if(dfs(n+1,r))return true;
		}
	}
	return false;
}
static boolean check(int n,int s) {
	if(bridge[n][s-1]==0&&bridge[n][s+1]==0&&bridge[n][s]==0)return true;
	else return false;
}
}
