import java.util.*;
class Solution {//26진수
    public String solution(long n, String[] bans) {
        long add = 0;
        Arrays.sort(bans,(s1,s2)->{
            if(s1.length()-s2.length()>0)return 1;
            if(s2.length()-s1.length()>0) return -1;
            
            return s1.compareTo(s2);
        });
        for(String ban : bans){
            if(n>=strToNum(ban)){
                n++;
            }else{
                break;
            }
        }
        
        return numToStr(n);
    }
    
    public String numToStr(long num){
        String answer ="";
        
        while(num>=1){
            
            answer = (char)('a'+ (num-1)%26) + answer;
            num= (num-1)/26;
        }
        return answer;
    }
    
    public long strToNum(String ban){
        long num = 1;
        long answer = 0;
        for(int idx = ban.length()-1 ;idx>=0; idx--){
            answer+=(ban.charAt(idx)-'a'+1)*num;
            num*=26;
        }
        return answer;
    }
}