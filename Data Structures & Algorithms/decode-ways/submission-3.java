class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        return dfs(0, s, dp);
    }
    private int dfs(int i, String s, int[] dp) {
        if(i >= s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != 0) return dp[i];
        
        int count = dfs(i + 1, s, dp);
        if(i + 1 < s.length()) {
            int num = Integer.parseInt(s.substring(i, i+2));
            if(num >=10 && num<=26) 
                count += dfs(i + 2, s, dp);
        }
        dp[i] = count;
        return count;
    }
}
