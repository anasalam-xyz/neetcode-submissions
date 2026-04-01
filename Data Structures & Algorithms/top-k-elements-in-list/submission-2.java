class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[] res = new int[k];
        for(int n: nums)
            map.put(n, map.getOrDefault(n, 0)+1);
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            pq.offer(new int[] {entry.getValue(), entry.getKey()});
            if(pq.size()>k)
                pq.poll();
        }
        for(int i=0;i<k;i++)
            res[i] = pq.poll()[1];
        return res;
    }
}
