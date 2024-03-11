import java.util.*;
class Solution {
    public int solution(String numbers) {
        HashSet<Integer> set = new HashSet<Integer>();
        boolean[] visit= new boolean[numbers.length()];
        dfs(set,numbers,0,visit,"");
        int answer = findSosu(set);
        return answer;
    }
    
    static int findSosu(HashSet<Integer> set){
        int count = 0;
        for(Integer num:set){
            if(isSosu(num)){
                count++;
            }
        }
        return count;
    }
    
    static boolean isSosu(int num){
        if(num==1||num==0)return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
    
    static void dfs(HashSet<Integer> set,String numbers,int idx,boolean[] visit,String str){
        if(idx>=numbers.length())return;
        for(int i =0 ;i<numbers.length();i++){
            if(!visit[i]){
                visit[i]=true;
                set.add(Integer.parseInt(str+numbers.charAt(i)));
                dfs(set,numbers,idx+1,visit,str+numbers.charAt(i));
                visit[i]=false;
                
            }
        }
    } 
}