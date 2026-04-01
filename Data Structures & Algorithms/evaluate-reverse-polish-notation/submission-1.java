class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(String token: tokens) {
            if(token.equals("+"))
                stack.push(stack.pop()+stack.pop());
            else if(token.equals("-")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y-x);
            }
            else if(token.equals("*"))
                stack.push(stack.pop()*stack.pop());
            else if(token.equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y/x);
            }
            else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
