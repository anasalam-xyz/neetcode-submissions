class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        for(int[] p: points) {
            long dist = 1L*p[0]*p[0] + 1L*p[1]*p[1];
            maxHeap.offer(new long[] {dist, p[0], p[1]});
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        int[][] res = new int[k][2];
        for(int i=k-1;i>=0;i--) {
            long[] p = maxHeap.poll();
            res[i] = new int[] {(int)p[1], (int)p[2]};
        }
        return res;
    }
}
