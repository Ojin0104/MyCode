import java.util.*;
class Solution {
    public String solution(String p) {
        if(p.equals(""))return "";
        
        StringBuilder sb = new StringBuilder();
        dfs(sb,p);
        
        return sb.toString();
    }
    
    static void dfs(StringBuilder sb ,String p){
        if(p.length()==0)return;
        int idx = findBalancing(p);
        String u = p.substring(0,idx);
        if(findGood(u)){
            sb.append(u);
            String v = p.substring(idx,p.length());
            dfs(sb,v);
        }else{
            sb.append("(");
               String v = p.substring(idx,p.length());
               dfs(sb,v);
            sb.append(")");
            appendStr(sb,u);
        }
        
    }
    
    static void appendStr(StringBuilder sb, String u){
        for(int idx = 1;idx<u.length()-1;idx++){
            if(u.charAt(idx)==')')sb.append("(");
            else sb.append(")");
        }
    }
    
    static boolean findGood(String p){
        ArrayDeque<Character> stack = new ArrayDeque();
        for(int idx= 0 ; idx<p.length();idx++){
            if(p.charAt(idx)=='(')stack.push('(');
            
            if(p.charAt(idx)==')'){
                if(stack.size()==0)return false;
                
                stack.pop();
            }
        }
        
        if(stack.size()==0)return true;
        
        return false;
    }
    
    static int findBalancing(String p ){
        int left = 0;
        int right = 0;
        int idx = 0;
        while(left!=right||left==0){
            
            if(p.charAt(idx)=='(')left++;
            if(p.charAt(idx)==')')right++;
            
            idx++;
        }
        
        return idx;
    }
}