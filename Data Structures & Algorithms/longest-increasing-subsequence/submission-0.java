class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i + 1; j < len; j++) {
                if(nums[i] < nums[j])
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
            }
        }
        int res = 1;
        for(int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
