class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(dfs(0, nums, dp), dfs(1, nums, dp));
    }
    private int dfs(int i, int[] nums, int[] dp) {
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        dp[i] = nums[i] + Math.max(dfs(i + 2, nums, dp), dfs(i + 3, nums, dp));
        return dp[i];
    }
}
