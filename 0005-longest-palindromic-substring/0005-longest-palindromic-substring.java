class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp =new boolean[s.length()][s.length()];
        for(int idx= 0; idx<s.length();idx++){
            dp[idx][idx] = true;
        }
        int maxstart= 0 ;
        int maxend = 0;

        for(int idx= 0; idx<s.length()-1;idx++){
            if(s.charAt(idx)==s.charAt(idx+1)){
                dp[idx][idx+1] = true;
                maxstart=idx;
                maxend= idx+1;
            }
        }
        for(int size =2; size<s.length();size++){
            
        for(int idx =0; idx<s.length()-size;idx++){
            int start = idx;
            int end = idx+size;
            if(dp[start+1][end-1]&& s.charAt(start)==s.charAt(end))
            {dp[start][end] = true;
                maxstart = start;
                maxend = end;
            }
        }

        }


        return s.substring(maxstart,maxend+1);
        
    }
}