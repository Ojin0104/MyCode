class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        //1. 가중치의 합이 0이 아니면 -1
        //2. 리프노드 먼저 0
        //3. 위상정렬느낌으로
        
        int[] childCount = new int[a.length];
        
        ArrayList<Integer>[] graph = new ArrayList<>[a.length]();
        for(int idx = 0 ;idx<a.length; idx++){
            graph[idx] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
            childCount[edge[0]]++;
            childCount[edge[1]]++;
        }
        
        Queue<Integer> que = new ArrayDeque<>();
        
        for(int idx = 0 ;idx<childCount.length ; idx++){
            if(childCount[idx] ==1){
                que.add(idx);
            }
        }
        
        while(!que.isEmpty()){
            int now = que.poll();
            
            childCount[now]--;
            
            for(int next : graph[now]){
                if(childCount[next]==0)continue;
                
                
                count+= Math.abs(a[now]);
                a[next]-=a[now];
            }
        }
        
        return answer;
    }
}