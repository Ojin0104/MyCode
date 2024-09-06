class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        int[] a = new int[n];
        int[] b = new int[n];
        if(tops[0]==1){
            a[0]=3;
            b[0]=1;
        }else{
            a[0]=2;
            b[0]=1;
        }
        for(int idx = 1 ;idx< n ;idx++){
            int top = tops[idx];
            
            if(top ==1){
                a[idx] = (a[idx-1]*3+b[idx-1]*2)%10007;
                b[idx] = (a[idx-1]+b[idx-1])%10007;
            }else{
                a[idx] = (a[idx-1]*2+b[idx-1])%10007;
                b[idx] = (a[idx-1]+b[idx-1])%10007;
            }
        }
        return (a[n-1]+b[n-1])%10007;
    }
}