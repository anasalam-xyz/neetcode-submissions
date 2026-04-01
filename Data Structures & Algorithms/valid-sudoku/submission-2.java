class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashSet<Character>[] boxSets = new HashSet[9];
        for(int i=0;i<9;i++)
            boxSets[i] = new HashSet<Character>();
        for(int i=0;i<9;i++) {
            rowSet.clear();
            colSet.clear();
            for(int j=0;j<9;j++) {
                char rowEl = board[i][j];
                char colEl = board[j][i];
                if(rowEl!='.') {
                    if(rowSet.contains(rowEl)) return false;
                    rowSet.add(rowEl);
                    int boxRow = i/3;
                    int boxCol = j/3;
                    int boxIndex = boxRow*3+boxCol;
                    if(boxSets[boxIndex].contains(rowEl)) return false;
                    boxSets[boxIndex].add(rowEl);
                }
                if(colEl!='.') {
                    if(colSet.contains(colEl)) return false;
                    colSet.add(colEl);
                }
            }
        }
        return true;
    }
}
