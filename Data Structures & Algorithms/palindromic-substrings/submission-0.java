class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        for(int i = 0; i < len; i++) {
            int x = i;
            int y = i + 1;
            while(x >= 0 && y < len && s.charAt(x) == s.charAt(y)) {
                x--;
                y++;
                count++;
            }
            x = i;
            y = i;
            while(x >= 0 && y < len && s.charAt(x) == s.charAt(y)) {
                x--;
                y++;
                count++;
            }
        }
        return count;
    }
}
