import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int color=0;
	public static void main(String[] args) throws Exception {
		//////////////////////////////////////////////////////////////
		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
		//////////////////////////////////////////////////////////////
		//System.setIn(new FileInputStream("Test5.txt"));
		int[][] map=new int[19][19];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int row=0;row<19;row++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			for(int col=0;col<19;col++) {
				map[row][col]=Integer.parseInt(st.nextToken());
				
			}
		}
	
		int[] answer=findOmok(map);
		if(color==0) {
			System.out.println(0);
		}else {
			System.out.println(color);
			System.out.println(answer[0]+" "+answer[1]);
		}
		
	}
	/**
	 * 가장 왼쪽의 바둑알 가로줄 및 세로줄 번호를 구해주는 메소드
	 * 왼쪽알을 구하면 되므로 0,0부터 행방향으로 탐색을 진행한다.
	 * 동시에 이기거나 두군데 이상에서 이기는 경우없으므로
	 * 오목으로 확인된 순간 해당위치를 반환한다.
	 * @param map
	 * @return
	 */
	static int[] findOmok(int[][] map) {
		int[] answer=new int[2];
		for(int col=0;col<map[0].length;col++) {
			for(int row=0;row<map.length;row++) {
				
				if(isOmok(row,col,map)) {
					answer[0]=row+1;
					answer[1]=col+1;
					return answer;
				}
			}
		}
		return answer;
	}
	
	/**
	 * 오목인지 확인하는 메소드
	 * 오른쪽 대각위 방향, 오른쪽방향, 오른쪽 대각아래 방향,아래 탐색
	 * 6개가 되지는 않는지 체크
	 * @param row
	 * @param col
	 * @param map
	 * @return
	 */
	static boolean isOmok(int row,int col,int[][] map) {
		int[] dr= {-1,0,1,1};
		int[] dc= {1,1,1,0};
		int now=map[row][col];
		if(now==0)return false;
		if(now!=1&&now!=2)return false;
	
		for(int type=0;type<4;type++) {
			
			int next_r=row;
			int next_c=col;
			int count=1;
			for(int times=1;times<=4;times++) {
				next_r+=dr[type];
				next_c+=dc[type];
				//배열범위 넘어가는지 확인
				if(next_r<0||next_r>=19||next_c>=19||next_c<0)break;
				
				//색깔이 달라지면 오목아니므로 false
				if(map[next_r][next_c]!=now)break;
				
				count++;
			}
			if(count==5) {
				//6개는 아닌지 확인 
				//뒤
				next_r+=dr[type];
				next_c+=dc[type];
				if(isSame(next_r,next_c,map,now)){
					continue;
				}
				
				next_r=row-dr[type];
				next_c=col-dc[type];
				//앞
				if(isSame(next_r,next_c,map,now)){
					continue;
				}
				color=now;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 6개가 되는지 확인해주는 메소드
	 * 5개된 오목에서 양옆이 같인지 now로 확인해준다.
	 * @param row
	 * @param col
	 * @param map
	 * @param now
	 * @return
	 */
	static boolean isSame(int row,int col,int[][] map,int now) {
		if(!(row<0||row>=19||col>=19||col<0)) {
			if(now==map[row][col]) {
				return true;
			}
		}
		return false;
	}
}

