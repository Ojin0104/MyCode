class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer =1;
        while(true){
            //둘이 붙어있으면서 큰값이 짝수여야함
            
            if(Math.abs(a-b)==1&& Math.max(a,b)%2==0){
                return answer;
            }
            a=(a+1)/2;
            b=(b+1)/2;
            
            answer++;
        }
        
    }
}