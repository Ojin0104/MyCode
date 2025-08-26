import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> arr = new ArrayList<>();
        combDfs(answer, candidates,0,target,arr);

        return answer;
    }

    public void combDfs(List<List<Integer>> answer, int[] candidates, int idx, int target, List<Integer> array){
        int sum = array.stream().mapToInt(Integer::intValue).sum();
        if(sum > target)return;

        if(sum == target){
            answer.add(new ArrayList(array));
        }

        for(int i = idx; i < candidates.length; i++){
            if(sum+candidates[i]>target)return;
            array.add(candidates[i]);
            combDfs(answer,candidates,i,target,array);
            array.remove(array.size()-1);
        }
    }
}