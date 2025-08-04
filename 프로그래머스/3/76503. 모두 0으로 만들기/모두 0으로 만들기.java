import java.util.*;
class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        //1. 가중치의 합이 0이 아니면 -1
        //2. 리프노드 먼저 0
        //3. 위상정렬느낌으로
        List<List<Integer>> edgeList = new ArrayList<>();
       int[] degree = new int[a.length];
        
        int sum = 0;
        long[] b = new long[a.length];
        for(int idx =0 ; idx<a.length; idx++){
            sum+=a[idx];
            b[idx] = a[idx];
            edgeList.add(new ArrayList<>());
        }
        
        if(sum!=0)return -1;
        
        for(int[] edge:edges){
            int s = edge[0];
            int e = edge[1];
            
            edgeList.get(s).add(e);
            edgeList.get(e).add(s);
            degree[s]++;
            degree[e]++;
            
        }
        Deque<Integer> que = new ArrayDeque<>();
        for(int idx = 0; idx<a.length; idx++){
            if(degree[idx] ==1){
                que.add(idx);
            }
        }
        
        while(!que.isEmpty()){
            Integer now = que.pollFirst();
            
            for(int next : edgeList.get(now)){
                if(degree[next]==0)continue;
                b[next]+=b[now];
                answer += Math.abs(b[now]);
                b[now] = 0;
                degree[now]--;
                degree[next]--;
                
                if(degree[next]==1){
                    que.add(next);
                }
            }
        }
        
        return answer;
    }
    
    
    
    
}