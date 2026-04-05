class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length][2];
        return dfs(0, prices, 1, dp);
    }
    private int dfs(int i, int[] prices, int canBuy, Integer[][] dp) {
        if(i >= prices.length) return 0;
        if(dp[i][canBuy] != null) return dp[i][canBuy];
        if(canBuy == 1) {
            dp[i][canBuy] = Math.max(
                dfs(i+1, prices, 0, dp) - prices[i],
                dfs(i+1, prices, 1, dp)
            );
        }
        else {
            dp[i][canBuy] = Math.max(
                prices[i] + dfs(i+2, prices, 1, dp),
                dfs(i+1, prices, 0, dp)
            );
        }
        return dp[i][canBuy];
    }
}
