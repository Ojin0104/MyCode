class Solution {
    public int equalPairs(int[][] grid) {
        int answer = 0;

        for(int row = 0;row<grid.length; row++){
            for(int col = 0 ;col<grid.length;col++){
                for(int idx = 0;idx<grid.length; idx++){
                    if(grid[row][idx]!=grid[idx][col]){
                        break;
                    }

                    if(idx==grid.length-1)answer++;
                }
            }
        }

        return answer;
    }
}