class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int count1 = 1;
        int count2 = 0;
        for(int i = len - 1; i >= 0; i--) {
            int cur = 0;
            if(s.charAt(i) != '0') {
                cur = count1;
                if(i + 1 < len && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    cur += count2;
                }
            }
            count2 = count1;
            count1 = cur;
        }
        return count1;
    }
}
