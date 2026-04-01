class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];
        int max = -Integer.MAX_VALUE;
        for(int i=0;i<nums.length-k+1;i++) {
            for(int j=0;j<k;j++) 
                max = Math.max(max, nums[i+j]);
            res[i] = max;
            max = -Integer.MAX_VALUE;
        }
        return res;
    }
}
