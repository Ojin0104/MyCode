import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        //각 구간의 넓이는 낮은 수 + 수의 차이/2 이다
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        arr.add(k);
        while(k>1){
            if(k%2==0){
                k/=2;
            }else{
                k=k*3+1;
            }
            arr.add(k);
        }
        
        double[] avg = new double[arr.size()];
        
        for(int i= 0;i<avg.length-1;i++){
            int small = Math.min(arr.get(i),arr.get(i+1));
            int dif = Math.abs(arr.get(i)-arr.get(i+1));
            
            avg[i] = (double)small + dif/2.0;
            System.out.println(avg[i]);
        }
        
        double[] sum = new double[avg.length];
        
        for(int i = 1 ;i<sum.length;i++){
            sum[i]=sum[i-1]+avg[i-1];
        }
        
        
        
        double[] answer= new double[ranges.length];
        
        for(int i = 0;i<ranges.length;i++){
            int[] range= ranges[i];
            int start = range[0];
            int end = avg.length+range[1]-1;
            
            if(end<start){
                answer[i]=-1;
                continue;
            }
            answer[i]= sum[end]-sum[start];
        }
        return answer;
    }
}