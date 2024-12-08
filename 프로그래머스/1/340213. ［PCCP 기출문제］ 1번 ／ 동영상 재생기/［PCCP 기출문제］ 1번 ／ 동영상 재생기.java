class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = pos;
        
        for(String command: commands){
            //오프닝 구간 체크
            if(isOpening(answer,op_start,op_end))
                answer = op_end;
            
            //커맨드 실행
            if(command.equals("prev")){
                answer = movePlayer(answer,-10,video_len);
            }
            
            if(command.equals("next")){
                answer = movePlayer(answer,10,video_len);
            }
            
            
            
        }
        
        //오프닝 구간 체크
        if(isOpening(answer,op_start,op_end))
                answer = op_end;
        
        return answer;
    }
    
    String movePlayer(String now,int val,String video_len){
        String[] nowStr = now.split(":");
        
        int nowMin = Integer.parseInt(nowStr[0]);
        int nowSec = Integer.parseInt(nowStr[1]);
        
        nowSec += val;
        
        if(nowSec>=60){
            nowMin++;
            nowSec-=60;
        }
        
        if(nowSec<0){
            nowMin--;
            nowSec+=60;
        }
        
        if(nowMin<0){
            nowMin = 0;
            nowSec = 0;
        }
        
        
        
        String resultTime = String.format("%02d", nowMin)+":"+String.format("%02d", nowSec);
       
        if(compareTime(resultTime,video_len)){
            resultTime = video_len;
        }
        
        return resultTime;
    }
    
    boolean isOpening(String pos,String op_start,String op_end){
        if(compareTime(pos,op_start) && compareTime(op_end,pos))return true;
        
        return false;
        
    }
    
    boolean compareTime(String now, String comp){
        String[] nowStr = now.split(":");
        String[] compStr = comp.split(":");
        int nowMin = Integer.parseInt(nowStr[0]);
        int compMin = Integer.parseInt(compStr[0]);
        
        if(nowMin > compMin){
            return true;
        }else if(nowMin < compMin){
            return false;
        }
        
        int nowSec = Integer.parseInt(nowStr[1]);
        int compSec = Integer.parseInt(compStr[1]);
        
        if(nowSec >= compSec){
            return true;
        }else{
            return false;
        }
    }
    
    
}