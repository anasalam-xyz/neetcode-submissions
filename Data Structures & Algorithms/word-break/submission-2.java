class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[len + 1];
        dp[len] = true;
        
        for(int i = len - 1; i >= 0; i--) {
            for(String word: wordDict) {
                int wLen = word.length();
                if(i + wLen <= len
                    && s.substring(i, i + wLen).equals(word)) {
                    dp[i] = dp[i + wLen];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}
