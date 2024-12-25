import java.util.*;
class Solution {
    public int solution(int[] a) {
        //1. n 과 n+1은 항상 다른 수여야함 (n은 짝수)
        //2. 배열마다 같은 숫자가 있어야함
        // 0~9 까지 하나씩골라 최대 길이 찾기
        HashMap<Integer, Integer> times = new HashMap<>();
        for(int idx = 0; idx<a.length ; idx++){
            //HashMap으로 가장 빈도 높은 수 우선으로 검색
            times.put(a[idx],times.getOrDefault(a[idx],0)+1);
        }
        
         // HashMap의 엔트리를 List로 변환
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(times.entrySet());

        // 값(value)을 기준으로 내림차순 정렬
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        
        int max = 0;
        for(Map.Entry<Integer, Integer> e : entryList){
            int num = e.getKey();
            if(max>=e.getValue()*2)break;
            
            ArrayList<Integer> arr = new ArrayList<>();
            
            for(int idx = 0;idx<a.length ; idx++){
                
                if(arr.size()%2==0){
                    arr.add(a[idx]);
                }else{
                    int head = arr.get(arr.size()-1);
                    if(head==num){
                        if(a[idx]!=head)
                            arr.add(a[idx]);
                    }else{
                        if(a[idx]==num){
                            arr.add(a[idx]);
                        }
                    }
                }
                
                if(arr.size()%2==0){
                    max = Math.max(max,arr.size());
                }
            }
        }
        return max;
    }
}