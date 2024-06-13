import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 1;
    
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        while(n>1){
            if(n%2==0){
                n/=2;
            }else{
                n--;
                ans++;
            }
        }

        return ans;
    }
}