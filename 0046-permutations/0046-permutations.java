class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visit = new boolean[nums.length];
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        permutation(nums,visit,list,answer);

        return answer;
    }

    static void permutation(int[] nums, boolean[] visit, List<Integer> list, List<List<Integer>> answer){

        if(list.size()== nums.length){
            answer.add(deepCopy(list));
            return;
        }

        for(int idx = 0 ;idx< nums.length; idx++){

            if(visit[idx])continue;

            visit[idx] = true;
            list.add(nums[idx]);
            permutation(nums,visit,list,answer);
            list.remove(list.size()-1);
            visit[idx] = false;
        }
    }
    
    static List<Integer> deepCopy(List<Integer> list){
        List<Integer> ans = new ArrayList<>();
        
        for( Integer num : list){
            ans.add(num);
        }

        return ans;
    }
    }