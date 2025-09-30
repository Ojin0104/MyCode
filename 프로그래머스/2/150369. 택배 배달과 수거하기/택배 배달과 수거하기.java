class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int point = n-1;
        int delivery = 0;
        int pick  = 0;
        for(int idx = n-1; idx>=0; idx--){
            delivery += deliveries[idx];
            pick += pickups[idx];
            
            while(delivery>0 || pick>0){
                delivery-=cap;
                pick-=cap;
                
                answer +=(idx+1)*2;
            }
        }
        
        return answer;
    }
}