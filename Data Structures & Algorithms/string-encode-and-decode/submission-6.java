class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        int n = str.length();
        int i = 0, j = 0;
        List<String> res = new ArrayList<>();

        while(i < n) {
            while(str.charAt(j) != '#')
                j++;

            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = j + len + 1;

            res.add(str.substring(i, j));
            i = j;
        }

        return res;
    }
}
