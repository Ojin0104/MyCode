class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];

        dp[0]= true; 
        for(int idx =1; idx<s.length()+1; idx++){
            
            for(int wordIdx = 0 ;wordIdx<wordDict.size(); wordIdx++){
                String word = wordDict.get(wordIdx);
                if(dp[idx])break;
                if(idx<word.length())continue;


                if(dp[idx-word.length()] && checkEqual(s,idx, word)){
                    dp[idx] = true;
                }

            }
        }

        return dp[s.length()];
    }

    static boolean checkEqual(String s, int idx, String word){
        for(int num =0 ;num<word.length(); num++){
            if(s.charAt(idx-word.length()+num)!=word.charAt(num))return false;
        }

        return true;
    }
}