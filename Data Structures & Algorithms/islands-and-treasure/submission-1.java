class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[ROWS][COLS];
        Queue<int[]> q = new ArrayDeque<>();

        for(int i = 0; i < ROWS; i++)
            for(int j = 0; j < COLS; j++) 
                if(grid[i][j] == 0)
                    q.offer(new int[] {i, j, 0});

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int dist = node[2];
            for(int[] dir: directions) {
                int nr = node[0] + dir[0];
                int nc = node[1] + dir[1];
                if(nr < 0 || nc < 0 || nr >= ROWS || nc >= COLS || grid[nr][nc] != Integer.MAX_VALUE || visited[nr][nc])
                    continue;
                q.offer(new int[] {nr, nc, dist + 1});
                grid[nr][nc] = dist + 1;
                visited[nr][nc] = true;
            }
        }
    }
}
