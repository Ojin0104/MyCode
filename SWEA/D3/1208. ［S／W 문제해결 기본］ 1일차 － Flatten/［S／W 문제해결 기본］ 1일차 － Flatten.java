
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb=new StringBuilder();
		for(int test_case=1;test_case<=10;test_case++) {
			TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
			sb.append("#"+test_case+" ");
			int dump=Integer.parseInt(br.readLine());
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int times=1;times<=100;times++) {
				int high=Integer.parseInt(st.nextToken());
				map.put(high, map.getOrDefault(high, 0)+1);
			}
			//dump 수만큼 반복
			sb.append(doingDump(map,dump)+"\n");
			
		}
		System.out.println(sb);
	}
	
	static int doingDump(TreeMap<Integer,Integer> map,int dump) {//TreeMap(정렬된 맵을 사용하여) key:높이 value: 해당높이의 가로줄 개수 로 high에서 한개 내리고 low에서 한개올리고 반복!
		
		for(int times=0;times<dump;times++) {//dump진행
			int highKey=map.lastKey();
			int lowKey=map.firstKey();
			
			//highkey 1낮추고
			map.put(highKey,map.get(highKey)-1);
			map.put(highKey-1,map.getOrDefault(highKey-1, 0)+1);
			
			//lowkey 1높이고
			map.put(lowKey+1, map.getOrDefault(lowKey+1, 0)+1);
			map.put(lowKey,map.get(lowKey)-1);
			
			//0되면 지워줌!!
			if(map.get(lowKey)==0)map.remove(lowKey);
			if(map.get(highKey)==0)map.remove(highKey);
		}
		return map.lastKey()-map.firstKey();
	
	}
}