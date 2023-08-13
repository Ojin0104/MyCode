import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets,(a,b)->(a[0]-b[0]));
        
        int end =targets[0][1];
        
        for(int i=1;i<targets.length;i++){
            int next_start=targets[i][0];
            int next_end= targets[i][1];
            
            if(next_start>=end){//다음시작값이 end보다 크거나 같으면 이전의 미사일들 요격
                answer++;
                end=next_end;
            }else if(next_end<end){//다음end값이 더 작다면 end값 앞으로 떙겨줌(end앞으로 땡겨도 start보다는 크므로 같이 요격가능)
                end=next_end;
            }
        }
       
        if(end!=0){//아직 요격할 미사일이 남아있는 경우
             answer++;
         }
        return answer;
    }
}