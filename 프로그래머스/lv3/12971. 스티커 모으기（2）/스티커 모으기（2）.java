class Solution {
    public int solution(int sticker[]) {//첫번쨰 뜯는경우 vs 안뜯는 경우 dp 로 계산
        
        int answer = 0;
        int[][] dp=new int[2][sticker.length];
        if(sticker.length==1)return sticker[0];
        
        dp[0][0]=sticker[0];
        dp[0][1]=sticker[0];
        dp[1][1]=sticker[1];
        
        
        for(int i=2;i<sticker.length;i++){
            if(i!=sticker.length-1){
            dp[0][i]=Math.max(dp[0][i-1],dp[0][i-2]+sticker[i]);
            }else{
                dp[0][i]=dp[0][i-1];
            }
            dp[1][i]=Math.max(dp[1][i-1],dp[1][i-2]+sticker[i]);
            
        }
        answer=Math.max(dp[0][sticker.length-1],dp[1][sticker.length-1]);
       
        return answer;
    }
}