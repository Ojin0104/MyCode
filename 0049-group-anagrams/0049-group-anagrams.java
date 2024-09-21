import java.util.*;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map =new HashMap<>();
        
        for(String str:strs){
            int[] check  = new int[26];
            StringBuilder sb =new StringBuilder();
            for(int idx = 0; idx<str.length() ; idx++){
                check[str.charAt(idx)-'a']++;
            }

            for(int idx =0; idx<26;idx++){
                if(check[idx]>0){
                    if(check[idx]<10)sb.append("0");
                    sb.append(check[idx]);
                }else{
                    sb.append("00");
                }
            }

            if(map.containsKey(sb.toString())){
                map.get(sb.toString()).add(str);
            }else{
                List<String> arr = new ArrayList<>();
                arr.add(str);

                map.put(sb.toString(),arr);
            }
        }

        List<List<String>> answer = new ArrayList<>();

        for(String key : map.keySet()){
            answer.add(map.get(key));
        }

        return answer;
    }
}