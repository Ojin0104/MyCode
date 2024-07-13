class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int[] answer = new int[spells.length];

        for(int idx = 0 ;idx<spells.length; idx++){
            answer[idx]=potions.length-binSearch(spells[idx],success,potions);
        }

        return answer;
    }


    int binSearch(int spell,long num,int[] potions){
        int left = 0;
        int right = potions.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if((long)potions[mid]*spell<num){
                left= mid+1;
            }else{
                right= mid -1;
            }
        }
        return left;
    }
}