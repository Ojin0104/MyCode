import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        int Bback=B.length-1;;
        
        for(int i=A.length-1;i>=0;i--){
            //A가장높은거
            if(A[i]<B[Bback]){//이긴경후
                answer++;
                Bback--;
            }
            
        }
        return answer;
    }
}
//낮은애가 높은애 잡을 수 있게