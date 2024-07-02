class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int star = 0;
        for(int idx = s.length()-1; idx>=0;idx--){
            if(s.charAt(idx)=='*'){
                star++;
                continue;
            }

            if(star>0){
                star--;
                continue;
            }

            sb.insert(0,s.charAt(idx));

            
        }

        return sb.toString();
    }
}