/*
    백트랙킹 가지치기 !!
    갯수와 비용 을 저장
*/

class Solution {
    int plus = 0;
    int total = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] count = new int[users.length];
        backtracking(users,emoticons,0,count);
        
        int[] answer = {plus,total};
        return answer;
    }
    
    public void backtracking(int[][] users, int[] emoticons, int idx, int[] count){
        if(idx>=emoticons.length){
            int nowPlus = 0;
            int nowTotal= 0;
            for(int userIdx = 0 ;userIdx<users.length; userIdx++){
                int[] user = users[userIdx];
                
                if(user[1]<= count[userIdx]){
                    nowPlus++;
                }else{
                    nowTotal+=count[userIdx];
                }
            }
            
            if(nowPlus>plus){
                plus = nowPlus;
                total = nowTotal;
            }else if(nowPlus == plus){
                total = Math.max(total, nowTotal);
            }
            return;
        }
        
        for(int discount = 10 ; discount<=40; discount+=10){
            int price = emoticons[idx]*(100-discount)/100;
            for(int userIdx = 0 ; userIdx<users.length; userIdx++){
                int[] user = users[userIdx];
                
                if(user[0]<=discount){
                    count[userIdx]+= price;
                }
            }
            
            backtracking(users,emoticons,idx+1,count);
            for(int userIdx = 0 ; userIdx<users.length; userIdx++){
                int[] user = users[userIdx];
                
                if(user[0]<=discount){
                    count[userIdx]-= price;
                }
            }
            
            
            
        }
    }
    
}