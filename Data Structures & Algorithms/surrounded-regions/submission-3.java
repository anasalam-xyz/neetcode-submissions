class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        for(int r = 0; r < ROWS; r++) {
            dfs(r, 0, board);
            dfs(r, COLS-1, board);
        }
        for(int c = 0; c < COLS; c++) {
            dfs(0, c, board);
            dfs(ROWS-1, c, board);
        }
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == 'O')
                    board[r][c] = 'X';
                else if(board[r][c] == 'T')
                    board[r][c] = 'O';
            }
        }
    }
    private void dfs(int r, int c, char[][] board) {
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS)
            return;
        if(board[r][c] != 'O')    
            return;
        board[r][c] = 'T';
        for(int dir[]: directions) {
            dfs(r + dir[0], c + dir[1], board);
        }
    }
}
