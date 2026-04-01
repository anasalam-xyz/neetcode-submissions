class Solution {
    public int maxArea(int[] heights) {
        int i=0, j=heights.length-1;
        int area=0, maxArea=0;
        while(i<j) {
            if(heights[i]<heights[j]) {
                area = (j-i)*heights[i];
                i++;
            }
            else {
                area = (j-i)*heights[j];
                j--;
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
