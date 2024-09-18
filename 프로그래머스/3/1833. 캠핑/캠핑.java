import java.util.*;
class Solution {
    public int solution(int n, int[][] data) {
        //각 쐐기 마다 연결하는 포인틀르 저장 
        HashMap<Integer,Integer> xPoint = new HashMap<>();
        HashMap<Integer,Integer> yPoint = new HashMap<>();
        int answer = 0;
        //x 값 좌표압축
        Arrays.sort(data,(o1,o2)->o1[0]-o2[0]);
        int point = 0;
        for(int idx=0; idx<data.length;idx++){
            if(!xPoint.containsKey(data[idx][0])){
                xPoint.put(data[idx][0],point);
                point++;
            }
        }
        point = 0;
        //y값 좌표압축
        Arrays.sort(data,(o1,o2)->o1[1]-o2[1]);
         for(int idx=0; idx<data.length;idx++){
            if(!yPoint.containsKey(data[idx][1])){
                yPoint.put(data[idx][1],point);
                point++;
            }
        }
        
        int[][] map = new int[n][n];
        int[][] sum = new int[n][n];
        //2차원 누적합 계산
        for(int[] pinPoint : data){
            int x = xPoint.get(pinPoint[0]);
            int y = yPoint.get(pinPoint[1]);
            
            map[x][y] = 1;
        }
        
        for(int x = 0;x<n;x++){
            sum[x][0] = map[x][0];
            for(int y =1; y<n;y++){
                sum[x][y] = sum[x][y-1]+map[x][y];
            }
            
            
    }
        
        for(int y =0;y<n;y++){
            for(int x = 1;x<n;x++){
                sum[x][y] += sum[x-1][y];
            }
        }
        
        
        //n^2으로 각 쐐기점 사이에 다른 쐐기가 없다면 answer+1
        Arrays.sort(data,(o1,o2)->{
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }else{
               return  o1[0]-o2[0];
            }
        });
        for(int first = 0;first<n-1;first++){
            int row = xPoint.get(data[first][0]);
            int col = yPoint.get(data[first][1]);
            int[] left = new int[]{row,col};
            for(int second=first+1;second<n;second++){
                int s_row = xPoint.get(data[second][0]);
                int s_col = yPoint.get(data[second][1]);
                int[] right = new int[]{s_row, s_col};
                if(s_row==row || s_col==col)continue;
                
                if(calcPinPoint(left,right,sum)==0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
    
    static int calcPinPoint(int[] left, int[] right, int[][] sum){
        //sum[right]
        int startRow = Math.min(left[0],right[0]);
        int startCol = Math.min(left[1],right[1]);
        int endRow = Math.max(right[0],left[0]);
        int endCol = Math.max(left[1],right[1]);
        startRow++;
        startCol++;
        endRow--;
        endCol--;
        
        int answer = sum[endRow][endCol] + sum[startRow-1][startCol-1] - sum[startRow-1][endCol] - sum[endRow][startCol-1];
        
        return answer;
        
    }
}