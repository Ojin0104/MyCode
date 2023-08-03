import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		
		//1.백트랙킹으로 앞에서부터 검증 총 N자리수로
		dfs(0,0);
		
		System.out.println(sb);
	}
	
	static void dfs(int count,int answer) {
		if(count==N) {
			if(isSosu(answer)){
				sb.append(answer+"\n");
				
			}
			return;
		}
		answer*=10;
		for(int add=0;add<10;add++) {
			if(add==0&&count==0) {
				continue;
			}
			if(isSosu(answer+add)) {
				dfs(count+1,answer+add);
			}
			
			
			
		}
	}
	
	static boolean isSosu(int num) {
		if(num==1)return false;
		for(int div=2;div<=Math.sqrt(num);div++) {
			if(num%div==0) {
				return false;
			}
			
		}
		return true;
	}
}
