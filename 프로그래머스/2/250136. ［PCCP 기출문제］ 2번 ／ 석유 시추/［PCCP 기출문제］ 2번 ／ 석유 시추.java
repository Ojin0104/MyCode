import java.util.*;

class Solution {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public int solution(int[][] land) {
        int rowLen = land.length;
        int colLen = land[0].length;
        int[] oilStore = new int[colLen];
        boolean[][] visited = new boolean[rowLen][colLen];

        for (int row = 0; row < rowLen; row++) {
            for (int col = 0; col < colLen; col++) {
                if (land[row][col] != 1 || visited[row][col]) continue;

                Set<Integer> oilCols = new HashSet<>();
                int count = bfs(land, visited, row, col, oilCols);
                for (int c : oilCols) {
                    oilStore[c] += count;
                }
            }
        }

        return Arrays.stream(oilStore).max().getAsInt();
    }

    private int bfs(int[][] land, boolean[][] visited, int startRow, int startCol, Set<Integer> oilCols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int count = 1;
        oilCols.add(startCol);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr < 0 || nr >= land.length || nc < 0 || nc >= land[0].length) continue;
                if (land[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                    count++;
                    oilCols.add(nc);
                }
            }
        }

        return count;
    }
}
