import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        //모두낮은사람 찾기
        //합순으로 배열 (a,b)->a[0]+a[1] -b[0]-b[1]
        int answer = 1;
        int[] wanho={scores[0][0],scores[0][1]};
        Arrays.sort(scores,(a,b)->a[0]==b[0]?a[1]-b[1]:-a[0]+b[0]);
        int MAXscore=0;
        ArrayList<Integer> result=new ArrayList<>();
        for(int[] score:scores){//동료평가 점점 줄어들고 동료평가같다면 태도점수 오름차순으로 -> 전에꺼보다 작은 태도점수를 가진다 -> 동료평가도 낮은점수이다.
           
            
            if(score[1]<MAXscore){//인센탈락
                if(score[0]==wanho[0]&&score[1]==wanho[1])return -1;
            }else{
                MAXscore=Math.max(MAXscore,score[1]);
                if(score[0]+score[1]>wanho[0]+wanho[1]){
                    answer++;
                }
            }
        }
      
        return answer;
    }
}


