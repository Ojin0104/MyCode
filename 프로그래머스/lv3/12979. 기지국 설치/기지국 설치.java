class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int can=2*w+1;
        
        
        if(stations[0]-w-1>=1){//필요
            answer+=(stations[0]-w-1)/can+1;
        }
        
        for(int i=0;i<stations.length-1;i++){
            int start=stations[i]+w;
            int end=stations[i+1]-w;
            if(start+1<end){
                answer+=(end-start-2)/can+1;
            }
        }
        
        if(stations[stations.length-1]+w<n){
            answer+=(n-stations[stations.length-1]-w-1)/can+1;
        }
        return answer;
    }
}