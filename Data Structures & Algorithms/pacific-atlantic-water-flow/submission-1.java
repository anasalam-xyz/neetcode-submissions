class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS, COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];
        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, heights, pacific);
            dfs(r, COLS-1, heights, atlantic);
        }
        for(int c = 0; c < COLS; c++) {
            dfs(0, c, heights, pacific);
            dfs(ROWS-1, c, heights, atlantic);
        }
        for(int r = 0; r < ROWS; r++)
            for(int c = 0; c < COLS; c++)
                if(pacific[r][c] && atlantic[r][c])
                    res.add(new ArrayList<>(Arrays.asList(r, c)));
        return res;
    }
    private void dfs(int r, int c, int[][] heights, boolean[][] visited) {
        visited[r][c] = true;
        for(int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS || visited[nr][nc])
                continue;
            if(heights[nr][nc] >= heights[r][c]) 
                dfs(nr, nc, heights, visited);
        }
    }
}
