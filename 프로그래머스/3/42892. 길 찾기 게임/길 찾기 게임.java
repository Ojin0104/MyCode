import java.util.*;
class Solution {
    static int preIdx = 0;
    static int postIdx = 0;
    static int[][] answer;
    static Node[] list;
    public int[][] solution(int[][] nodeinfo) {
        list = new Node[nodeinfo.length];
        answer = new int[2][list.length];
        int idx = 0;
        for(int[] node:nodeinfo){
            list[idx++]=new Node(node[0],node[1],idx);
        }
        
        Arrays.sort(list,(o1,o2)->o1.x-o2.x);
        
        
        dfs(0,list.length);
        
        return answer;
    }
    
    static void dfs(int start, int end){
        if(start==end){
            
            return;
        }
        
        int parent = find(start,end);
        
        answer[0][preIdx++]=list[parent].num;
        
        dfs(start,parent);
        dfs(parent+1,end);
        
        answer[1][postIdx++]=list[parent].num;
    }
    
    static int find(int start,int end){
        int max = -1;
        int maxIdx=0;
        for(int idx =start; idx<end; idx++){
            if(list[idx].y>max){
                max=list[idx].y;
                maxIdx=idx;
            }
        }
        
        return maxIdx;
    }
}

class Node{
    int x;
    int y;
    int num;
    
    Node(int x,int y,int num){
        this.x = x;
        this.y= y;
        this.num = num;
    }
}