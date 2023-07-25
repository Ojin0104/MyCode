import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		String name=br.readLine();
		int[][] map=new int[name.length()][26];
		int nums=Integer.parseInt(br.readLine());
		
		for(int i=0;i<name.length();i++) {
			map[i][name.charAt(i)-'a']++;
			if(i==0)continue;
			for(int j=0;j<26;j++) {
				map[i][j]+=map[i-1][j];
			}
		}
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<nums;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			char find=st.nextToken().charAt(0);
			
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			int index=find-'a';
			if(start==0)
				sb.append(map[end][index]+"\n");
			else
				sb.append(map[end][index]-map[start-1][index]+"\n");
			
		}
		System.out.println(sb);
	}

}
