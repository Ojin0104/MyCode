import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static char[] chs;
	static HashMap<Character,Boolean> map;
	static StringBuilder sb=new StringBuilder();
	static boolean[] check;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int L=Integer.parseInt(st.nextToken());
		int C=Integer.parseInt(st.nextToken());
		map=new HashMap<>();
		map.put('a',true);
		map.put('e',true);
		map.put('i',true);
		map.put('o',true);
		map.put('u',true);
		
		
		st=new StringTokenizer(br.readLine());
		
		chs=new char[C];
		check=new boolean[C];
		for(int i=0;i<C;i++) {
			chs[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(chs);
		dfs(L,0,0,0);
	
		System.out.println(sb);
	
	}
	static void dfs(int L,int r,int c,int index) {
		
		if(r+c==L&&r>=1&&c>=2) {
			
			for(int i=0;i<chs.length;i++) {
				if(check[i]) {
					sb.append(chs[i]);
				}
			}
			sb.append("\n");
			return;
		}
		if(index>=chs.length)return;
		check[index]=true;
		if(map.containsKey(chs[index])) {
			dfs(L,r+1,c,index+1);
		}else {
			dfs(L,r,c+1,index+1);
		}
		check[index]=false;
		dfs(L,r,c,index+1);
		
	}
}
