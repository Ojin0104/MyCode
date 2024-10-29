class Solution {
    public int trailingZeroes(int n) {
        int five = 0;
        while(n>0){
            five+=n/5;
            n/=5;
        }

        return five;

    }

    
}