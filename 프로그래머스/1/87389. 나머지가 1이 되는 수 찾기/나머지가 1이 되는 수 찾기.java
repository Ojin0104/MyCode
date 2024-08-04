class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int div = 2; div<n; div++){
            if(n%div==1)return div;
        }
        return answer;
    }
}