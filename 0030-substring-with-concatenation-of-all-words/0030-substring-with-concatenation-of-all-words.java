import java.util.*;
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        //words의 단어별로 구분 총 1~ word.length의 경우의 수로 sliding window를 할 수 있음
        int wordLength = words[0].length();
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> counter = new HashMap<>();
       for(String word : words){

            counter.put(word,counter.getOrDefault(word,0)+1);

        }

        int count = counter.keySet().size();

        for(int idx = 0;idx<wordLength;idx++){
            if(idx+wordLength*words.length>s.length())break;
            HashMap<String,Integer> map =new HashMap<>();
            int containNum = 0;

            setMap(map,words);
            for(int point = idx; point <wordLength*words.length; point +=wordLength ){
                String str = s.substring(point,point+wordLength);
                
                if(map.containsKey(str)){
                    map.put(str,map.get(str)+1);
                   if(map.get(str).equals(counter.get(str))){
                        containNum++;
                    }
                }
            }
            if(containNum==count){
                answer.add(idx);
            }

            for(int point = idx; point<=s.length()-wordLength*words.length-wordLength; point+=wordLength){
                //앞에꺼 지우고 뒤에꺼 추가
                String before = s.substring(point,point+wordLength);

                if(map.containsKey(before)){
                    map.put(before,map.get(before)-1);
                    if(map.get(before).equals(counter.get(before)-1)){
                        containNum--;
                    }
                }
                int addIdx = point+wordLength*words.length;
                String next = s.substring(addIdx,addIdx+wordLength);

                if(map.containsKey(next)){
                    map.put(next,map.get(next)+1);
                    if(map.get(next).equals(counter.get(next))){
                        containNum++;
                    }
                }

                if(containNum == count){
                    answer.add(point+wordLength);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }

    void setMap(HashMap<String,Integer> map,String[] words){
        for(String word:words){
            map.put(word,0);
        }
    }
}