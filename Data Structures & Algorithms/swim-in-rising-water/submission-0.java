class Solution {
    int ROWS, COLS;
    public int swimInWater(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        Set<Integer> visited = new HashSet<>();
        int time = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> grid[a[0]][a[1]])
        );
        pq.offer(new int[] {0, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int index = i * COLS + j;
            if(visited.contains(index))
                continue;
            visited.add(index);
            time = Math.max(time, grid[i][j]);
            if(i == ROWS-1 && j == COLS-1)
                return time;
            for(int[] dir: directions) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni < 0 || nj < 0 || ni >= ROWS || nj >= COLS)
                    continue;
                pq.offer(new int[] {ni, nj});
            }
        }
        return time;
    }
}
