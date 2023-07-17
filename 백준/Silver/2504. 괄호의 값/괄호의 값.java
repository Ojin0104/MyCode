import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str=br.readLine();
		Stack<Character> stack=new Stack<>();
		int mul=1;
		int sum=0;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='(') {
				mul*=2;
				stack.push('(');
			}else if(str.charAt(i)=='[') {
				mul*=3;
				stack.push('[');
			}else if(str.charAt(i)==')') {
				if(stack.isEmpty()||stack.peek()!='(') {
					sum=0;
					break;
				}
				
				if(str.charAt(i-1)=='['||str.charAt(i-1)=='('){
					sum+=mul;
				}
				stack.pop();
				
				mul/=2;
			}else if(str.charAt(i)==']'){
				if(stack.isEmpty()||stack.peek()!='[') {
					sum=0;
					break;
				}
				stack.pop();
				if(str.charAt(i-1)=='['||str.charAt(i-1)=='('){
					sum+=mul;
				}
				
				mul/=3;
				
			}
		}
		if(!stack.isEmpty())System.out.println(0);
        else System.out.println(sum);
	}
}
