import java.util.*;
class Solution {
    public int snakesAndLadders(int[][] board) {
        int[] arr = new int[board.length*board[0].length];
        int n = board.length;
        int idx =0;
        for(int row=n-1; row>=0; row--){

            if((n-row)%2==1){
                for(int col =0 ; col< n;col++){
                    arr[idx++] = board[row][col];
                }
            }else{
                for(int col=n-1;col>=0;col--){
                     arr[idx++] = board[row][col];
                }
            }
        }

        Status status = new Status(0,0);
        ArrayDeque<Status> que = new ArrayDeque<>();
        que.addLast(status);
        boolean[] check = new boolean[n*n];
        check[0] = true;
        while(!que.isEmpty()){
            Status now = que.removeFirst();

            if(now.num == n*n-1)return now.times;

            for(int next = now.num+1; next<=Math.min(now.num+6,n*n-1);next++){
                
                if(check[next])continue;
                check[next] = true;

                int realNext = next;
                if(arr[next]!=-1){
                realNext = arr[next]-1;
                }
                que.addLast(new Status(now.times+1,realNext));
            }
        }

        return -1;
    }

    static class Status{
        int times;
        int num;

        public Status(int times, int num){
            this.times = times;
            this.num = num;
        }
    }
}