class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1) return nums[0];
        return Math.max(calc(0, len-1, nums), calc(1, len, nums));
    }
    private int calc(int start, int end, int[] nums) {
        int rob1 = 0, rob2 = 0;
        for(int i = start; i < end; i++) {
            int temp = rob1;
            rob1 = Math.max(rob2 + nums[i], rob1);
            rob2 = temp;
        }
        return rob1;
    }
}
