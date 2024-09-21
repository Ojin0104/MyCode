class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(String token: tokens){
            if(isNumber(token)){
                stack.addLast(Integer.parseInt(token));
            }else{
                if(token.equals("+")){
                    int num2 = stack.pollLast();
                    int num = stack.pollLast();

                    stack.addLast(num+num2);
                }

                if(token.equals("*")){
                    int num2 = stack.pollLast();
                    int num = stack.pollLast();

                    stack.addLast(num*num2);
                }

                if(token.equals("-")){
                    int num2 = stack.pollLast();
                    int num = stack.pollLast();

                    stack.addLast(num-num2);
                }

                if(token.equals("/")){
                    int num2 = stack.pollLast();
                    int num = stack.pollLast();
                    stack.addLast(num/num2);
                }
            }
        }

        return stack.pop();


    }

    static boolean isNumber(String str){
        if(str.equals("*")||str.equals("+")||str.equals("-")||str.equals("/"))return false;
        return true;
    }
}