class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c: s1.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0)+1);
        int l=0;
        for(int r=0;r<s2.length();r++) {
            if(r-l+1>s1.length()) {
                if(window.get(s2.charAt(l))>0) {
                    window.put(s2.charAt(l), window.get(s2.charAt(l))-1);
                    l++;
                }
            }
            if(freq.containsKey(s2.charAt(r))) {
                window.put(s2.charAt(r), window.getOrDefault(s2.charAt(r), 0)+1);
            }
            else {
                window.clear();
                l=r+1;
            }
            if(window.equals(freq))
                return true;
        }
        return false;
    }
}
