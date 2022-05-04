import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class baek7576토마토 {//��bfsó�� ���� ��ġ �湮�� ó���� 1�� �κ� ť�� �޾� ���� dfs���� dfs���ư�������
static int[] m_x= {0,-1,0,1};
static int[] m_y= {-1,0,1,0};
static int M;
static int N;
static int count;
static int total;
static int max;
static int[][] ground;
static Queue<tomato> que;
public static void main(String args[]) throws IOException {
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=new StringTokenizer(br.readLine());
	M=Integer.parseInt(st.nextToken());
	N=Integer.parseInt(st.nextToken());
	ground=new int[N+2][M+2];
	que=new LinkedList<>();
	for(int i=0;i<M+2;i++) {
		ground[0][i]=-1;
	}
	for(int i=0;i<N+2;i++) {
		ground[i][M+1]=-1;
	}
	for(int i=0;i<N+2;i++) {
		ground[i][0]=-1;
	}
	for(int i=0;i<M+2;i++) {
		ground[N+1][i]=-1;
	}
	for(int i=0;i<N;i++) {
		st=new StringTokenizer(br.readLine());
		for(int j=0;j<M;j++) {
			ground[i+1][j+1]=Integer.parseInt(st.nextToken());
			if(ground[i+1][j+1]==1) {
				que.add(new tomato(i+1,j+1,0));
				count++;
				
			}
			if(ground[i+1][j+1]!=-1)
			total++;
		}
	}

	//System.out.println();
	while(!que.isEmpty()) {
		tomato tom=que.poll();
//		for(int i=0;i<N+2;i++) {
//			System.out.println();
//			for(int j=0;j<M+2;j++) {
//				System.out.print(" "+ground[i][j]);
//			}
//		}
//		
//		System.out.println(tom.time);
		// m_y[0] m_x[1] m_y[2] m_x[3]
		if(ground[tom.x][tom.y+m_y[0]]==0) {
			ground[tom.x][tom.y+m_y[0]]=1;
			que.add(new tomato(tom.x,tom.y+m_y[0],tom.time+1));
			count++;
		}
		if(ground[tom.x+m_x[1]][tom.y]==0) {
			ground[tom.x+m_x[1]][tom.y]=1;
			que.add(new tomato(tom.x+m_x[1],tom.y,tom.time+1));
			count++;
		}
		if(ground[tom.x][tom.y+m_y[2]]==0) {
			ground[tom.x][tom.y+m_y[2]]=1;
			que.add(new tomato(tom.x,tom.y+m_y[2],tom.time+1));
			count++;
		}
		if(ground[tom.x+m_x[3]][tom.y]==0) {
			ground[tom.x+m_x[3]][tom.y]=1;
			que.add(new tomato(tom.x+m_x[3],tom.y,tom.time+1));
			count++;
		}
		max=tom.time;
		//System.out.println(que.size());
	}
	//System.out.println(count);
	if(total!=count) {
		System.out.println(-1);
	}else
		System.out.println(max);
	
	
}
static class tomato{
	int x;
	int y;
	int time;
	
	tomato(int x,int y,int time){
		this.x=x;
		this.y=y;
		this.time=time;
	}
}
}
