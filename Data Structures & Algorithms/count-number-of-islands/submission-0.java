class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int r=0;r<grid.length;r++) 
            for(int c=0;c<grid[0].length;c++)
                if(grid[r][c]=='1') {
                    backtrack(r, c, grid);
                    islands++;
                }
        return islands;
    }
    private void backtrack(int r, int c, char[][] grid) {
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]=='0') {
            return;
        }
        grid[r][c] = '0';
        backtrack(r, c-1, grid);
        backtrack(r, c+1, grid);
        backtrack(r-1, c, grid);
        backtrack(r+1, c, grid);
    }
}
