
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int answer=0;
	static int[] dr= {-1,0,0};
	static int[] dc= {0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int[][] ladder = new int[100][100];
		StringBuilder sb=new StringBuilder();
		//input을 받으며 2의위치(도착점)을 기억해줌
		for(int test_case=1;test_case<=10;test_case++) {
			br.readLine();
			int[] start=new int[2];
			for(int row=0;row<100;row++) {
				StringTokenizer st=new StringTokenizer(br.readLine());
				for(int col=0;col<100;col++) {
					ladder[row][col]=Integer.parseInt(st.nextToken());
					if(ladder[row][col]==2) {
						start[0]=row;
						start[1]=col;
					}
				}
			}
			move(ladder,start[0],start[1],0);
			//도착점에서 올라가면서 r이 0이 될때를 찾아줌
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.println(sb);
		
	}
	
	//위로올라가다가 왼쪽or오른쪽 이있을때 오른쪽으로 이동해주고 현재 이동방향을 기록한다.
	//0 위  1 왼 2 오  
	//0인 상태의 경우 왼,오 가 나오면 그쪽으로 방향바꿈
	//1,2인 상태의 경우 위가 나오면 위로 방향바꿈
	//row가 0이 될때 col값을 return;
	static void move(int[][] ladder,int r,int c,int dir) {
        if(r==0) {
            answer=c;
            return;
        }
        for(int direction=0;direction<=2;direction++) {
            if(dir!=0&&direction!=0&&direction!=dir)continue;//위로가고 있지않을때 다시 돌아가기 방지
            if(dir==0&&direction==0)continue; //둘다 0이면 왼쪽오른쪽먼저 살펴야함
             
            int next_r=r+dr[direction];
            int next_c=c+dc[direction];
             
            if(next_r<0||next_c<0||next_r>=100||next_c>=100)//범위 확인
                continue;
             
            if(ladder[next_r][next_c]==1) {
                move(ladder,next_r,next_c,direction);
                return;//한번가면 끝
            }
        }
        move(ladder,r-1,c,dir);//왼쪽오른쪽 길없을때 위로가기
    }
	
}