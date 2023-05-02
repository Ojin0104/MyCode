import java.util.*;
class Solution {
    static HashMap<Integer,Boolean> map;
    public int solution(int[] a) {
        //딱한번만 번호작은 풍선가능 -> 보통은 큰 풍선터뜨려야함
       
        //i 앞뒤로 최대값 비교 가운대값 i 가 가장작은 경우 양쪽 가능 나머지 세개다 가능 map에 비교
        map=new HashMap<>();

        int[] front=new int[a.length];
        int[] back=new int[a.length];
        front[0]=a[0];
        back[a.length-1]=a[a.length-1];
        for(int i=1;i<a.length;i++){
            front[i]=Math.min(front[i-1],a[i-1]);
        }
        for(int i=a.length-2;i>=0;i--){
            back[i]=Math.min(back[i+1],a[i+1]);
        }
        for(int i=1;i<a.length-1;i++){
           
            if(!(a[i]>front[i]&&a[i]>back[i])){
                map.put(a[i],true);
            }
                map.put(front[i],true);
                map.put(back[i],true);
        }
        
        
        int answer = map.size();
        return answer;
    }
}