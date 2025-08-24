import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] count = new int[numCourses];

        for(int idx = 0 ; idx<numCourses; idx++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            int first = prerequisite[1];
            int second = prerequisite[0];
            count[second]++;
            graph.get(first).add(second);
        }

        for(int idx = 0; idx<numCourses; idx++){
            if(count[idx] ==0 ){
                que.addLast(idx);
            }
        }

        int order = 0;

        ArrayList<Integer> answerArray = new ArrayList<>();


        while(!que.isEmpty()){
            Integer now = que.poll();

            answerArray.add(now);
            for(Integer next : graph.get(now)){

                if(count[next]==0)continue;

                count[next]--;

                if(count[next]==0){
                    que.addLast(next);
                }

                
            }
        }
        int[] answer = answerArray.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}