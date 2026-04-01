class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) 
            adj.add(new ArrayList<>());
        for(int[] edge: times)
            adj.get(edge[0]).add(new int[] {edge[1], edge[2]});
        
        int res =  0;
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[] {0, k});
        
        while(!pq.isEmpty()) {
            int[] edge = pq.poll();
            int dist = edge[0];
            int node = edge[1];
            if(visited.contains(node)) continue;
            visited.add(node);
            res = dist;
            for(int[] nei: adj.get(node)) {
                int ndist = nei[1];
                int next = nei[0];
                if(!visited.contains(next))
                    pq.offer(new int[] {dist + ndist, next});
            }
        }

        return (visited.size() == n)? res: -1;
    }
}
