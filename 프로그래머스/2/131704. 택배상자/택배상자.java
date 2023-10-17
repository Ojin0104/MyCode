import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        //첫 order에 도착할때 까지 stack(보조 컨테이너) 에 담아줌
        for(int num=1;num<order[0];num++){
            stack.push(num);
        }
        
        answer=1;
        int index=1;
        int num = order[0]+1;
        //stack의 윗부분이면 poll후 +1 stack의 윗부분 아니면 order+1해줌
        while(index<order.length){
            if(!stack.isEmpty()&&index<order.length&&stack.peek()==order[index]){
                answer++;
                index++;
                stack.pop();
            }else if(order[index]==num){
                answer++;
                index++;
                num++;
            }else if(order[index]>num){
                for(int i=num;i<order[index];i++){
                 stack.push(i);
                }
                num=order[index];
            }else{//셋다안되는 경우
                break;
            }
            
        }
        
        return answer;
    }
}