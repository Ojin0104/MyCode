class Solution {
    public int solution(int[] arr) {
        
        //소수의 곱
        int[] count = new int[101];
        
        for(int num: arr){
            int div =2;
            int times= 0;
            int temp = num;
            while(num>=div){
                if(temp%div==0){
                    temp/=div;
                    times++;
                }else{
                    //System.out.println(times);
                    count[div]= Math.max(count[div],times);
                    times=0;
                    div++;
                }
            }
        }
        int answer = 1;
        for(int num=2;num<101;num++){
            
            answer*= Math.pow(num,count[num]);
            
        }
        
        return answer;
    }
}