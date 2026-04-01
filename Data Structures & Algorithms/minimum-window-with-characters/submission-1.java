class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for(char c: t.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        int need = freq.size();
        int have = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        String res = "";
        int l = 0;
        for(int r=0;r<s.length();r++) {
            window.put(s.charAt(r), window.getOrDefault(s.charAt(r), 0)+1);
            if(window.get(s.charAt(r))==freq.get(s.charAt(r)))
                have++;
            while(have==need && l<=r) {
                String temp = s.substring(l, r+1);
                if(res.equals(""))
                    res = temp;
                else
                    if(temp.length()<res.length())
                        res = temp;
                if(window.get(s.charAt(l))==freq.get(s.charAt(l)))
                    have--;
                window.put(s.charAt(l), window.get(s.charAt(l))-1);
                l++;
            }
        }
        return res;
    }
}
