import java.util.*;
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        ArrayDeque<Integer> que = new ArrayDeque<>();
        int[] count = new int[numCourses];

        init(numCourses, graph, prerequisites, count);
        
        addQueue(que,count);
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
        if(answerArray.size()<numCourses)return new int[0];
        int[] answer = answerArray.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public void addQueue(ArrayDeque<Integer> que, int[] count){
        for(int idx = 0; idx<count.length; idx++){
            if(count[idx] ==0 ){
                que.addLast(idx);
            }
        }
    }

    public void init(int numCourses, List<List<Integer>> graph, int[][] prerequisites, int[] count){
        for(int idx = 0 ; idx<numCourses; idx++){
            graph.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            int first = prerequisite[1];
            int second = prerequisite[0];
            count[second]++;
            graph.get(first).add(second);
        }

    }
}