class Solution {
    public int trap(int[] height) {
        int maxL = height[0];
        int maxR = height[height.length-1];
        int water = 0;

        int i = 0, j = height.length -1;
        while(i<j) {
            if(height[i]<height[j]) {
                maxL = Math.max(maxL, height[i]);
                water += maxL-height[i];
                i++;
            }
            else {
                maxR = Math.max(maxR, height[j]);
                water += maxR - height[j];
                j--;
            }
        }
        return water;
    }
}
