class Solution {
    public String convert(String s, int numRows) {
        if(numRows ==1)return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int idx = 0 ; idx<numRows; idx++){
            sb[idx] = new StringBuilder();
        }
        int num = 0;
        boolean flag = true;
        for(int idx =0 ; idx<s.length();idx++){
            sb[num].append(s.charAt(idx)+"");
            if(flag){
                num++;
                if(num>=numRows){
                    num-=2;
                    
                    flag = false;
                }
            }else{
                num--;

                if(num<0){
                    
                    num+=2;
                    flag= true;
                }
            }
        } 

        StringBuilder answer = new StringBuilder();

        for(int idx = 0 ; idx < numRows;idx++){
            answer.append(sb[idx]);
        }

        return answer.toString();
    }
}