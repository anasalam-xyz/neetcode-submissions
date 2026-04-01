class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        for(int n: nums) {
            minHeap.offer(n);
            if(minHeap.size()>k)
                minHeap.poll();
        }
        return minHeap.poll();
    }
}
