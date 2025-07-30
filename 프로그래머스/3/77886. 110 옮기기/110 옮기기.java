class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int idx = 0; idx<s.length ;idx++){
            answer[idx] = changeStr(s[idx]);
        }
        return answer;
        
    }
    
    public String changeStr(String str){
        //111 앞으로만 변경 가능
        StringBuilder sb = new StringBuilder();
        int count = 0;
            
        for(int idx = 0 ; idx< str.length(); idx++){
            sb.append(str.charAt(idx));
            int len = sb.length();
            
            if(len>=3 && sb.charAt(len-3) == '1' && sb.charAt(len-2) == '1' && sb.charAt(len-1) == '0'){
                count++;
                sb.setLength(len-3);
            }
        }
        int addIdx = sb.lastIndexOf("0");
        sb.insert(addIdx + 1, "110".repeat(count));
            
        return sb.toString();
        
    }
}