class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int idx = 0 ;idx<temperatures.length;idx++){
            int temperature= temperatures[idx];

            while(!stack.isEmpty()&&temperatures[stack.peek()]<temperature){
                answer[stack.peek()] = idx-stack.pop();
            }
            stack.push(idx);
        }

        return answer;
    }


}