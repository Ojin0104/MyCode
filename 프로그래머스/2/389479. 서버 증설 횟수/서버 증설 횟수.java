class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        int[] serverNums = new int[24];
        int nowServer = 0;
        for(int idx = 0; idx<players.length ; idx++){
            int needServer = players[idx]/m;
            if(idx>=k)nowServer -=serverNums[idx-k];
            
            if(nowServer>=needServer){
                continue;
            }
            
            serverNums[idx] = needServer-nowServer;
            answer += serverNums[idx];
            nowServer += serverNums[idx];
            
        }
        return answer;
    }
}