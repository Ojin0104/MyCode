/*
    백트랙킹 가지치기 !!
    갯수와 비용 을 저장
*/

class Solution {
    static int count = 0;
    static int money = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] status = new int[users.length];
        dfs(users,emoticons,0, status);
        answer[0]=count;
        answer[1]=money;
            
        return answer;
    }
    
    static void dfs(int[][] users, int[] emoticons, int index,int[] status){
        if(index>=emoticons.length){
            //이모티콘 서비스 가입하는지 확인 
            int now_count=0;
            int now_money=0;
            for(int num = 0;num<users.length;num++){
               // System.out.println(status[0]+" "+status[1]);
                if(status[num]>=users[num][1])
                    now_count++;
                else{
                    now_money+=status[num];
                }
            }
            
            if(now_count>count){
                count=now_count;
                money=now_money;
            }else if(now_count==count){
                money=Math.max(money,now_money);
            }
            return;
            
        }
        
        for(int rate=10;rate<=40;rate+=10){
            int price= emoticons[index]*(100-rate)/100;
            for(int num = 0;num<users.length;num++){
                if(users[num][0]<=rate){
                    status[num]+=price;
                }
            }
            
            dfs(users,emoticons,index+1,status);
            
            for(int num = 0;num<users.length;num++){
                if(users[num][0]<=rate)
                    status[num]-=price;
            }
            
            
            
        }
        
        
    }
}