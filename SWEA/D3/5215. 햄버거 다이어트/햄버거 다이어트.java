
import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T;
		T=Integer.parseInt(br.readLine());
		StringBuilder sb=new StringBuilder();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st=new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            
            ingredient[] ingredients=new ingredient[N];
            for(int i=0;i<N;i++){
            	st=new StringTokenizer(br.readLine());
                int flavor=Integer.parseInt(st.nextToken());
                int calorie=Integer.parseInt(st.nextToken());
                ingredients[i]=new ingredient(flavor,calorie);
            }
            //Arrays.sort(ingredients,(a,b)->a.calorie-b.calorie);
            
            int[] dp=new int[L+1];// i칼로리일때 가장 큰 맛점수 기록
            
            for(int i=0;i<N;i++){
                for(int j=L;j>=ingredients[i].calorie;j--){
                    dp[j]=Math.max(dp[j],dp[j-ingredients[i].calorie]+ingredients[i].flavor);
                }
            }
            sb.append("#"+test_case+" "+dp[L]+"\n");
		}
        System.out.println(sb);
	}
    
     static class ingredient{//맛과 칼로리를 저장하는 class
        int flavor;
        int calorie;
        public ingredient(int flavor,int calorie){
            this.flavor=flavor;
            this.calorie=calorie;
        }
     }
}