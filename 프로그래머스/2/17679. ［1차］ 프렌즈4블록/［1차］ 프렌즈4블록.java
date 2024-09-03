class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        Character[][] map = new Character[board.length][board[0].length()];
        for(int idx = 0; idx < board.length; idx++){
            for(int j = 0; j < board[0].length(); j++){
                
                map[idx][j] = board[idx].charAt(j);
                
            }
        }
        int count = -1;
        while(count!=0) {
            count = findComb(map);
            if (count == 0) {
                return answer;
            }
            delComb(map);
            answer += count;
            
        }
        
        return answer;
    }

    private static void delComb(Character[][] map) {
        
        for(int col = 0; col < map[0].length; col++) {
            for(int row = 0; row <map.length; row++) {
                if(map[row][col]=='0'){
                    pull(map,row,col);
                }
            }
           
        }
    }
    
    private static void pull(Character[][] map, int row, int col){
        for(int idx = row; idx>0;idx--){
            map[idx][col] = map[idx-1][col];
        }
        map[0][col] = '0';
    }

    private static int findComb(Character[][] map) {
        boolean[][] imsi = new boolean[map.length][map[0].length];
        int count = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {

                if (isComb(map, row, col)) {
                    imsi[row][col] = true;
                    imsi[row + 1][col] = true;
                    imsi[row + 1][col + 1] = true;
                    imsi[row][col + 1] = true;
                }
            }
        }

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {

                if(imsi[row][col]) {
                    map[row][col]='0';
                    count++;
                }
            }
        }
        
        return count;
    }
    
    private static boolean isComb(Character[][] map,int row, int col) {
        
        if(row<0||col<0||row>=map.length-1||col>=map[0].length-1) return false;
        if(map[row][col]=='0') return false;
        Character ch = map[row][col];
        
        if(map[row+1][col]!=ch) return false;
        
        if(map[row+1][col+1]!=ch) return false;
        
        if(map[row][col+1]!=ch) return false;
        
        return true;
    }
}