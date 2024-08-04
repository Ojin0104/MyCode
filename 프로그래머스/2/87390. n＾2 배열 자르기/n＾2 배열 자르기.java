class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right-left)+1];
        
        for(long num = left; num<=right;num++){
            int row = (int)(num/n);
            int col = (int)(num%n);
            answer[(int)(num-left)] =Math.max(row,col)+1;
        }
        return answer;
    }
}