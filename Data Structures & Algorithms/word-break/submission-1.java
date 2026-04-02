class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        for(String word: wordDict)
            dict.add(word);
        return dfs(0, s, dict, new Boolean[s.length()]);
    }
    private boolean dfs(int start, String s, Set<String> dict, Boolean[] dp) {
        int len = s.length();
        if(start >= len) return true;
        if(dp[start] != null) return dp[start];
        StringBuilder sb = new StringBuilder();
        for(int i = start; i < len; i++) {
            sb.append(s.charAt(i));
            if(dict.contains(sb.toString())) {
                if(dfs(i + 1, s, dict, dp)) {
                    dp[start] = true;
                    return dp[start];
                }
            }
        }
        dp[start] = false;
        return dp[start];
    }
}
