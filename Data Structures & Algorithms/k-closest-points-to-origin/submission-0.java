class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        for(int[] p: points)
            minHeap.offer(new Pair(p, Math.sqrt(p[0]*p[0] + p[1]*p[1])));
        int[][] res = new int[k][2];
        for(int i=0;i<k;i++)
            res[i] = minHeap.poll().getKey();
        return res;
    }
}

class Pair implements Comparable<Pair> {
    private int[] key;
    private double value;
    Pair(int[] key, double value) {
        this.key = key;
        this.value = value;
    }
    public int[] getKey() {
        return key;
    }
    public double getValue() {
        return value;
    }

    @Override
    public int compareTo(Pair other) {
        return Double.compare(this.value, other.value);
    }
}