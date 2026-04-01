class Solution {
    public int trap(int[] height) {
        int maxL = height[0];
        int maxR = height[height.length-1];
        int water = 0;

        int i = 0, j = height.length -1;
        while(i<j) {
            if(height[i]<height[j]) {
                water += (maxL-height[i])>0?(maxL-height[i]):0;
                maxL = Math.max(maxL, height[i]);
                i++;
            }
            else {
                water += (maxR-height[j])>0?(maxR-height[j]):0;
                 maxR = Math.max(maxR, height[j]);
                j--;
            }
        }
        return water;
    }
}
