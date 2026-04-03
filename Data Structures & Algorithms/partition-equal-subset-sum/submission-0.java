class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int n: nums) total += n;
        if(total % 2 == 1) return false;
        Boolean dp[][] = new Boolean[nums.length][total/2 + 1];
        return dfs(0, nums, total/2, dp);
    }
    private boolean dfs(int i, int[] nums, int sum, Boolean[][] dp) {
        if(sum == 0) return true;
        if(sum < 0) return false;
        if(i >= nums.length) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        dp[i][sum] = (
            dfs(i+1, nums, sum-nums[i], dp) ||
            dfs(i+1, nums, sum, dp)
        );
        return dp[i][sum];
    }
}
