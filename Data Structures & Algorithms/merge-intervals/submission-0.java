class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> res = new ArrayList<>();
        int[] prev = null;
        for(int[] interval: intervals) {
            if(prev == null || prev[1] < interval[0]) {
                res.add(interval);
                prev = interval;
            }
            else if(prev[1] >= interval[0]) {
                prev[0] = Math.min(prev[0], interval[0]);
                prev[1] = Math.max(prev[1], interval[1]);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
