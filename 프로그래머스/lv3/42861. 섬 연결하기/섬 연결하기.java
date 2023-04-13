import java.util.*;
class Solution {
    static int[] parent;
    public int solution(int n, int[][] costs) {         
        int answer = 0;
        Arrays.sort(costs,(a,b)->a[2]-b[2]);
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        
        for(int[] cost:costs){
            if(find(cost[0])==find(cost[1]))continue;
            union(cost[0],cost[1]);
            answer+=cost[2];
            
        }
        
        
        return answer;
    }
    
    static int find(int num){
        if(parent[num]==num)return num;
        
        return parent[num]=find(parent[num]);
    }
    
    static void union(int a,int b){
        int A=find(a);
        int B=find(b);
        
        if(A<B)parent[B]=A;
        else parent[A]=B;
    }
}