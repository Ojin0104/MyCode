import java.util.*;

public class Solution {
    public int[] solution(int[][] edges, int[] target) {
        int n = edges.length + 1;
        List<Integer>[] children = new ArrayList[n + 1];
        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) children[i] = new ArrayList<>();

        // 트리 구성
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            children[a].add(b);
            parent[b] = a;
        }

        // 자식 정렬 (번호 작은 순서)
        for (int i = 1; i <= n; i++)
            Collections.sort(children[i]);

        // 리프 노드 판별
        boolean[] isLeaf = new boolean[n + 1];
        List<Integer> leaves = new ArrayList<>();
        Map<Integer, Integer> leafIndex = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (children[i].isEmpty()) {
                isLeaf[i] = true;
                leafIndex.put(i, leaves.size());
                leaves.add(i);
            }
        }

        // 리프가 아닌 노드의 target이 0이 아니면 불가능
        for (int i = 1; i <= n; i++) {
            if (!isLeaf[i] && target[i - 1] != 0)
                return new int[]{-1};
        }

        int totalSum = 0;
        for (int t : target) totalSum += t;

        // 시뮬레이션
        int feasibleL = -1;
        List<Integer> seqAtL = null;

        for (int L = 1; L <= totalSum; L++) {
            List<Integer> seq = simulate(L, children);
            int[] cnt = new int[leaves.size()];
            for (int u : seq) cnt[leafIndex.get(u)]++;

            boolean ok = true;
            for (int i = 0; i < leaves.size(); i++) {
                int k = cnt[i];
                int T = target[leaves.get(i) - 1];
                if (k == 0) {
                    if (T != 0) { ok = false; break; }
                } else {
                    if (!(k <= T && T <= 3 * k)) {
                        ok = false;
                        break;
                    }
                }
            }
            if (ok) {
                feasibleL = L;
                seqAtL = seq;
                break;
            }
        }

        if (feasibleL == -1)
            return new int[]{-1};

        // 리프별 남은 방문수/합 초기화
        int[] remK = new int[leaves.size()];
        int[] remT = new int[leaves.size()];
        for (int u : seqAtL)
            remK[leafIndex.get(u)]++;
        for (int i = 0; i < leaves.size(); i++)
            remT[i] = target[leaves.get(i) - 1];

        List<Integer> ans = new ArrayList<>();

        // 사전순 최소 수열 구성
        for (int u : seqAtL) {
            int i = leafIndex.get(u);
            int k = remK[i];
            int T = remT[i];
            int chosen = -1;
            for (int x = 1; x <= 3; x++) {
                if (x > T) continue;
                int low = (k - 1);
                int high = (k - 1) * 3;
                if (low <= T - x && T - x <= high) {
                    chosen = x;
                    break;
                }
            }
            if (chosen == -1) return new int[]{-1};
            ans.add(chosen);
            remK[i]--;
            remT[i] -= chosen;
        }

        // int[] 변환
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // L번 떨어뜨릴 때 어떤 리프를 방문하는지 시뮬레이션
    private List<Integer> simulate(int L, List<Integer>[] children) {
        int n = children.length - 1;
        int[] ptr = new int[n + 1];
        List<Integer> seq = new ArrayList<>();
        for (int i = 0; i < L; i++) {
            int u = 1;
            List<Integer> path = new ArrayList<>();
            while (!children[u].isEmpty()) {
                path.add(u);
                u = children[u].get(ptr[u]);
            }
            seq.add(u);
            // 경로 노드의 포인터 갱신
            for (int w : path) {
                int deg = children[w].size();
                if (deg > 0)
                    ptr[w] = (ptr[w] + 1) % deg;
            }
        }
        return seq;
    }

}
