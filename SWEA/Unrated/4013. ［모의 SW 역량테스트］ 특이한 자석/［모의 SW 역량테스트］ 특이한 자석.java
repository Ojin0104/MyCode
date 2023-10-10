import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 * 1.톱니를 회전시킬때의 양쪽 톱니의 접접에 따라 회전방향이 결정 된다.
 * 2.톱니 클래스를 생성하고 char[8]크기의 자성배열과 왼쪽 오른쪽 pointer를 저장한다.(초기에는 2와 6)
 * 3.각 톱니를 4개 배열로 만들어 초기화 한다.
 * 4.톱니를 하나 돌릴때마다 해당톱니의 양쪽 방향으로 탐색하여 회전여부를 결정하는 메소드를 실행시킨다. 
 * 5.그후 재귀문 돌아오면서 톱니를 회전시킨다(회전시킬떄 포인터만 이동 시계방향으로 회전이라면 포인터는 -1을 해줘야한다.
 * 6.4,5를 반복하여 최종 톱니 상태를 확인한다.(왼쪽 포인터 +2칸)
 *
 */
public class Solution {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	int T = Integer.parseInt(br.readLine());
	StringBuilder sb =new StringBuilder();
	
	for(int test_case=1;test_case<=T;test_case++) {
		int K = Integer.parseInt(br.readLine());//회전 횟수
		
		Topni[] topnis = new Topni[4];
		
		for(int idx=0;idx<4;idx++) {//톱니들 초기화
			topnis[idx]= new Topni(br.readLine());
		}
		
		for(int times =0; times<K;times++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int magNum = Integer.parseInt(st.nextToken())-1;
			int dir = Integer.parseInt(st.nextToken());
			turnTopni(topnis,magNum,dir,0);
			
		}
		int sum = 0;
		for(int idx = 0 ;idx<4;idx++) {
			if(topnis[idx].getRed()==1) {
				sum+=1<<idx;
			}
		}
		
		sb.append("#"+test_case+" "+sum+"\n");
		
	}
	
	System.out.println(sb);
	
}
	static void turnTopni(Topni[] topnis,int magNum,int dir, int next) {
		if(magNum<0||magNum>3) {
			return;
		}
		
		if(next==0) {//양쪽으로 topni 확인
			turnTopni(topnis,magNum-1,dir,-1);//왼쪽
			turnTopni(topnis,magNum+1,dir,+1);//오른쪽
		}else {
			//회전 할때애 더 나아감
			if(next==1) {//왼쪽에서 왔을시 현재 magNum의 왼쪽 포인터와 이전 magNum의 오른쪽 포인터를 비교한다.
				if(topnis[magNum].getLeft()!=topnis[magNum-1].getRight()) {//서로 다를때 반대방향 회전
					turnTopni(topnis,magNum+1,dir*-1,next);
					topnis[magNum].turn(dir*-1);
				}
			}else {
				if(topnis[magNum+1].getLeft()!=topnis[magNum].getRight()) {//서로 다를때 반대방향; 회전
					turnTopni(topnis,magNum-1,dir*-1,next);
					topnis[magNum].turn(dir*-1);
				}
			}
		}
		if(next==0)	{
			topnis[magNum].turn(dir);
		}
	}





static class Topni{
	int[] mag = new int[8];
	int left;
	int right;
	public Topni(String magLine) {
		this.left= 6;
		this.right =2;
		StringTokenizer st =new StringTokenizer(magLine);
		
		for(int idx=0;idx<8;idx++) {
			mag[idx] = Integer.parseInt(st.nextToken());
		}
	}
	public int getRed() {//빨간 화살표가 가리키는 곳
		return this.mag[(left+2)%8];
	}
	public int getLeft() {
		return this.mag[left];
	}
	
	public int getRight() {
		return this.mag[right];
	}
	
	public void turn(int dir) {//dir 1일시 시계방향회전
		
		right=(right-dir+8)%8;
		left=(left-dir+8)%8;
	}
}
}
