class Solution {
    static int r =0;
    public boolean searchMatrix(int[][] matrix, int target) {
        r= matrix[0].length;


        return binSearch(matrix, target);
    }

    static boolean binSearch(int[][] matrix, int target){
        int left= 0;
        int right = matrix.length*matrix[0].length-1;

        while(left<=right){
            int mid = (left+right)/2;
            int[] midPoint = idxToPoint(mid);
            int midValue = matrix[midPoint[0]][midPoint[1]];
            if(midValue == target){
                return true;
            }else if(midValue<target){
                left = mid+1;
            }else if(midValue>target){
                right = mid-1;
            }
        }

        return false;
    }
    
    static int[] idxToPoint(int num){
        int[] answer = new int[2];

        answer[0] = num/r;
        answer[1] = num%r;

        return answer;
    }
}