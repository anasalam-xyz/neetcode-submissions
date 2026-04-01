class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0, b = matrix.length - 1;
        int midRow = 0;
        while(t<=b) {
            midRow = t + (b-t/2);
            if(matrix[midRow][0] > target) 
                b = midRow - 1;
            else if(matrix[midRow][0] < target)
                t = midRow + 1;
            else 
                return true;
        }
        int l = 0, r = matrix[0].length - 1;
        while(l<=r) {
            int midCol = l + (r-l/2);
            if(matrix[midRow][midCol] > target) 
                r = midCol - 1;
            else if(matrix[midRow][midCol] < target)
                l = midCol + 1;
            else
                return true;
        }

        return false;
    }
}
