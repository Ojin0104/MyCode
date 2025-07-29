class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] arr = new int[n];
        answer = dfs(arr,0);
        return answer;
    }
    
    
    public int dfs(int[] arr, int num){
        
       if(num>=arr.length)return 1;
        int answer= 0;
        for(int idx = 0 ;idx<arr.length; idx++){
            if(checkPossible(arr,num,idx)){
                arr[num] = idx;
                answer +=dfs(arr,num+1);
                arr[num] = 0;
            }
        }
        return answer;
               
    }
    
    
    public boolean checkPossible(int[] arr, int row, int col){
        
        for(int idx =0 ; idx<row; idx++){
            if(arr[idx] == col || Math.abs(idx-row)  ==Math.abs(col-arr[idx]))return false;
        }
        
        return true;
    }
}