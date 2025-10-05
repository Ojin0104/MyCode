import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String,Integer> userMap = new HashMap<>();
        Map<String,Set<String>> reportMap = new HashMap<>();
        for(int idx = 0; idx<id_list.length; idx++){
            userMap.put(id_list[idx],idx);
        }
        
        for(String rep : report){
            String[] strs = rep.split(" ");
            
            Set<String> reportList = reportMap.getOrDefault(strs[1],new HashSet<String>());
            
            reportList.add(strs[0]);
            reportMap.put(strs[1],reportList);
            
        }
        
        int[] result= new int[id_list.length];
        
        for(int idx = 0 ;idx<id_list.length;idx++){
            if(reportMap.containsKey(id_list[idx])&&reportMap.get(id_list[idx]).size()>=k){
            for(String alert : reportMap.get(id_list[idx])){
                result[userMap.get(alert)]++;
            }
        }
        }
        
        return result;
    }
        
}