class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int m = intervals.length;
        int n = queries.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] q = new int[n][2];
        for(int i = 0; i < n; i++) {
            q[i][0] = i;
            q[i][1] = queries[i];
        }
        Arrays.sort(q, Comparator.comparingInt(a -> a[1]));

        int[] res = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[1] - a[0])
        );
        int i = 0;
        for(int[] query: q) {
            while(i < m && intervals[i][0] <= query[1]) 
                pq.offer(intervals[i++]);
            while(!pq.isEmpty() && pq.peek()[1] < query[1])
                pq.poll();
            if(pq.isEmpty())
                res[query[0]] = -1;
            else 
                res[query[0]] = pq.peek()[1] - pq.peek()[0] + 1;
        }
        
        return res;
    }
}
