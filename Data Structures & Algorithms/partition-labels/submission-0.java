class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] last = new int[26];
        for(int i = 0; i < n; i++)
            last[s.charAt(i) - 'a'] = i;

        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }
}
