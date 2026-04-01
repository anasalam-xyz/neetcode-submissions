class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int ROWS, COLS;
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        boolean[][] visited = new boolean[ROWS][COLS];
        for(int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                if(board[r][c] == 'O' && !visited[r][c]) {
                    bfs(r, c, board, visited);
                }
            }
        }
    }
    private void bfs(int r, int c, char[][]board, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        List<int[]> pairs = new ArrayList<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;
        pairs.add(new int[] {r, c});
        boolean surrounded = true;
        while(!q.isEmpty()) {
            int[] node = q.poll();
            for(int[] dir: directions) {
                int nr = node[0] + dir[0];
                int nc = node[1] + dir[1];
                if(nr < 0 || nr >= ROWS || nc < 0 || nc >= COLS) {
                    surrounded = false;
                    continue;
                }
                if(board[nr][nc] == 'X' || visited[nr][nc])
                    continue;
                q.add(new int[] {nr, nc});
                visited[nr][nc] = true;
                pairs.add(new int[] {nr, nc});
            }
        }

        if(!surrounded) return;

        for(int[] pair: pairs) {
            board[pair[0]][pair[1]] = 'X';
        }
    }
}
