import java.util.*;
class Solution {
    static int max_sheep=0;
    static boolean[] check;
    static ArrayList<Integer>[] arr;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        arr=new ArrayList[info.length];
        
        for(int i=0;i<info.length;i++){
            arr[i]=new ArrayList<>();
        }
        for(int[] edge:edges){
            
            arr[edge[0]].add(edge[1]);
            arr[edge[1]].add(edge[0]);
        }
        
       check=new boolean[info.length];
        int sheep=1;
        check[0]=true;
        int wolf=0;
        
        dfs(0,sheep,wolf,arr[0],info);
        
        return max_sheep;
    }
    static void dfs(int n,int sheep,int wolf, ArrayList<Integer> cango,int[] info){
        
        
        max_sheep=Math.max(max_sheep,sheep);
        if(cango.isEmpty())return;
        
        for(Integer next:cango){
            
            int[] animal=new int[2];
            if(info[next]==0)animal[0]++;
            else
                animal[1]++;
            
            if(sheep+animal[0]<=wolf+animal[1])continue;
            
            ArrayList<Integer> nextarr=new ArrayList<>();
            
            for(Integer nextgo:cango){
                if(nextgo!=next)nextarr.add(nextgo);
            }
            
            for(Integer nextgo:arr[next]){
                if(!check[nextgo])nextarr.add(nextgo);
            }
            
            check[next]=true;
            dfs(next,sheep+animal[0],wolf+animal[1],nextarr,info);
            check[next]=false;
           
        }
    }
}