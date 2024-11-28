class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // left와 right 이진법 자릿 수를 left 기준으로 맞춤 
            if(left==right) return left;
        if(left==0)return 0;

        int leftSize = 0;
        int rightSize = 0;
        while((left>>leftSize)>0){
            leftSize++;
        }
            while((right>>rightSize)>0){
                        rightSize++;
                    }
        if(rightSize>leftSize) return 0;

        int answer = 0;
        for(int idx = leftSize-1;idx>=0;idx--){
            if((left>>idx)==(right>>idx))
            {
                answer+= ((left>>idx)&1)<<idx;
            }else{
                break;
            }
        }

        return answer;

        
    }
}