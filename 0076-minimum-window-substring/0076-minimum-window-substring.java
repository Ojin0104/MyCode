class Solution {
    public String minWindow(String s, String t) {
        // 

        if(t.length()>s.length())return "";
        Map<Character, Integer> map = new HashMap<>();
        String answer = "";
        for(int idx =0 ; idx<t.length() ; idx++){
            map.put(t.charAt(idx),map.getOrDefault(t.charAt(idx),0)+1);
        }
        int num = map.keySet().size();
        int count = 0;

        int minLength = s.length()+1;

        int left =0;

        for(int right =0 ;right<s.length(); right++){
            
            Character now = s.charAt(right);
            
            if(map.containsKey(now)){
                if(map.get(now) ==1){
                count++;
            }
            
            map.put(now,map.get(now)-1);
            }
            
            if(count == num && minLength>right-left+1){
                minLength = right-left+1;
                answer = s.substring(left,right+1);
            }
            //left 당기기
            while(count == num){
                Character leftChar = s.charAt(left++);
                if(map.containsKey(leftChar)){
                
                if(map.get(leftChar)==0){
                    count--;
                }
                map.put(leftChar,map.get(leftChar)+1);
                }

                if(count == num && minLength>right-left+1){
                minLength = right-left+1;
                answer = s.substring(left,right+1);
            }
            }
        }
        
        return answer;
    }
}