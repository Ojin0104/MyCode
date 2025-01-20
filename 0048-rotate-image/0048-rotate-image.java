class Solution {
    public void rotate(int[][] matrix) {
        int depth = 0;
        int S = matrix.length-1;
        for(int row =0;row<=matrix.length/2; row++){
            for(int col = depth; col<matrix[0].length-depth-1; col++){
                //row col, col S-row, S-row S-col, S-col row
                int temp = matrix[row][col];

                matrix[row][col] = matrix[S-col][row];
                matrix[S-col][row] = matrix[S-row][S-col];
                matrix[S-row][S-col] = matrix[col][S-row];
                matrix[col][S-row] = temp;
            }
            depth++;
        }
        
    }
}