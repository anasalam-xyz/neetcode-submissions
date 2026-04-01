class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        String res = "";
        for(int i = 0; i < len; i++) {
            String even = expand(i, i+1, s);
            String odd = expand(i, i, s);
            String temp = "";
            if(even.length() > odd.length())
                temp = even;
            else
                temp = odd;
            if(temp.length() > res.length())
                res = temp;
        }
        return res;
    }
    private String expand(int i, int j, String s) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
