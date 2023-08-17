import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 
 * @author 영진
 *그냥구현한다..
 */
public class Solution {
	static char[][] map;
	static char[] moveCommand= {'U','D','L','R'};
	static char[] dirTank= {'^','v','<','>'};
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[] tank=new int[2];
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =new StringBuilder();
		
		for(int test_case=1;test_case<=T;test_case++) {
		
		
			StringTokenizer st =new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			for(int row=0;row<H;row++) {
				String line = br.readLine();
				for (int col = 0;col<W;col++) {
					map[row][col]=line.charAt(col);
					if(map[row][col]=='^'||map[row][col]=='v'||map[row][col]=='>'||map[row][col]=='<') {
						//전차위치 저장
						tank[0]=row;
						tank[1]=col;
					}
				}
			}
			
			int length = Integer.parseInt(br.readLine());
			String commands = br.readLine();
			
			for(int index=0;index<length;index++) {
				playCommand(commands.charAt(index));
			}
			
			sb.append("#"+test_case+" ");
			for(int row=0;row<H;row++) {
				sb.append(new String(map[row])+"\n");
			
			}
			
		}
		System.out.println(sb);
		
	}
	
	static void playCommand(char command) {
		for(int dir=0;dir<4;dir++) {
			if(moveCommand[dir]==command) {
				int next_r=tank[0]+dr[dir];
				int next_c=tank[1]+dc[dir];
				if(next_r<0||next_c<0||next_r>=map.length||next_c>=map[0].length) {
					//범위벗어나는경우
					map[tank[0]][tank[1]]=dirTank[dir];//방향은 지정해줘야함
					return;
				}
				if(map[next_r][next_c]=='.') {//탱크옮겨줌
					map[tank[0]][tank[1]]='.';
					tank[0]=next_r;
					tank[1]=next_c;
					map[next_r][next_c]=dirTank[dir];
				}else {
					map[tank[0]][tank[1]]=dirTank[dir];
				}
				
				
				return;//못옮겨줬더라도 return;
			}
		}
		
		//포탄발사의경우
		//바라보는 방향의 벽이나 강철의 위치를 찾는다.
		int dist=1;
		int dir = findIndex(map[tank[0]][tank[1]]);
		while(true) {
			
			int next_r=tank[0]+dist*dr[dir];
			int next_c = tank[1]+dist*dc[dir];
			if(next_r<0||next_c<0||next_r>=map.length||next_c>=map[0].length)break;

			if(map[next_r][next_c]=='*') {//벽돌인경우
				map[next_r][next_c]='.';
				break;
			}
			
			if(map[next_r][next_c]=='#') {//강철인경우
				break;
			}
			dist++;
			
		}
		
		
		
	}
	
	static int findIndex(char direction) {
		for(int index=0;index<4;index++) {
			if(direction==dirTank[index]) {
				return index;
			}
		}
		return 0;
	}
	
	
}
