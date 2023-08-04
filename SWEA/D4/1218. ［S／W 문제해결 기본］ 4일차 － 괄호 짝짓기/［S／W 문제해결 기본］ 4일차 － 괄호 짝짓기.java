import java.util.*;
import java.io.*;

/**
 * 닫는 괄호를 hashMap의 key로 저장하고 value를 여는 괄호로 둔다.
 * 닫는괄호가 나왔을때 스택에서 pop한 문자가 value와 같으면 맞는괄호이다.
 * @author 한영진
 *
 */
class Solution
{
	static HashMap<Character,Character> map = new HashMap<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map.put(')','('); //O아니면 스택 pop값 확인
		map.put('>','<');
		map.put('}','{');
		map.put(']','[');
		map.put('(', 'O'); //O로 넣으면 stack에 push
		map.put('<', 'O');
		map.put('{', 'O');
		map.put('[', 'O');
		StringBuilder sb =new StringBuilder();
		for(int test_case=1;test_case<=10;test_case++) {
			
			int size = Integer.parseInt(br.readLine());
			int answer =0;
			Stack stack = new Stack(size);
			String str=br.readLine();
			answer = isRight(stack,str);
			
			
			sb.append("#"+test_case+" "+answer+"\n");
		}
		System.out.println(sb);
	}
	static int isRight(Stack stack,String str) {
		for(int index = 0 ;index<stack.totalSize();index++) {
			char now = str.charAt(index);
			if(map.get(now)=='O') {//열린괄호이다
				stack.push(now);
			}else {//닫힌괄호이면
				if(stack.peek()!=map.get(now)) {//짝이안맞는괄호
					return 0;
				}else {
					stack.pop();
				}
			}
			
		}
		return 1;
	}

	//스택구현
	static class Stack{
		char[] stack;
		int size;
		int index;
		
		public Stack(int size) {
			this.size=size;
			this.stack = new char[size];
			this.index=0;
		}
		
		/**
		 * 스택 크기 두배로 늘려주는 메소드
		 * 현재 크기의 두배의 배열 생성후
		 * 옮겨준다.
		 */
		public void doubledSize() {
			this.size*=2;
			char[] nextStack= new char[this.size];
			for(int index =0;index<this.size/2;index++) {
				nextStack[index] = this.stack[index];
			}
			this.stack = nextStack;
		}
		
		/**
		 * 스택에 값을 넣을때 사이즈를 초과 한다면 경고문을 출력한다.
		 * 그렇지 않다면 값을 넣어주고 index를 +해준다.
		 * @param ch
		 */
		public void push(char ch) {
			if(this.index>=this.size) {
				doubledSize();//스택을 두배로 늘려줌
			}
			this.stack[this.index++]=ch;
		}
		
		public char peek() {
			if(isEmpty()) {
				System.out.println("빈 스택입니다.");
				return ' ';
			} 
			return this.stack[this.index-1];
		}
		
		public char pop() {
			if(isEmpty()) {
				System.out.println("빈 스택입니다.");
				return ' ';
			} 
			return this.stack[(this.index--)-1];
		}
		
		/**
		 * index를 통해 스택이 비어있는지 확인한다.
		 * @return
		 */
		public boolean isEmpty() {
			if(this.index==0) {
				return true;
			}
			return false;
		}
		
		public int size() {
			return this.index;
		}
		
		public int totalSize() {
			return this.size;
		}
	}
}