class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            int temp = temperatures[i];
            if(!stack.isEmpty())
                if(temp<=temperatures[stack.peek()])
                    stack.push(i);
                else {
                    res[stack.peek()] = i - stack.pop();
                    i--;
                }
            else
                stack.push(i);
        }
        return res;
    }
}
