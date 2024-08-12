class Solution {
    public int findCircleNum(int[][] isConnected) {
        //
        int answer = 0;
        boolean[] visit = new boolean[isConnected.length];
        for(int idx = 0; idx<visit.length; idx++){
            if(!visit[idx]){
                dfs(idx,visit,isConnected);
                answer++;
            }
            
        }

        return answer;
    }

    void dfs(int idx, boolean[] visit, int[][] isConnected ){
        visit[idx] =true;
        for(int next = 0 ; next<isConnected.length;next++){
            if(!visit[next]&&isConnected[idx][next]==1){
                dfs(next,visit,isConnected);
            }
        }

    }
}