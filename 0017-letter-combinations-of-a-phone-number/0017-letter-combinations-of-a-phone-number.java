class Solution {
    public List<String> letterCombinations(String digits) {
        String[] str = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> answer = new ArrayList<>();
        List<String> lst = new ArrayList<String>();
        for(int idx = 0 ;idx<digits.length();idx++){
            char choice = digits.charAt(idx);
            if(idx==0){
                for(int i = 0 ;i<str[choice-'0'].length();i++){
                    char ch = str[choice-'0'].charAt(i);
                    lst.add(ch+"");
                }
                    continue;
                }
            answer = lst;
            lst = new ArrayList<String>();
            
            for(String s: answer){
                for(int i = 0 ;i<str[choice-'0'].length();i++){
                    char ch = str[choice-'0'].charAt(i);
                    lst.add(s+ch);
                }
            }

        }

        return lst;


    }
}