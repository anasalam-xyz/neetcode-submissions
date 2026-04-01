class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, board, visited);
            dfs(r, COLS-1, board, visited);
        }
        for(int c = 0; c < COLS; c++) {
            dfs(0, c, board, visited);
            dfs(ROWS-1, c, board, visited);
        }
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(!visited[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }
    private void dfs(int r, int c, char[][] board, boolean[][] visited) {
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS)
            return;
        if(visited[r][c] || board[r][c] == 'X')    
            return;
        visited[r][c] = true;
        for(int dir[]: directions) {
            dfs(r + dir[0], c + dir[1], board, visited);
        }
    }
}
