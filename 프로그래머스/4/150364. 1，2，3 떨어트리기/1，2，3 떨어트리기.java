import java.util.*;

class Solution {

    private static int[] idx;
    private static int[] cnt;
    private static ArrayList<Integer>[] adjList;
    private static int[] tar;
    private static HashSet<Integer> done = new HashSet<>();
    private static ArrayDeque<Integer> order = new ArrayDeque<>();

    static public int[] solution(int[][] edges, int[] target) {
        int N = target.length;
        idx = new int[N + 1];
        cnt = new int[N + 1];
        tar = target;

        int leaf = 0;
        for (int i : target) if (i > 0) leaf++;

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();

        for (int[] edge : edges) adjList[edge[0]].add(edge[1]);

        for (int i = 1; i <= N; i++) Collections.sort(adjList[i]);

        while (true) {
            if (dfs(1) == -1)
                return new int[]{-1};
            else {
                if (done.size() == leaf)
                    break;
            }
        }

        for (int i = 0; i < N; i++) tar[i] -= cnt[i + 1] * 3;

        int[] answer = new int[order.size()];

        for (int i = 0; !order.isEmpty(); i++) {
            int x = order.poll() - 1;
            int num = 3;
            if (tar[x] <= -2) {
                num = 1;
                tar[x] += 2;
            }
            else if(tar[x] == -1) {
                num = 2;
                tar[x]++;
            }

            answer[i] = num;
        }

        return answer;
    }

    private static int dfs(int now) {
        if (adjList[now].isEmpty()) {
            cnt[now]++;

            if (cnt[now] * 3 >= tar[now - 1])
                done.add(now);

            order.add(now);
            return cnt[now] <= tar[now - 1] ? now : -1;
        }

        int next = idx[now]++ % adjList[now].size();
        return dfs(adjList[now].get(next));
    }

}