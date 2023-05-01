class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        //A 모든 수의 최대 공약수 이자 B 모든 수의 약수가아니여야함  
        int answer = 0;
        answer=calc(arrayA,arrayB);
        return answer;
    }
    static int calc(int[] A,int[] B){
        int a=A[0];
        for(int i=1;i<A.length;i++){
            a=gcd(a,A[i]);
        }
        
        int b=B[0];
        
        for(int i=1;i<B.length;i++){
            b=gcd(b,B[i]);
        }
        
        for(int i=0;i<B.length;i++){
            if(B[i]%a==0){
                a=0;
                break;
                         }
        }
        
        for(int i=0;i<B.length;i++){
            if(A[i]%b==0){
                b=0;
                break;
                         }
        }
        
        return a>b?a:b;
    }
    
    static int gcd(int a ,int b){
        while(b!=0){
            int r=a%b;
            a=b;
            b=r;
        }
        return a;
    }
}