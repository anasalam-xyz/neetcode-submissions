class Solution {
    public int maxArea(int[] heights) {
        int i=0, j=heights.length-1;
        int maxArea=0;
        while(i<j) {
            if(heights[i]<heights[j]) {
                int area = (j-i)*heights[i];
                maxArea = Math.max(area, maxArea);
                i++;
            }
            else {
                int area = (j-i)*heights[j];
                maxArea = Math.max(area, maxArea);
                j--;
            }
        }
        return maxArea;
    }
}
