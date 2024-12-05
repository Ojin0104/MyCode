class Solution {
    static int a =0 ;
    static int b=  0;
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        if(s1.length()+s2.length()!=s3.length())return false;
        dp[0][0] = true;
        for(int left =0 ;left<=s1.length(); left++){
            for(int right = 0; right<=s2.length(); right++){
                if(right>=1 &&dp[left][right-1] && s3.charAt(left+right-1)== s2.charAt(right-1)){
                    dp[left][right] = dp[left][right] || true;
                }

                if(left>=1&&dp[left-1][right] && s3.charAt(left+right-1)== s1.charAt(left-1)){
                    dp[left][right] = dp[left][right] ||true;
                }
            }
        }

        
        return dp[s1.length()][s2.length()];
    }

}