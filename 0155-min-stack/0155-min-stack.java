class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> min;

    public MinStack() {
        stack = new ArrayList<>();
        min = new ArrayList<>();
    }
    
    public void push(int val) {

        stack.add(val);
        if(min.size()==0 ||min.get(min.size()-1)>val){
            min.add(val);
        }else{
            min.add(min.get(min.size()-1));
        }
        
    }
    
    public void pop() {
        if(stack.isEmpty())return;
        min.remove(min.size()-1);
        stack.remove(stack.size()-1);
    }
    
    public int top() {
         if(stack.isEmpty())return 0;
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        if(stack.isEmpty())return 0;
        return min.get(min.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */