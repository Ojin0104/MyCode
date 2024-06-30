class Solution {
    public String reverseWords(String s) {
        
        String[] str = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int idx = str.length-1; idx>=0;idx--){
            if(str[idx].isEmpty())continue;
            
            sb.append(str[idx]+" ");
        }
        
        return sb.substring(0,sb.length()-1).toString();
    }
}