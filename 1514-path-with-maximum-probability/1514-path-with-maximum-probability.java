import java.util.*;
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        
        List<List<Edge>> edgeList = new ArrayList<>();
        double[] dist = new double[n];

        for(int idx = 0 ; idx <=n; idx++){
            edgeList.add(new ArrayList<Edge>());
        }
        for(int idx = 0; idx<edges.length; idx++){
            
            int[] edge = edges[idx];

            int start = edge[0];
            int end = edge[1];
            double cost = succProb[idx];
            edgeList.get(start).add(new Edge(end,cost));
            edgeList.get(end).add(new Edge(start,cost));
        }
        
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>((o1,o2)->(int)(o2.cost*100000- o1.cost*100000));
        pq.add(new Edge(start_node,1.0));
        dist[start_node] = 1.0;
        while(!pq.isEmpty()){
            Edge now = pq.poll();
            
            if(now.cost<dist[now.end])continue;
            if(now.end == end_node)break;
            for(Edge next: edgeList.get(now.end)){
                if(dist[next.end]<dist[now.end]*next.cost){
                    dist[next.end] = dist[now.end]*next.cost;
                    pq.add(new Edge(next.end,dist[next.end]));
                }
            }
        }

        return dist[end_node];

    }
    

    static class Edge{
        int end;
        double cost;

        public Edge(int end,double cost){
            this.end = end;
            this.cost =cost;
        }
    }
}