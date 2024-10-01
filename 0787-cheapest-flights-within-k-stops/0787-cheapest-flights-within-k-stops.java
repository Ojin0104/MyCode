class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        List<List<Edge>> edges = new ArrayList<>();
int[] dist= new int[n+1];
        for(int idx = 0 ; idx< n+1; idx++){
            edges.add(new ArrayList<Edge>());
            dist[idx] =Integer.MAX_VALUE;
        }

        for(int[] flight: flights){
            int start = flight[0];
            int end = flight[1];
            int cost = flight[2];

            edges.get(start).add(new Edge(end,cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)-> o1.times- o2.times);
        dist[src]= 0;
        pq.add(new Node(src,0,0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.num] <now.dist)continue;
            dist[now.num] = now.dist;
            
            for(Edge next : edges.get(now.num)){
                int nextNum = next.end;
                int cost = next.cost;
                if(dist[now.num]+cost<dist[nextNum]&&now.times<k+1){
                    pq.add(new Node(nextNum,dist[now.num]+cost,now.times+1));
                }
            }
            
        }


        if(dist[dst] == Integer.MAX_VALUE){
            return -1;

        }
        
        
        return dist[dst];
    }

    static class Node{
        int num;
        int dist;
        int times;

        public Node(int num, int dist,int times){
            this.num = num;
            this.dist =dist;

            this.times =times;
        }
    }


    static class Edge{
        int end;
        int cost; 

        public Edge(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
}