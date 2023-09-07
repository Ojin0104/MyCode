//2~N까지 수 
class Solution {
    static int[] status;
    static int max=0;
    static int sec=0;
    public int solution(int[] cards) {
        int answer = 0;
        status = new int[cards.length];
        for(int num =0;num<cards.length;num++){
            selectFirst(cards,num,0);
        }
        answer = max;
        return answer;
    }
    
    static void selectFirst(int[] cards,int num,int count){
        if(status[num]==1){
            //두번째 카드 구하기
            
            for(int two=0;two<cards.length;two++){
                if(status[two]==1)continue;
                selectSecond(cards,two,0);
                max= Math.max(count*sec,max);
                
            }
            return;
        }
        status[num]=1;
        
        selectFirst(cards,cards[num]-1,count+1);
        status[num]=0;
    }
    
    static void selectSecond(int[] cards,int num,int count){
        
        if(status[num]!=0){
            sec=count;
            return ;
        }
        
        status[num]=2;
        selectSecond(cards,cards[num]-1,count+1);
        status[num]=0;
        
    }
}