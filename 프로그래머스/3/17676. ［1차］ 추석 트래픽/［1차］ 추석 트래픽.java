import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        
        Time[] intLines = new Time[lines.length];
        
        for(int idx =0 ;idx<lines.length; idx++){
            String[] line = lines[idx].split(" ");
            
            
            Integer endTime = convertToInt(line[1]);
            
            Integer leadTime = makeMiliSec(line[2]);
            
            Integer startTime = endTime - leadTime +1;
            
            intLines[idx] = new Time(startTime,endTime);
            
        }
        
        Arrays.sort(intLines,(o1,o2) -> o1.endTime -o2.endTime);
        for(int idx = 0; idx<intLines.length; idx++){
            int count = 0;
            int start = intLines[idx].endTime;
            int end = intLines[idx].endTime+1000;
            for(int i=0; i<intLines.length;i++){
                Time next = intLines[i];
                if(next.startTime<end && next.endTime>=start){
                    count++;
                }
            }
            
            answer = Math.max(answer,count);
        }
        
        return answer;
    }
    
    public int convertToInt(String timeStamp){
        
        String[] times = timeStamp.split(":");
        
        Integer hour = Integer.parseInt(times[0]) * 60 * 60 * 1000;
        Integer minute = Integer.parseInt(times[1]) * 60 * 1000;
        Integer miliSec = makeMiliSec(times[2]);
        
        return hour + minute + miliSec;
        
    }
    
    public int makeMiliSec(String second){
        
        second = second.replace("s","");
        String[] times = second.split("\\.");
        
        
       
        int sec = 0;
        
        
        if(times.length>=2){
            
            sec+= Integer.parseInt(times[0])*1000;
            sec+= Integer.parseInt(String.format("%-3s", times[1]).replace(' ', '0'));
        }else{
           sec+= Integer.parseInt(second)*1000;
        }
       // System.out.println(sec);
        
        return sec;
    }
    
    static class Time{//0.001초 단위 1초 = 1000  1분 60초  1시간 = 3600초 
        int startTime;
        int endTime;
        
        public Time(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}