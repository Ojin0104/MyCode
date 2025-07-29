class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = divide(arr,new int[]{0,0},arr.length);
        
        return answer;
    }
    
    public boolean checkSame(int[][] arr, int[] now, int size){
        int value = arr[now[0]][now[1]];
        for(int row = now[0] ; row<now[0]+size; row++){
            for(int col = now[1]; col<now[1]+size; col++){
                if(value != arr[row][col]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public int[] divide(int[][] arr, int[] now, int size){
        
        if(checkSame(arr,now,size)){
            if(arr[now[0]][now[1]]==1){
                return new int[]{0,1};
            }
            
            return new int[]{1,0};
        }
        
        
        
        int[] answer = new int[2];
        
        //왼쪽위
        int[] leftUp = divide(arr, now,size/2);
        
        //오른쪽 위
        now[1]+=size/2;
        int[] rightUp = divide(arr, now,size/2);
        now[1]-=size/2;
        //왼쪽 아래
        
        now[0]+=size/2;
        int[] leftDown = divide(arr, now,size/2);
        now[0]-=size/2;
        
        //오른쪽 아래
        
        now[0]+=size/2;
        now[1]+=size/2;
        int[] rightDown = divide(arr, now,size/2);
        now[0]-=size/2;
        now[1]-=size/2;
        answer[0] = leftDown[0]+leftUp[0] + rightDown[0] + rightUp[0];
        answer[1] = leftDown[1]+leftUp[1] + rightDown[1] + rightUp[1];
        
        return answer;
    }
}