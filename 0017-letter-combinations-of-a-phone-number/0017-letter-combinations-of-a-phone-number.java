class Solution {
    private static final List<String>[] CHAR_LIST = new List[10];
    
    static {
        CHAR_LIST[0] = Arrays.asList();
        CHAR_LIST[1] = Arrays.asList();
        CHAR_LIST[2] = Arrays.asList("a", "b", "c");
        CHAR_LIST[3] = Arrays.asList("d", "e", "f");
        CHAR_LIST[4] = Arrays.asList("g", "h", "i");
        CHAR_LIST[5] = Arrays.asList("j", "k", "l");
        CHAR_LIST[6] = Arrays.asList("m", "n", "o");
        CHAR_LIST[7] = Arrays.asList("p", "q", "r","s");
        CHAR_LIST[8] = Arrays.asList("t", "u", "v");
        CHAR_LIST[9] = Arrays.asList("w", "x", "y", "z");
    }
    
    public List<String> letterCombinations(String digits) {
        
        List<String> answer = new ArrayList<>();
        if(digits.isBlank())return answer;
        backtracking(digits,0, answer, new StringBuilder());
        return answer;
    }

    public void backtracking(String digits,int idx, List<String> answer, StringBuilder str){
        if(idx == digits.length()){
            answer.add(str.toString());
            return;
        }
        int num = digits.charAt(idx) - '0';
        for(String character: CHAR_LIST[num]){
            backtracking(digits,idx+1,answer, str.append(character));
            str.deleteCharAt(str.length()-1);
        }
    }
}