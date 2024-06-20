class Solution {
    static int maxDiff = 0;
 
    static int[] answer =new int[11];
    
    //딱한발 더 맞추거나 아예 안맞추거나
    //가장 낮은 점수를 더 많이 맞힌 경우 
    public int[] solution(int n, int[] info) {
        answer[10] = 10;
        int[] lion = new int[11];
        
        dfs(lion,info,0,n);
        if(maxDiff==0){
            return new int[]{-1};
        }
        return answer;
    }
    
    public void dfs(int[] lion,int[] peach,int idx, int arrow){
        
        if(idx>=11){
            int diff = calcScore(lion,peach);
            lion[10]+=arrow;
            if(diff > maxDiff||(diff==maxDiff&&checkCondition(lion))){
                maxDiff = diff;
                changeArr(lion);
            }
            
            return;
        }
        
        //라이언이 이기는 경우
        if(arrow>peach[idx]){
            lion[idx] = peach[idx]+1;
            dfs(lion,peach,idx+1,arrow-lion[idx]);
        }
        
        //초기화
        
        lion[idx] = 0;
        
        //피치가 이기는 경우
        dfs(lion,peach,idx+1,arrow);
    }
    
    void changeArr(int[] lion){
        for(int idx=0;idx<11;idx++){
            answer[idx] = lion[idx];
        }
    }
    
    boolean checkCondition(int[] lion){
        for(int idx=10; idx>=0;idx--){
            if(lion[idx]>answer[idx]){
                return true;
            }else if(lion[idx]<answer[idx]){
                return false;
            }
        }
        
        return false;
        
    }
  
    
    int calcScore(int[] lion,int[] peach){
        int diff = 0;
        for(int idx = 0; idx < 11 ; idx++){
            if(lion[idx]>peach[idx]){
                diff+=(10-idx);
            }else{
                if(peach[idx]!=0)
                    diff+=(idx-10);
            }
        }
        return diff;
    }
}