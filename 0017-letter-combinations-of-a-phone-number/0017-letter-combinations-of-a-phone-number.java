class Solution {
    public List<String> letterCombinations(String digits) {
        char[][] numbers = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'}
        ,{'t','u','v'},{'w','x','y','z'}};

        List<String> answer = new ArrayList<>();

        backtracking(answer,numbers,new StringBuilder(),digits,0);

        return answer;
    }

    public void backtracking(List<String> answer, char[][] numbers, StringBuilder str, String digits, int idx){
        if(idx>= digits.length()){
            answer.add(str.toString());
            return;
        }
        
        int nowIdx = digits.charAt(idx)- '0';

        for(char number : numbers[nowIdx]){
            backtracking(answer,numbers,str.append(number),digits,idx+1);
            str.deleteCharAt(str.length()-1);
        }

    }
}