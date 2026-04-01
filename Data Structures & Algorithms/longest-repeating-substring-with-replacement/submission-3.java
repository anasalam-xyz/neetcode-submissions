class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int l = 0;
        int res = 0;
        int maxFreq = 0;
        for(int r=0;r<s.length();r++) {
            count.put(s.charAt(r), count.getOrDefault(s.charAt(r), 0) + 1);
            maxFreq = Math.max(maxFreq, count.get(s.charAt(r)));
            int length = r-l+1;
            if(length - maxFreq > k) {
                count.put(s.charAt(l), count.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }
        return res;
    }
}
