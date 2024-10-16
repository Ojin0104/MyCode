import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Boolean> checkNum = new HashMap<>();

        int len = 0 ;
        int left = 0;
        int max = 0;
        for(int idx = 0 ; idx< s.length(); idx++){
            char ch = s.charAt(idx);
            if(checkNum.containsKey(ch)){
                while(left<=idx&&s.charAt(left)!=ch){
                    checkNum.remove(s.charAt(left));
                    left++;
                    len--;
                }
                if(s.charAt(left)==ch){
                    left++;
                }
            }else{
                checkNum.put(ch,true);
                len++;
                max = Math.max(max,len);
            }
        }
        return max;
    }
}