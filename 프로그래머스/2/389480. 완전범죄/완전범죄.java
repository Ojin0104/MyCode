import java.util.*;
class Solution {
    public int solution(int[][] info, int n, int m) {
        int answer = 0;
        //A에 대한 흔적 개수가 더 큰 것 먼저 m으로 처리
        
        Arrays.sort(info,(o1,o2)-> -(o1[0]-o1[1]) + (o2[0]-o2[1]));
        int A = 0;
        int B = 0;
        for(int[] inf : info){
           // System.out.println(inf[0]+" "+inf[1]);
            if(inf[1]+B <m){
                B +=inf[1];
            }else if(A+inf[0] <n){
                A+=inf[0];
            }else{
            return -1;
        }
        }
        
        return A;
    }
}