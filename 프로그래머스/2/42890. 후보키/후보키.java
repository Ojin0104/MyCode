import java.util.*;
class Solution {
   // static boolean[] visit;
    ArrayList<ArrayList<Integer>> arr;
    public int solution(String[][] relation) {
      //  visit = new boolean[relation[0].length];
        int answer = 0;
        HashMap<String,Boolean> map = new HashMap<>();
         for(int num = 1;num<=relation.length;num++){
             arr = new ArrayList<ArrayList<Integer>>();
             comb(relation[0].length,0,num,new int[num]);
            
            for(ArrayList<Integer> nums:arr){
                if(checkKey(nums,relation)){
                    
                    saveNums(map,nums);
                }
                
            }
         }
        
        answer = map.size();
        return answer;
    }
    public void saveNums(HashMap<String,Boolean> map, ArrayList<Integer> nums){
        StringBuilder sb = new StringBuilder();
        for(Integer num: nums){
            sb.append(num);
        }
        
        for(String str : map.keySet()){
            int check = 0;
            for(int idx = 0;idx<str.length();idx++){
                if(sb.toString().contains(str.charAt(idx)+""))check++;
            }
            if(check==str.length())return;
        }
        map.put(sb.toString(),true);
    }
   
    public boolean checkKey(ArrayList<Integer> nums,String[][] relation){
        
        HashMap<String,Boolean> map = new HashMap<>();
        for(String[] rel:relation){
             StringBuilder sb =new StringBuilder();
            for(Integer num:nums){
               sb.append(rel[num]+" ");
                
            }
            
            if(map.containsKey(sb.toString()))return false;
                
                map.put(sb.toString(),true);
        }
        
        return true;
    }
    
    
    public void comb(int total,int idx,int num,int[] answer){//relation[0].length,0,num,new int[num]
        //0~total-1 에서 num개 뽑는 경우의수
        
        
        if(num==0){
            ArrayList<Integer> result = new ArrayList<>();
            
            for(int ans:answer){
                result.add(ans);
                
            }
            
            arr.add(result);
            return;
        }
        if(total==idx)return;
        
        
        answer[answer.length-num] = idx;
        comb(total,idx+1,num-1,answer);
        
        
        comb(total,idx+1,num,answer);
        
        
    }
}