import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        //현재범위 우선순위큐와 아직 범위전 배열을 둠
        
        Arrays.sort(targets,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }else{
                return a[0]-b[0];
            }
            });
        
        int end =0;
        
        for(int i=0;i<targets.length;i++){
            int next_start=targets[i][0];
            int next_end= targets[i][1];
            if(end==0){
                end = next_end;
                continue;
            }
            
            if(next_start>=end){
                answer++;
                end=next_end;

            }else if(next_end<end){
                end=next_end;
            }
            
            
        }
       
        
        if(end!=0){//아직 요격할 미사일이 남아있는 경우
            answer++;
        }
        return answer;
    }
}