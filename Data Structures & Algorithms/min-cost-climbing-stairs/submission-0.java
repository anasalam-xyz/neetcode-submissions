class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        return Math.min(dfs(0, n, cost, dp), dfs(1, n, cost, dp));
    }
    private int dfs(int i, int n, int[] cost, int[] dp) {
        if(i >= n) return 0;
        if(dp[i] != 0) return dp[i];
        dp[i] = cost[i] + Math.min(dfs(i+1, n, cost, dp), dfs(i+2, n, cost, dp));
        return dp[i];
    }
}
