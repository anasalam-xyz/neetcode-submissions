class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int h: hand) {
            if(freq.containsKey(h)) {
                freq.put(h, freq.get(h) + 1);
            }
            else {
                freq.put(h, 1);
                minHeap.offer(h);
            }
        }

        while(!minHeap.isEmpty()) {
            int start = minHeap.peek();
            for(int i = start; i < start + groupSize; i++) {
                if(!freq.containsKey(i))
                    return false;
                freq.put(i, freq.get(i) - 1);
                if(freq.get(i) == 0) {
                    if(i != minHeap.peek())
                        return false;
                    minHeap.poll();
                }
            }
        }
        
        return true;
    }
}
