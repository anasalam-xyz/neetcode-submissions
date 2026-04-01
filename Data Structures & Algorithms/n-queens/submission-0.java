class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, new boolean[n], new boolean[n*2-1], new boolean[n*2-1], new ArrayList<>(), res);
        return res;
    }
    private void backtrack(int row, int n, boolean[] cols, boolean[] diag1, boolean[] diag2, List<String> curr, List<List<String>> res) {
        if(row >= n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int col=0;col<n;col++) {
            if(cols[col] || diag1[row+col] || diag2[n-row+col-1]) 
                continue;
            cols[col] = true;
            diag1[row+col] = true;
            diag2[n-row+col-1] = true;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++)
                if(i == col)
                    sb.append("Q");
                else
                    sb.append(".");
            curr.add(sb.toString());
            backtrack(row+1, n, cols, diag1, diag2, curr, res);
            curr.remove(curr.size()-1);
            cols[col] = false;
            diag1[row+col] = false;
            diag2[n-row+col-1] = false;
        }
    }
}
