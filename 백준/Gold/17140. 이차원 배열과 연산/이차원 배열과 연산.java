import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int target_r;
	static int target_c;
	static int k;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		target_r=Integer.parseInt(st.nextToken())-1;
		target_c=Integer.parseInt(st.nextToken())-1;
		
		k=Integer.parseInt(st.nextToken());
		int sec=0;
		int[][] map=new int[3][3];
		for(int i=0;i<3;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		if(map.length>target_r&&map[0].length>target_c&&map[target_r][target_c]==k) {
			System.out.println(0);
			return;
		}
		for(int i=0;i<101;i++) {
			sec++;
			map=calcMat(map);
			
			if(map.length<=target_r||map[0].length<=target_c)continue;
			if(map[target_r][target_c]==k)break;
		}
		if(sec>100)sec=-1;
		System.out.println(sec);	
	}
	
	static int[][] calcMat(int[][] map){
		
		ArrayList<Integer>[] arr;
		int max=0;
		int[][] newMap;
		if(map.length>=map[0].length) {
			arr=new ArrayList[map.length];
			
			for(int i=0;i<map.length;i++) {//행별로
				arr[i]=new ArrayList<>();
				HashMap<Integer,Integer> hash=new HashMap<>();
				for(int j=0;j<map[0].length;j++) {
					if(map[i][j]==0)continue;
					hash.put(map[i][j],hash.getOrDefault(map[i][j],0)+1);
				}
				ArrayList<Integer> keySet = new ArrayList<>(hash.keySet());
				
				keySet.sort((a,b)->(hash.get(a)==hash.get(b)?a-b:hash.get(a)-hash.get(b)));
				for(int j=0;j<keySet.size();j++) {
					arr[i].add(keySet.get(j));
					arr[i].add(hash.get(keySet.get(j)));
				}
				max=Math.max(max, arr[i].size());
			}
			newMap=new int[map.length][max];
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].size();j++) {
					newMap[i][j]=arr[i].get(j);
				}
			}
		
		}else {
				arr=new ArrayList[map[0].length];
			
			for(int i=0;i<map[0].length;i++) {//열별로
				arr[i]=new ArrayList<>();
				HashMap<Integer,Integer> hash=new HashMap<>();
				for(int j=0;j<map.length;j++) {
					if(map[j][i]==0)continue;
					hash.put(map[j][i],hash.getOrDefault(map[j][i],0)+1);
				}
				ArrayList<Integer> keySet = new ArrayList<>(hash.keySet());
				
				keySet.sort((a,b)->(hash.get(a)==hash.get(b)?a-b:hash.get(a)-hash.get(b)));
				
				for(int j=0;j<keySet.size();j++) {
					arr[i].add(keySet.get(j));
					arr[i].add(hash.get(keySet.get(j)));
				}
				max=Math.max(max, arr[i].size());
				
			}
			newMap=new int[max][map[0].length];
			
			for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr[i].size();j++) {
					newMap[j][i]=arr[i].get(j);
				}
			}
		}
		return newMap;
	}

}
