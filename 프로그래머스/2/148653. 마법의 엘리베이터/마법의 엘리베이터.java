import java.lang.*;

class Solution {
    int MIN = Integer.MAX_VALUE;

    public int solution(int storey) {
        int answer = 0;
        int level = storey;

        DFS(storey, answer, 0);

        if (MIN != Integer.MAX_VALUE)
            answer = MIN;

        return answer;
    }

    public void DFS(int storey, int cnt, int n) {
        if (cnt > MIN) return;
        if (storey == 0) {
            MIN = cnt;
            return;
        }

        //System.out.println("1 storey=" +storey + ", cnt=" + cnt + ", n=" + n);
        int remainder = storey % 10;
        storey = storey / 10;

        DFS(storey, cnt+remainder, n+1);
        //System.out.println("2 storey=" +storey + ", cnt=" + cnt + ", n=" + n);
        DFS(storey + 1, cnt + 10 - remainder, n+1);
    }
}
