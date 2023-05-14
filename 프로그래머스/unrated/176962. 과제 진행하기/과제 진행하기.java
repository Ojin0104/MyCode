import java.util.*;
class Solution {
    //과제멈춰준거 큐에담음
    //시간된 과제 우선
    public String[] solution(String[][] plans) {
        String[] answer =new String[plans.length];
        PriorityQueue<Work> que=new PriorityQueue<>();
        
        int index=0;
        String[] time=plans[0][1].split(":");
        int needtime=0;
        Arrays.sort(plans,new Comparator<String[]>(){
            @Override
            public int compare(String[] o1,String[] o2){
                return o1[1].compareTo(o2[1]);}
        });
        
        for(int i=0;i<answer.length-1;i++){
            
            needtime=Integer.parseInt(plans[i][2]);
            
            time=plans[i][1].split(":");
            int nowtime=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            time=plans[i+1][1].split(":");
            
            int nexttime=Integer.parseInt(time[0])*60+Integer.parseInt(time[1]);
            
            
            if(nexttime-nowtime>=needtime){//전에꺼 성공적으로수행
                answer[index]=plans[i][0];
                index++;
                nowtime=nowtime+needtime; //시간늘려줌
                
                while(!que.isEmpty()){//시간 남아있으면 큐에있는거사용
                    Work work=que.poll();
                
                    if(nexttime-nowtime>=work.needtime){
                        answer[index++]=work.subject;
                        
                        nowtime=nowtime+work.needtime; //시간줄여줌
                    }else{
                        
                        
                        int newtime=work.needtime-nexttime+nowtime;
                        que.add(new Work(work.subject,work.time,newtime));
                
                        break;
                    }
                }
                
            }else{//남은시간 큐에넣음
                que.add(new Work(plans[i][0],nowtime,Integer.parseInt(plans[i][2])-nexttime+nowtime));
                
            }
            
            
        }
        answer[index++]=plans[plans.length-1][0];
        
        while(!que.isEmpty()){
            answer[index++]=que.poll().subject;
        }
        return answer;
    }
    static class Work implements Comparable<Work>{
        String subject;
        int time;
        int needtime;
        Work(String subject,int time, int needtime){
            this.subject=subject;
            this.time=time;
            this.needtime=needtime;
        }
        @Override
        public int compareTo(Work o){
            return o.time-this.time;
        }
        
        
    }
    
    
}