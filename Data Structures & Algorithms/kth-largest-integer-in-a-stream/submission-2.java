class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int size;
    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>();
        size = k;
        for(int n: nums)
            minHeap.offer(n);
        while(minHeap.size()>k)
            minHeap.poll();
    }
    
    public int add(int val) {
        if(minHeap.size()<size) {
            minHeap.offer(val);
        }
        else {
            if(minHeap.peek()<val) {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        return minHeap.peek();
    }
}
