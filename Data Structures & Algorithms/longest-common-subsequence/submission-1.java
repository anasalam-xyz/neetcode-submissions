class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();
        Integer[][] dp = new Integer[len1][len2];
        dfs(0, 0, text1, text2, dp);
        return dp[0][0];
    }
    private int dfs(int i, int j, String text1, String text2, Integer[][] dp) {
        if(i == text1.length() || j == text2.length())
            return 0;
        if(dp[i][j] != null) return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + dfs(i+1, j+1, text1, text2, dp);
        }
        else {
            dp[i][j] = Math.max(
                dfs(i, j+1, text1, text2, dp), 
                dfs(i+1, j, text1, text2, dp)
            );
        }
        return dp[i][j]; 
    }
}
