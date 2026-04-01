class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) 
            adj.add(new ArrayList<>());
        for(int[] flight: flights)  
            adj.get(flight[0]).add(new int[] {flight[1], flight[2]});

        int minCost = Integer.MAX_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a    [1])
        );
        pq.offer(new int[] {src, 0, 0}); 

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int cost = cur[1];
            int count = cur[2];
            if(node == dst)
                minCost = Math.min(minCost, cost);
            if(count > k)
                continue;
            for(int[] nei: adj.get(node)) {
                int neiDst = nei[0];
                int neiCost = nei[1];
                pq.offer(new int[] {neiDst, cost + neiCost, count + 1});
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }
}
