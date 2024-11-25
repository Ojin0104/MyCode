class Solution {
        static int[] dr ={0,1,0,-1};
        static int[] dc = {1,0,-1,0};
    public List<Integer> spiralOrder(int[][] matrix) {
        int dir = 0;
        int nowRow = 0;
        int nowCol = 0;
        boolean[][] visit = new boolean[matrix.length][matrix[0].length];
       
        int count = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while(count<matrix.length*matrix[0].length){
            answer.add(matrix[nowRow][nowCol]);
            count++;
            visit[nowRow][nowCol] = true;
            int nextRow= nowRow+dr[dir];
            int nextCol = nowCol+dc[dir];

            if(nextRow<0||nextCol<0||nextRow>=matrix.length || nextCol>=matrix[0].length||visit[nextRow][nextCol]){
                dir = (dir+1)%4;
                nowRow= nowRow+dr[dir];
                nowCol = nowCol+dc[dir];
                continue;
            }
            nowRow= nextRow;
            nowCol = nextCol;

        }
        return answer;
    }
}