class MinStack {

    Deque<Integer> stack;
    Deque<Integer> min;
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(min.isEmpty())
            min.push(val);
        else
            if(val<=min.peek())
                min.push(val);
    }
    
    public void pop() {
        if(stack.pop().equals(min.peek()))
            min.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        if(min.isEmpty())
            return Integer.MIN_VALUE;
        return min.peek();
    }
}
