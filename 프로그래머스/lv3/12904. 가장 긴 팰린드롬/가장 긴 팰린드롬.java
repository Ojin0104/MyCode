class Solution
{
    public int solution(String s)
    {
        char[] str=s.toCharArray();
        int max=0;
        for(int i=0;i<s.length();i++){
            int left=i-1;
            int right=i+1;
            int length=1;
            while(left>=0&&right<s.length()){
                if(str[left]==str[right]){
                    length+=2;
                    left-=1;
                    right+=1;
                }
                else break;
            }
            
            max=Math.max(max,length);
            
            
        }
        
        
        for(int i=0;i<s.length()-1;i++){//짝수경우
            int left=i;
            int right=i+1;
            int length=0;
            while(left>=0&&right<s.length()){
                if(str[left]==str[right]){
                    length+=2;
                    left-=1;
                    right+=1;
                }
                else break;
            }
            
            max=Math.max(max,length);
            
            
        }
        

    

        return max;
    }
}