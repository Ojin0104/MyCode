class Solution {
    public int[] solution(long begin, long end) {
        int beg=(int)begin;
        int en=(int)end;
        int[] answer = new int[en-beg+1];
        
        for(int i=0;i<en-beg+1;i++){
            if(i+beg==1){
                    answer[i]=0;
                    continue;
                            }
            for(int j=2;j*j<=end;j++){
                
                
                if((i+beg)%j==0){
                    answer[i]=j;
                    if((i+beg)/j<=10000000){
                
                    answer[i]=(i+beg)/j;
                    break;
                }   } 
                if(answer[i]==0)
                answer[i]=1;
            }
            
            
        }
        return answer;
    }
}