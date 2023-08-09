import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] height;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//stack
		//뒤에서부터 넣고 만약 peek값이 현재 위치보다 작다면 현재위치가 해당 peek탑레이저의 수신위치이다.
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		height = new int[N];
		int[] answer =new int[N];
		StringTokenizer st =new StringTokenizer(br.readLine());
		for(int index = 0; index<N;index++) {
			height[index]= Integer.parseInt(st.nextToken());
		}
		findTower(answer,height);
		StringBuilder sb =new StringBuilder();
		
		for(int index =0;index<answer.length;index++) {
			sb.append(answer[index]+" ");
		}
		System.out.println(sb);
	}
	static void findTower(int[] answer,int[] height) {
		ArrayDeque<Tower> stack = new ArrayDeque<>();
		for(int index = height.length-1;index>=0;index--) {
			while(!stack.isEmpty()) {//스택 빌떄까지반복
				if(stack.peekLast().high<height[index]) {//레이저 수신가능하면 기록해줌
					Tower laser = stack.pollLast();
					answer[laser.index]=index+1;
				}else {//기존탑이 더크다면 레이저 수신못하므로 break;
					break;
				}
			}
			stack.addLast(new Tower(index,height[index]));
		}
	}
	
	static class Tower{
		int index;
		int high;
		public Tower(int index, int high) {
			this.index=index;
			this.high=high;
		}
	}
}
