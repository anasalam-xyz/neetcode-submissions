class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++) {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]) {
                int val = stack.poll();
                res[val] = i - val;
            }
            stack.push(i);
        }
        return res;
    }
}
