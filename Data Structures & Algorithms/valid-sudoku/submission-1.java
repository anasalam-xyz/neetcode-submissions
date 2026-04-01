class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> rowSet = new HashSet<>();
        HashSet<Character> colSet = new HashSet<>();
        HashMap<Integer,HashSet<Character>> boxSets = new HashMap<>();
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
                    int boxIndex = boxRow*10+boxCol;
                    if(!boxSets.containsKey(boxIndex))
                        boxSets.put(boxIndex, new HashSet<Character>());
                    if(boxSets.get(boxIndex).contains(rowEl)) return false;
                    boxSets.get(boxIndex).add(rowEl);
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
