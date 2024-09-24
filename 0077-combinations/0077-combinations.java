import java.util.*;
class Solution {
    static List<List<Integer>> answer;
    public List<List<Integer>> combine(int n, int k) {
        int[] arr= new int[k];
        answer = new ArrayList<>();
        dfs(arr,1,n,k);

        return answer;
    }

    static void dfs(int[] arr,int idx,int n, int k){

        if(k==0){
            List<Integer> lst = new ArrayList<>();
            for(int num: arr){
                lst.add(num);
            }

            answer.add(lst);
            return;
        }

        if(idx>n)return;

        arr[arr.length-k] = idx;
        dfs(arr, idx+1,n,k-1);
            
        dfs(arr,idx+1,n,k);
    }
}