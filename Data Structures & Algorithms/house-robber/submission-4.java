class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        if(len > 2) {
            nums[len - 3] += nums[len - 1];
            for(int i = len - 4; i >= 0; i--) {
                nums[i] += Math.max(nums[i+2], nums[i+3]);  
            } 
        }
        return Math.max(nums[0], nums[1]);
    }
}
