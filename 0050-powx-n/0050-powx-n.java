class Solution {
    public double myPow(double x, int n) {
        double answer = 1.0;
        boolean flag = true;
        long l = n;
        if(l==0)return 1;
        if(l<0){
            flag= false;
            l*=-1;
        }

        while(l>0){
            long num = findMaxTwo(l);
            answer*= calcNum(x,num);
            l-=num;
        }
        if(!flag){
            answer=1/answer;
        }

        return answer;
    }

    static double calcNum(double x, long num){
        
        while(num>1){
            x=x*x;
            num/=2;
        }
        return x;
    }

    static long findMaxTwo(long n){
        long num = 1;

        while(num<=n){
            num*=2;
        }

        return num/2;
    }



}