class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        makeParentheses(answer, 0,sb, n);

        return answer;
    }

    public void makeParentheses(List<String> answer, int leftNum, StringBuilder sb,  int target){
        if(sb.length()== target*2){
            answer.add(sb.toString());
            return;
        }
        
        if(leftNum>0){
            sb.append(")");
            makeParentheses(answer,leftNum-1,sb,target);
            sb.setLength(sb.length() - 1); 
        }

        if(leftNum+sb.length()<target*2){
            sb.append("(");
            makeParentheses(answer,leftNum+1,sb,target);
            sb.setLength(sb.length() - 1); 
        }




    }
}