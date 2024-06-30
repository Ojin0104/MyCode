class Solution {
    public int maxVowels(String s, int k) {
        HashMap<Character,Boolean> map = new HashMap<>();

        map.put('a',true);
        map.put('e',true);
        map.put('i',true);
        map.put('o',true);
        map.put('u',true);

        int answer = 0 ;
        int count = 0;
        for(int idx = 0 ;idx<k;idx++){
            if(map.containsKey(s.charAt(idx))){
                count++;
            }
        }

        answer = count;

        for(int idx=0; idx<s.length()-k;idx++){
            if(map.containsKey(s.charAt(idx)))count--;
            if(map.containsKey(s.charAt(idx+k)))
            {
                count++;
                answer = Math.max(answer,count);

            }

        }

        return answer;
    }
}