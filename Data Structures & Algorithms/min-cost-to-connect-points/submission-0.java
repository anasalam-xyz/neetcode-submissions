class Solution {
    public int minCostConnectPoints(int[][] points) {
        int len = points.length;
        Map<Point, PriorityQueue<int[]>> adj = new HashMap<>();
        for(int i = 0; i < len; i++) {
            int xi = points[i][0];
            int yi = points[i][1];
            Point key = new Point(xi, yi);
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[2]));
            for(int j = 0; j < len; j++) {
                if(i == j) continue;
                int xj = points[j][0];
                int yj = points[j][1];
                int dist = Math.abs((xi - xj)) + Math.abs((yi - yj));
                pq.offer(new int[] {xj, yj, dist});
            }
            adj.put(key, pq);
        }
        int cost = 0;
        Set<Point> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[2])
        );
        int start_x = points[0][0];
        int start_y = points[0][1];
        pq.offer(new int[] {start_x, start_y, 0});
        
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            Point p = new Point(cur[0], cur[1]);
            if(visited.contains(p)) continue;
            visited.add(p);
            cost += cur[2];
            for(int[] nei: adj.get(p)) {
                Point next = new Point(nei[0], nei[1]);
                if(visited.contains(next)) continue;
                pq.offer(nei);
            }
        }
        return cost;
    }
}

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Point)) return false;
        Point p = (Point) o;
        return p.x == x && p.y == y;
    }
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
