class Solution {
    private int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int r=0;r<grid.length;r++) {
            for(int c=0;c<grid[0].length;c++) {
                if(grid[r][c] == 1) {
                    maxArea = Math.max(maxArea, backtrack(r, c, grid));
                }
            }
        }
        return maxArea;
    }
    private int backtrack(int r, int c, int[][] grid) {
        if(r<0 || r>=grid.length || c<0 || c>= grid[0].length) {
            return 0;
        }
        if(grid[r][c] == 0) return 0;
        grid[r][c] = 0;
        int area = 1;
        for(int[] dir: directions) {
            area += backtrack(r+dir[0], c+dir[1], grid);
        }
        return area;
    }
}
