import java.util.*;
import java.lang.Math;
class Solution {
    

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int idx = 0 ;idx<numbers.length; idx++){
         // 2진수를 생성
        long number = numbers[idx];
        String binNum = makeBinNum(number);
        // 오른쪽 에서 두번쨰자릿수가 서브트리의 루트가 되므로, 무조건 1이여야함 , 이게 반복되어야함
        if(isTree(binNum,0,binNum.length()-1)){
            answer[idx] = 1;
        }
            
            
            
        }
        
        return answer;
        }
    
    public boolean isTree(String str,int left, int right){
        if(left>=right)return true;
        int mid = (left+right)/2;
        if(str.charAt(mid)=='0'){
            
            for(int idx = left; idx<=right; idx++){
                if(str.charAt(idx)=='1')return false;
            }
            
        }
        
        return isTree(str,left,mid-1) && isTree(str,mid+1,right);
    }
    
    
    public String makeBinNum(long number){
        StringBuilder sb = new StringBuilder();
        while(number>0){
            sb.append(number%2);
            number/=2;
        }
        
        int len = sb.length();
        
        int count = 0;
    
        while(len>0){
            count++;
            len/=2;
        }
        len = sb.length();
        count = (int)Math.pow(2,count)-1;
        for(int idx = 0; idx<count-len;idx++){
            sb.append("0");
        }        
        return sb.reverse().toString();
            
    }
}