import java.util.*;

class Solution {
    static int answer = 0;
    static ArrayList<Integer>[] graph;
    public int solution(int n, int[][] lighthouse) {
        
        graph =new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i]=new ArrayList<Integer>();
           
        }
        for( int[] edge : lighthouse){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
    
        
        dfs(1,0);
        
        return answer;
        }
        
        
        
    public int dfs(int now, int bef){
        
        int sum = 0;
        for(int next: graph[now]){
            if(next == bef)continue;
            sum+=dfs(next,now);
        }
        
        if(sum>=1){
            answer++;
            return 0;
        }
        
        return 1;
    }
   
}