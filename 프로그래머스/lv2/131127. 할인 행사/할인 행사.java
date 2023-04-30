import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int cnt=0;
        for(int i=0;i<want.length;i++) {
            map.put(want[i],number[i]);
            cnt+=number[i];
        }

        for(int i=0;i<=discount.length-cnt;i++) {
            HashMap<String, Integer> temp = new HashMap<>();

            for(String key : map.keySet()) 
                temp.put(key,map.get(key));

            boolean isExist = true;
            //System.out.println("시작점 : " + i + " / 값 : " + discount[i]);
            for(int j=0;j<cnt;j++) {
                int idx = i+j;

                String idxKey = discount[idx];
                if(!temp.containsKey(idxKey)) {
                    isExist = false;
                    break;
                }

                int valueCnt = temp.get(idxKey);
                if(valueCnt-1 < 0) {
                    isExist=false;
                    break;
                }
                temp.put(idxKey,valueCnt-1);
                //System.out.println(idxKey + " / " +temp.get(idxKey));
            }

            if(isExist) {
                for(String key : map.keySet()) {
                    if(temp.get(key) != 0) {
                        isExist = false;
                        break;
                    }
                }
            }

            if(isExist)
                answer++;
        }
        return answer;
    }
}
