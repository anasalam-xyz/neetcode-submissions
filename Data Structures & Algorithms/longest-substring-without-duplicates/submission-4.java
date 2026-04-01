class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int l = 0, r = 0;
        int maxLen = 0;
        int len = 0;
        while(r<s.length()) {
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
                len = r-l;
            }
            set.add(s.charAt(r));
            r++;
            len++;
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
