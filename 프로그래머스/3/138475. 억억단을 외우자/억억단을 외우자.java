class Solution {
    public int[] solution(int e, int[] starts) {
    //해당 숫자 사이 중 약수가 많은 갯수
    //50000/n. 50000+25000+13333+125000
        
        int[] count = new int[e+1];
        
        countDivisor(count);
        int[] maxList = findMaxNum(count);
        int[] answer = new int[starts.length];
        for(int idx = 0; idx<starts.length; idx++){
            answer[idx] = maxList[starts[idx]];
        }
        return answer;
    }
    
    public int[] findMaxNum(int[] count){
        int[] maxList = new int[count.length];
        
        int max = 0;
        int num = 0;
        for(int idx = count.length-1 ; idx>=0; idx--){
            if(count[idx] >=max){
                max = count[idx];
                num = idx;
            }
            maxList[idx] = num;
        }
        return maxList;
    }
 
    
    public void countDivisor(int[] count){
        for(int idx = 1; idx <count.length; idx++){
            for(int num =0 ; num<count.length; num+=idx){
                count[num]++;
            }
        }
    }
}