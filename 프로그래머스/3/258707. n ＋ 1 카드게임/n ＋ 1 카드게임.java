class Solution {
    public int solution(int coin, int[] cards) {
        int answer = 1;
        //카드를 사용할때 코인을 없애기
        
        boolean[] check = new boolean[cards.length];
        
        int free = cards.length/3;
        int canuse =cards.length/3;
        int target = cards.length+1;
        while(coin>=0&&canuse<cards.length-1){
            canuse+=2;
            boolean flag =false;
            for(int left =0 ;left<canuse-1;left++){
                if(check[left])continue;
                
                for(int right = left+1;right<canuse;right++){
                    if(cards[left]+cards[right]==target){
                        int needCoin = needCoinCount(left,right,free);
                        if(coin<needCoin)break;
                        else{
                            coin-=needCoin;
                            check[left]= true;
                            check[right]= true;
                            answer++;
                            flag =true;
                            break;
                        }
                    }
                }
                if(flag){
                    
                    break;
                }
            }
            if(!flag) return answer;
        }
        
        return answer;
    }
    
    static int needCoinCount(int left, int right, int free){
        int count =0;
        if(left>=free)count++;
        if(right>=free)count++;
        
        return count;
    }
}