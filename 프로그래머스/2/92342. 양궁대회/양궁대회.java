import java.util.*;
class Solution {
    static int max = 1; 
    static int[] ans = new int[11];
    public int[] solution(int n, int[] info) {
        //화살 0 or 어피치 보다 1 많게
        //남은 화살은 마지막에
        int[] answer = new int[11];
        
        dfs(answer,info , n,0);
        if(Arrays.stream(ans).sum()==0) return new int[]{-1};
        return ans;
    }
    
    void dfs(int[] answer, int[] info, int n, int point){
        if(point ==11){
            answer[10]+=n;
            
            int sum = countPoint(answer,info);
            
            if(sum>max || (sum==max&& checkCondition(answer))){
                max = sum;
                for(int idx=0;idx<11;idx++){
                    ans[idx] = answer[idx];
                }
            }
            return;
        }
        
        if(info[point]<n){
            answer[point] = info[point]+1;
            dfs(answer,info,n-answer[point],point+1);
        }
        
        answer[point] = 0;
        dfs(answer,info,n,point+1);
    }
    
    public int countPoint(int[] arr1, int[] arr2){
        int sum = 0 ;
        for(int idx =0 ; idx<arr1.length; idx++){
            if(arr1[idx]>arr2[idx]){
                sum+=10-idx;
            }else{
                if(arr2[idx]!=0)
                    sum-=10-idx;
            }
        }
        
        return sum;
    }
    
    boolean checkCondition(int[] lion){
        for(int idx=10; idx>=0;idx--){
            if(lion[idx]>ans[idx]){
                return true;
            }else if(lion[idx]<ans[idx]){
                return false;
            }
        }

        return false;

    }
    
   
}