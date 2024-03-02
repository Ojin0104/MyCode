class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int times = 0;
        while(!s.equals("1")){
            times++;
            int zero = 0;
            for(int idx = 0;idx<s.length();idx++){
                if(s.charAt(idx)=='0'){
                    zero++;
                }
            }
            count+=zero;
            s= makeBinary(s.length()-zero);
            
        }
        answer[0]=times;
        answer[1]=count;
        return answer;
    }
    
    public String makeBinary(int num){
        return Integer.toBinaryString(num);
    }
}