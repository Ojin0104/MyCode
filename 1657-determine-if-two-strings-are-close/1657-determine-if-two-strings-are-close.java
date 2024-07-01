class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if(word1.length()!=word2.length())return false;
        int[] count = new int[26];
        boolean[] visit = new boolean[26];
        HashMap<Integer,Integer> map =new HashMap<>();

        for(int idx = 0;idx<word1.length();idx++){
            count[word1.charAt(idx)-'a']++;
            visit[word1.charAt(idx)-'a'] = true;
        }

        for(int idx = 0;idx <26;idx++){
            if(count[idx]!=0){
                map.put(count[idx],map.getOrDefault(count[idx],0)+1);
            }
        }

        count = new int[26];

        for(int idx = 0;idx<word1.length();idx++){
            if(!visit[word2.charAt(idx)-'a'])return false;
            count[word2.charAt(idx)-'a']++;

        }

        for(int idx = 0;idx <26;idx++){
            if(!map.containsKey(count[idx])){
               continue; 
            }

            map.put(count[idx],map.get(count[idx])-1);
            if(map.get(count[idx])==0)map.remove(count[idx]);
        }
        if(map.isEmpty())
            return true;

        return false;
    }
}