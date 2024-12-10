class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 위상정렬 큐에넣고 진행
        ArrayList<Integer>[] graph = new ArrayList[numCourses];

        for(int idx = 0 ; idx< numCourses ; idx++){
            graph[idx]  =new ArrayList<>();
        }
        int[] check = new int[numCourses]; 
        for(int[] prerequisite : prerequisites){
            graph[prerequisite[1]].add(prerequisite[0]);
            check[prerequisite[0]]++;
        }
        
        Queue<Integer> que = new LinkedList<>();

        for(int idx = 0; idx<numCourses; idx++){
            if(check[idx] ==0){
                que.add(idx);
            }
        }

        while(!que.isEmpty()){
            int num = que.poll();

            ArrayList<Integer> afterCourses = graph[num];

            for(Integer afterCourse : afterCourses){
                check[afterCourse]--;
                if(check[afterCourse] == 0)que.add(afterCourse);
            }

        }

        for(int idx =0 ; idx<numCourses; idx++){
            if(check[idx]!=0)return false;
        }

        return true;
    }
}