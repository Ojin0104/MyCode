class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int arriveCount = routes.length;
        Robot[] robots = new Robot[routes.length];
        int[][] check  = new int[101][101];
        
        //로봇위치 초기 세팅
        for(int idx = 0; idx<robots.length; idx++){
            int[] startPoint = points[routes[idx][0]-1];
            robots[idx] = new Robot(startPoint);
            check[startPoint[0]][startPoint[1]]++;
        }
        answer+= collisionCount(check);
        
        
        //로봇 1초에 한칸씩 이동
        while(arriveCount >0){
            
            check  = new int[101][101];
            for(int idx = 0; idx<robots.length; idx++){
                Robot robot = robots[idx];
                if(robot.isEnd)continue;
                int dest = routes[idx][robot.nowDest]-1;
                
                int[] destPoint =points[dest];
                //로봇이동
                moveRobot(robot,destPoint);
                
                //check배열 저장
                check[robot.nowR][robot.nowC]++;
                
                //목적지 도착시 다음목적지 설정
                if(destPoint[0] == robot.nowR && destPoint[1] == robot.nowC){
                    robot.nowDest++;
                    if(robot.nowDest >= routes[idx].length){
                        robot.isEnd = true;
                        arriveCount--;
                    }
                        
                }
                
            }
            answer+= collisionCount(check);
        }
        return answer;
    }
    
    
    void moveRobot(Robot robot, int[] destPoint){
        if(robot.nowR > destPoint[0]){
            robot.nowR--;
            return;
        }
        
        if(robot.nowR < destPoint[0]){
            robot.nowR++;
            return;
        }
        
        if(robot.nowC > destPoint[1]){
            robot.nowC--;
            return;
        }
        
        if(robot.nowC < destPoint[1]){
            robot.nowC++;
            return;
        }
    }
    
    
    int collisionCount(int[][] check){
        int answer = 0;
        
        for(int row = 0; row<check.length ; row++){
            for(int col = 0 ;col <check[0].length ; col++){
                if(check[row][col]>1){
                    answer++;
                }
            }
        }
        return answer;
        
    }
    
    class Robot{
        int nowR;
        int nowC;
        int nowDest;
        boolean isEnd;
        
        Robot(int[] point){
            this.nowR = point[0];
            this.nowC = point[1];
            this.nowDest = 1;
            
        }
    }
}