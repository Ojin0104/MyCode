import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> arr = new ArrayList<>();
        combDfs(answer, candidates,0,0,target,arr);

        return answer;
    }

    public void combDfs(List<List<Integer>> answer, int[] candidates, int sum, int idx, int target, List<Integer> array){
        if(sum > target)return;

        if(sum == target){
            answer.add(new ArrayList(array));
        }

        for(int i = idx; i < candidates.length; i++){
            array.add(candidates[i]);
            combDfs(answer,candidates,sum+candidates[i],i,target,array);
            array.remove(array.size()-1);
        }
    }
}