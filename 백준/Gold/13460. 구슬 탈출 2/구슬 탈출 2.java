import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {//R과B는 행렬에 표시하지않고 그냥 position만 기록해두면서 q돌리면 해결될듯
//4방향으로 이동하는 경우
	static char[][] maps;
	static int N;
	static int M;
	static position Blue;
	static position Red;
	static Queue<quenum> que=new LinkedList<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		maps=new char[N][M];
		
		for(int i=0;i<N;i++) {
			String str=br.readLine();
			for(int j=0;j<M;j++) {
				char c=str.charAt(j);
				if(c=='#')
				maps[i][j]='#';
				else if(c=='O')maps[i][j]='O';
				else maps[i][j]='.';
				if(c=='B')Blue=new position(i,j,'B');
				else if(c=='R')Red=new position(i,j,'R');
			//	System.out.print(maps[i][j]);
					
				}
				
			}
		int num=0;
	
		que.add(new quenum(0,Blue.x,Blue.y,Red.x,Red.y,0));
		boolean result=false;
		while(!que.isEmpty()) {
			
			quenum q=que.poll();
			//System.out.println();
			if(q.times>=10)break;
			
			position B=new position(q.bx,q.by,'B');
			position R=new position(q.rx,q.ry,'R');
			if(q.num!=1) {//왼쪽
				position NB;
				position NR;
						
				if(q.by<q.ry) {
				 NB=left(B,R);
				 NR=left(R,NB);
				
				}else {
					
					NR=left(R,B);
					 NB=left(B,NR);
				}
				
					
				if((NB.x!=0||NB.y!=0)&&(NR.x==0&&NR.y==0)) {result=true;
				num=q.times;
				break;
				}
				if(!(NB.x==0&&NB.y==0))
				que.add(new quenum(1,NB.x,NB.y,NR.x,NR.y,q.times+1));
			}
			//System.out.println(111);
			if(q.num!=2) {//아래
				position NB;
				position NR;
						
				if(q.bx>q.rx) {
				 NB=down(B,R);
				 NR=down(R,NB);
				}else {
					
					NR=down(R,B);
					 NB=down(B,NR);
				}
//				
				if((NB.x!=0||NB.y!=0)&&(NR.x==0&&NR.y==0)) {result=true;
				num=q.times;
				break;
				}
				if(!(NB.x==0&&NB.y==0))
				que.add(new quenum(2,NB.x,NB.y,NR.x,NR.y,q.times+1));
			}
			
			if(q.num!=3) {//right
				position NB;
				position NR;
						
				if(q.by>q.ry) {
				 NB=right(B,R);
				 NR=right(R,NB);
				
				}else {
					
					NR=right(R,B);
					 NB=right(B,NR);
				}
				 
			
				if((NB.x!=0||NB.y!=0)&&(NR.x==0&&NR.y==0)) {result=true;
				num=q.times;
				
				break;
				
				}
				if(!(NB.x==0&&NB.y==0))
				que.add(new quenum(3,NB.x,NB.y,NR.x,NR.y,q.times+1));
			}
			if(q.num!=4) {//위
				position NB;
				position NR;
						
				if(q.bx<q.rx) {
				 NB=up(B,R);
				 NR=up(R,NB);
				}else {
					
					NR=up(R,B);
					 NB=up(B,NR);
				}
//				
					
				if((NB.x!=0||NB.y!=0)&&(NR.x==0&&NR.y==0)) {result=true;
				num=q.times;
				break;
				}
				if(!(NB.x==0&&NB.y==0))
				que.add(new quenum(4,NB.x,NB.y,NR.x,NR.y,q.times+1));
			}
		
		}
		if(result) {
			System.out.println(num+1);
		}else {
			System.out.println(-1);
		}
	}
	static position up(position A,position B){
			int i=0;
			int x=A.x;
			int y=A.y;
			position K=new position(A.x,A.y,A.color);
			while(true) {//파란구슬
				i++;
				if(maps[A.x-i][A.y]=='#') {
					break;
				}else if((A.x-i)==B.x&&A.y==B.y) {break;
				}else if(maps[A.x-i][A.y]=='O') {
				
				   K.x=0;
				    K.y=0;
					break;
				}else {
					K.x-=1;
				}
			
		}
			return K;
	}
	static position down(position A,position B){
		int i=0;
		int x=A.x;
		int y=A.y;
		position K=new position(A.x,A.y,A.color);
		while(true) {//파란구슬
			i++;
			if(maps[A.x+i][A.y]=='#') {
				break;
			}else if((A.x+i)==B.x&&A.y==B.y) {
				break;
			}else if(maps[A.x+i][A.y]=='O') {
			   K.x=0;
			    K.y=0;
				break;
			}else {
				K.x+=1;
			}
		
	}
		return K;
}
	static position left(position A,position B){
		int i=0;
		position K=new position(A.x,A.y,A.color);
		while(true) {//파란구슬
			i++;
			
			if(maps[A.x][A.y-i]=='#') {
				break;
			}else if((A.x)==B.x&&(A.y-i)==B.y) {break;
			}else if(maps[A.x][A.y-i]=='O') {
			   K.x=0;
			    K.y=0;
				break;
			}else {
				K.y-=1;
			}
		
	}
		return K;
}
	
	static position right(position A,position B){
		int i=0;
		position K=new position(A.x,A.y,A.color);
		while(true) {//파란구슬
			i++;
			
			if(maps[A.x][A.y+i]=='#') {
				break;
			}else if((A.x)==B.x&&(A.y+i)==B.y) {break;
			}else if(maps[A.x][A.y+i]=='O') {
			   K.x=0;
			    K.y=0;
				break;
			}else {
				K.y+=1;
			}
		
	}
		return K;
}
	static class position{
		int x;
		int y;
		char color;
		position(int x,int y,char color){
			this.x=x;
			this.y=y;
			this.color=color;
		}
	}
	static class quenum{
		
		int num;
		int bx;
		int by;
		int rx;
		int ry;
		int times;
		quenum(int num,int bx,int by,int rx, int ry,int times){
		
			this.num=num;
			this.rx=rx;
			this.ry=ry;
			this.by=by;
			this.bx=bx;
			this.times=times;
					
		}
	}
	}

