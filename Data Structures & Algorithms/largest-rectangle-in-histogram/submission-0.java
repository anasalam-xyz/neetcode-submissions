class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++) {
            int index = i;
            while(!stack.isEmpty() && heights[i]<stack.peek()[1]) {
                int[] pair = stack.pop();
                int area = pair[1] * (i - pair[0]);
                maxArea = Math.max(maxArea, area);
                index = pair[0];
            }
            stack.push(new int[]{index, heights[i]});
        }
        while(!stack.isEmpty()) {
            int[] pair = stack.pop();
            int area = pair[1] * (heights.length - pair[0]);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
