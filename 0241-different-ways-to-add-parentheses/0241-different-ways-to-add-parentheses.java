class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> answer = new ArrayList<>();
        for(int idx = 0; idx<expression.length(); idx++){

            char ch = expression.charAt(idx);

            if(ch =='+' || ch=='-' || ch == '*'){
                List<Integer> leftArr = diffWaysToCompute(expression.substring(0,idx));
                List<Integer> rightArr = diffWaysToCompute(expression.substring(idx+1));
                for(int leftNum : leftArr){
                    for(int rightNum: rightArr){
                        if(ch =='+') answer.add(leftNum+rightNum);
                        if(ch =='-') answer.add(leftNum-rightNum);
                        if(ch=='*')answer.add(leftNum*rightNum);
                    }
                }
            }

        }
        if(answer.isEmpty())answer.add(Integer.parseInt(expression));
        return answer;
    }
}