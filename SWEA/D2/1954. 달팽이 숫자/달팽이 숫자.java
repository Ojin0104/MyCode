
import java.util.*;
import java.io.*;


class Solution
{
	static int[] dr= {0,1,0,-1}; //오른,아래,왼쪽,위 순서로 세팅
	static int[] dc= {1,0,-1,0};
	static int size;
	static StringBuilder sb=new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int total=Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=total;test_case++) {
			sb.append("#"+test_case+"\n");
			size=Integer.parseInt(br.readLine());
			int[][] map=new int[size][size];
			makeSnail(map);
		}
		System.out.println(sb);
	}
	
	//시작 방향을두고 숫자가 있거나 범위가 넘어가면 방향전환해줌
	static void makeSnail(int[][] map) {
		int dir=0;
		int now_r=0;
		int now_c=0;
		
		int times=0;//NxN번 채워지면 순환종료
		while(times<size*size) {
			times++;
			map[now_r][now_c]=times;
			
			int next_r=now_r+dr[dir];
			int next_c=now_c+dc[dir];
			
			//범위를 벗어나거나 이미 숫자가 있다면 방향전환을 해줌
			if(next_r<0||next_c<0||next_r>=size||next_c>=size||map[next_r][next_c]!=0) {
				dir=(dir+1)%4;
				next_r=now_r+dr[dir];
				next_c=now_c+dc[dir];
			}
			
			now_r=next_r;
			now_c=next_c;
		}
		
		for(int row=0;row<size;row++) {
			for(int col=0;col<size;col++) {
				sb.append(map[row][col]+" ");
			}
			sb.append("\n");
		}
	}
}