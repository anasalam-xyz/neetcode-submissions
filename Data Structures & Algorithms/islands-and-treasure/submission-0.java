class Solution {
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();

        for(int r = 0; r < grid.length; r++) {
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 0) {
                    q.offer(new int[] {r, c});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int[] dir: directions) {
                int nr = node[0] + dir[0];
                int nc = node[1] + dir[1];
                if(nr >= 0 && nr < grid.length && 
                    nc >= 0 && nc < grid[0].length && 
                    grid[nr][nc] == Integer.MAX_VALUE) {

                    grid[nr][nc] = grid[node[0]][node[1]] + 1;
                    q.offer(new int[] {nr, nc});
                }
            }
        }
    }
}
