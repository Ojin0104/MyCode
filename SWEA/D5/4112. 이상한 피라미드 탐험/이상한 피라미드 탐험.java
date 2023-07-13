
import java.util.Scanner;
import java.io.FileInputStream;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuilder sb=new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a=sc.nextInt();
            int b=sc.nextInt();
            
            int[] man=find(a);
            int[] target=find(b);
            int answer=Math.abs(man[0]-target[0]);
            if(answer==0){
                answer=Math.abs(man[1]-target[1]);
            }else{
                
            if(man[0]>target[0]){
                if(man[1]<target[1]){// 인덱스차이 
                	answer+=target[1]-man[1];
                    
                }else{
                	answer+=Math.max(0,man[1]-target[1]-answer);
                }
            }else{
                if(man[1]>target[1]){
                	answer+=man[1]-target[1];
                    
                }else{
                	answer+=Math.max(0,target[1]-man[1]-answer);
                }
            }
            }
            sb.append("#"+test_case+" "+answer+"\n");
		}
        System.out.println(sb);
	}
    static int[] find(int num){
        int n=1;
    	while(num>0){
            if(num<=n){
                int x=n-1;
                int y=num-1;
                return new int[]{x,y};
            }
            num-=n;
            n++;
        }
        return new int[]{0,0};
    }
}