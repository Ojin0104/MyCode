class Solution {
    public int minFlips(int a, int b, int c) {
        int num = a|b;
        int answer = 0;
        while(a>=1||b>=1||c>=1){
            if(c%2!=num%2){
                answer+= count(a,b,c);
            }

            a/=2;
            b/=2;
            num/=2;
            c/=2;
        }

        return answer;
    }

    int count(int a,int b , int c){
        int num = 0;
        if(c%2==0){
            if(a%2!=0)num++;
            if(b%2!=0)num++;
        }else{
            num++;
        }

        return num;
    }
}