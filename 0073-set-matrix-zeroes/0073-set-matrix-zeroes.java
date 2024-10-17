class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rows= new boolean[matrix.length];
        boolean[] cols= new boolean[matrix[0].length];

        for(int row =0; row<matrix.length; row++){
            for(int col =0; col<matrix[0].length; col++){
                if(matrix[row][col]==0){
                    rows[row] = true;
                    cols[col] = true;
                }
            }
        }

        for(int row =0; row<matrix.length; row++){
            for(int col =0; col<matrix[0].length; col++){
                if(rows[row]|cols[col]){
                    matrix[row][col]=0;
                }
            }
        }

    }
}