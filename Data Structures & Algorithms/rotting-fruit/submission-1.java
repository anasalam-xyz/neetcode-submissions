class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        for(int r = 0; r < grid.length; r++)
            for(int c = 0; c < grid[0].length; c++)
                if(grid[r][c] == 2)
                    q.offer(new int[] {r, c});
                else if(grid[r][c] == 1)
                    count++;

        if(count == 0) return 0;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int minutes = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                for(int[] dir: directions) {
                    int r = node[0] + dir[0];
                    int c = node[1] + dir[1];
                    if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
                        continue;
                    if(grid[r][c] != 1)
                        continue;
                    grid[r][c] = 2;
                    q.offer(new int[] {r, c});
                    count--;
                }
            }
            minutes++;
        }
        if(count != 0)
            return -1;
        return minutes;
    }
}
