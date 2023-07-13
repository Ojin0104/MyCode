import java.util.*;
import java.io.*;


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
			int N= Integer.parseInt(br.readLine());
            int[] nums= new int[N];
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++){
            	nums[i]=Integer.parseInt(st.nextToken());
            }
            ArrayList<Integer> arr= new ArrayList<>();
            for(int i=0;i<N;i++){
            	if(arr.size()==0){
                	arr.add(nums[i]);
                    
                }else{
                   	int index=binSearch(arr,nums[i]);
                    //System.out.println(index);
                    if(index>=arr.size()){
                    	arr.add(nums[i]);
                    }else{
                           arr.set(index,nums[i]);
                    }
                }
            }
            int max=arr.size();
            sb.append("#"+test_case+" "+max+"\n");
		}
        System.out.println(sb);
	}
    static int binSearch(ArrayList<Integer> LIS,int num){
    	int left=0;
        int right=LIS.size()-1;
       // for(int i=0;i<LIS.size();i++){
       // 	System.out.println(LIS.get(i));
       // }
        while(left<=right){
        	int mid=(left+right)/2;
            if(LIS.get(mid)>=num){
            	right=mid-1;
            }else{
                left=mid+1;
            }
        }
        
        //System.out.println(num+"'s left is "+left);
        return left;
    }
}