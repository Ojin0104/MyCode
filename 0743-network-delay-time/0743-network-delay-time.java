import java.util.*;
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> edges = new ArrayList<>();
        boolean[] visit = new boolean[n+1];
        int[] dist = new int[n+1];
        for(int idx =0; idx<n+1; idx++){
            edges.add(new ArrayList<Edge>());
            dist[idx] = Integer.MAX_VALUE;
        }
        for(int[] time: times){
            int start = time[0];
            int end = time[1];
            int cost = time[2];
            edges.get(start).add(new Edge(start,end,cost));
        }


        dist[k] = 0;

        PriorityQueue<Node> que = new PriorityQueue<>((o1,o2)-> o1.dist-o2.dist);

        que.add(new Node(k,0));

        while(!que.isEmpty()){
            Node node = que.poll();
            int now = node.num;
            if(visit[now])continue;

            visit[now] = true;

            for(Edge next : edges.get(now)){
                int n_start = next.s;
                int n_end = next.e;
                int n_cost = next.cost;

                if(dist[now]+n_cost<dist[n_end]){
                    que.add(new Node(n_end,dist[now]+n_cost));
                    dist[n_end] = dist[now]+n_cost;
                }
            }
        }
        int answer = 0;
        for(int idx = 1; idx<=n ;idx++){
            if(dist[idx] == Integer.MAX_VALUE){
                return -1;
            }
            if(idx==k) continue;

            answer = Math.max(answer,dist[idx]);
        }

        return answer;




    }
    static class Node{
        int num;
        int dist;

        public Node(int num, int dist){
            this.num = num;
            this.dist= dist;
        }
    }

    static class Edge{
        int s;
        int e;
        int cost;

        public Edge(int s, int e, int cost){
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
    }
}