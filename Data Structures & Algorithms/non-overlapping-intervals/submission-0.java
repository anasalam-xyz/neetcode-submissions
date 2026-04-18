class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int res = 0;
        int prevEnd = intervals[0][1];

        for(int i = 1; i < n; i++) {
            int[] curr = intervals[i];
            if(curr[0] >= prevEnd) {
                prevEnd = curr[1];
            }
            else {
                prevEnd = Math.min(prevEnd, curr[1]);
                res++;
            }
        }

        return res;
    }
}
