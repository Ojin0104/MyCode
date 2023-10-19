import java.util.*;
//다익스트라
//destination 에서모든 노드로의 경로
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        
        for(int i=1;i<n+1;i++){
            graph[i]=new ArrayList<Integer>();
        }
        //roads를 arrayList로
        for(int [] road: roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        Arrays.fill(answer,100001);
        answer[destination]=0;
        dikstra(answer,destination,graph);
        
        //sources를 변경
        for(int i=0;i<sources.length;i++){
            if(answer[sources[i]]==100001){
                sources[i]=-1;
            }else{
                sources[i]=answer[sources[i]];
            }
        }
        return sources;
    }
    
    static void dikstra(int[] answer,int destination,ArrayList<Integer>[] graph){
        Queue<Integer> que = new ArrayDeque<>();
        
        que.add(destination);
        
        boolean[] check = new boolean[answer.length];
        
        while(!que.isEmpty()){
            Integer now = que.poll();
            if(check[now])continue;
            
            check[now]=true;
            for(Integer next: graph[now]){
                if(check[next])continue;
                if(answer[now]+1<answer[next]){
                    answer[next]=answer[now]+1;
                    que.add(next);
                }
            }
        }
    }
}