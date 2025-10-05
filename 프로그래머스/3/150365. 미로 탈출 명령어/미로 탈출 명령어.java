class Solution {

    int[] dx = {1, 0, 0, -1};          // d, l, r, u
    int[] dy = {0, -1, 1, 0};
    char[] dir = {'d', 'l', 'r', 'u'};

    int n, m, r, c, k;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;

        StringBuilder sb = new StringBuilder();

        return dfs(x, y, sb) ? sb.toString() : "impossible";
    }

    // DFS로 사전순 경로를 탐색하며 유효한 경로를 찾으면 true 반환
    public boolean dfs(int x, int y, StringBuilder sb) {
        if (sb.length() == k) {
            return x == r && y == c;
        }

        int remain = k - sb.length();
        int distance = Math.abs(x - r) + Math.abs(y - c);

        // 가지치기: 남은 거리보다 많이 이동해야 하거나, 도달 가능성이 없는 경우
        if (remain < distance || (remain - distance) % 2 != 0) return false;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 1 || nx > n || ny < 1 || ny > m) continue;

            sb.append(dir[i]);
            if (dfs(nx, ny, sb)) return true;
            sb.deleteCharAt(sb.length() - 1);  // 백트래킹
        }

        return false;
    }
}