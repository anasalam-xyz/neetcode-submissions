class Solution {
    public int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()+1][word2.length()+1];
        return dfs(0, 0, word1, word2, dp);
    }
    private int dfs(int i, int j, String word1, String word2, Integer[][] dp) {
        if(i == word1.length() && j == word2.length())
            return 0;
        if(dp[i][j] != null) 
            return dp[i][j];
        if(i == word1.length())
            return 1 + dfs(i, j+1, word1, word2, dp);
        if(j == word2.length())
            return 1 + dfs(i+1, j, word1, word2, dp);
        
        dp[i][j] = 0;
        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] += dfs(i+1, j+1, word1, word2, dp);
        }
        else {
            dp[i][j] += 1 + Math.min(
                dfs(i+1, j, word1, word2, dp),
                Math.min(
                    dfs(i, j+1, word1, word2, dp),
                    dfs(i+1, j+1, word1, word2, dp)
                )
            );
        }

        return dp[i][j];
    }
}
