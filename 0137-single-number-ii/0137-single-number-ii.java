class Solution {
    public int singleNumber(int[] nums) {
       Map<Integer,Integer> map = new HashMap<>();


        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Integer idx: map.keySet()){
            if(map.get(idx)==1)return idx;
        }
        

        return -1;
    }
}