import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int Bback=B.length-1;;
        int Bfront=0;
        for(int i=A.length-1;i>=0;i--){
            //A가장높은거
            if(A[i]<B[Bback]){//이긴경후
                answer++;
                Bback--;
            }else{//무조건 지거나 비기는 경우 가장작은 B를 희생
                Bfront++;
                continue;
            }
            
        }
        return answer;
    }
}
//낮은애가 높은애 잡을 수 있게