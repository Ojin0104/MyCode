class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit= new boolean[rooms.size()];

        dfs(visit,rooms,0);

        return checkVisit(visit);
    }

    boolean checkVisit(boolean[] visit){
        for(boolean status : visit){
            
            if(!status)return false;
        }

        return true;
    }

    void dfs(boolean[] visit, List<List<Integer>> rooms, int idx){

        visit[idx] =true;
        for(Integer next : rooms.get(idx)){
            
            if(visit[next])continue;
            
            dfs(visit,rooms,next);

        }
    }


}