class Solution {
    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int r=0;r<grid.length;r++) {
            for(int c=0;c<grid[0].length;c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, bfs(r, c, grid));
                }
            }
        }
        return maxArea;
    }
    private int bfs(int r, int c, int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        grid[r][c] = 0;
        int area = 1;
        while(!q.isEmpty()) {
            int[] coords = q.poll();
            for(int dir[]: directions) {
                r = coords[0]+dir[0];
                c = coords[1]+dir[1];
                if(r<0 || r>=grid.length || c<0 || c>=grid[0].length)
                    continue;
                if(grid[r][c] == 0)
                    continue;
                q.offer(new int[] {r, c});
                grid[r][c] = 0; 
                area++;   
            }
        }
        return area;
    }
}
