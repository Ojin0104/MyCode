import java.util.*;
class Solution {
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    public int solution(int n, int[][] wires) {
        //전선 하나씩 
        int answer = -1;
        check=new boolean[n+1];
        arr=new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            arr[i]=new ArrayList<>();
        }
        for(int[] wire:wires){
            arr[wire[0]].add(wire[1]);
            arr[wire[1]].add(wire[0]);
        }
        int min=Integer.MAX_VALUE;
        int count=0;
        for(int[] wire:wires){//해당전선을 시작노드로 dfs노드탐색 그리고 반대편 노드 입장 x
            check=new boolean[n+1];
            count=countNode(wire[0],wire[1]);
            min=Math.min(min,Math.abs((n-count)-count));
           // System.out.println(count);
        }
        
        
        return min;
    }
    
    static int countNode(int s,int not){
        int answer=1;
        check[s]=true;
        for(int next:arr[s]){
            if(!check[next]&&next!=not){
                answer+=countNode(next,not);
            }
        }
        return answer;
    }
}