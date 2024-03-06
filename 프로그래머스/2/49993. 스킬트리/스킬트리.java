class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0 ;
        for(String skill_tree: skill_trees){
            int preIdx=0;
            for(int idx =0 ;idx<skill_tree.length();idx++){
                if(skill.indexOf(skill_tree.charAt(idx))>preIdx){
                    break;
                    
                }
                
                if(skill.contains(String.valueOf(skill_tree.charAt(idx))))
                        preIdx++;
                
                if(idx==skill_tree.length()-1)
                    answer++;
            }
        }
        return answer;
    }
}