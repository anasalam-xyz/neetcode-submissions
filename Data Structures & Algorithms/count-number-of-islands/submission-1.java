class Solution {
    private static final int[][] directions = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int r=0;r<grid.length;r++) 
            for(int c=0;c<grid[0].length;c++)
                if(grid[r][c]=='1') {
                    bfs(r, c, grid);
                    islands++;
                }
        return islands;
    }
    private void bfs(int r, int c, char[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {r, c});
        grid[r][c] = '0';
        while(!q.isEmpty()) {
            int[] coords = q.poll();
            for(int dir[]: directions) {
                r = coords[0]+dir[0];
                c = coords[1]+dir[1];
                if(r<0 || r>=grid.length || c<0 || c>=grid[0].length)
                    continue;
                if(grid[r][c] == '0')
                    continue;
                q.offer(new int[] {r, c});
                grid[r][c] = '0';    
            }
        }
    }
}
