class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        while(left < right && top < bottom) {
            for(int i = left; i < right; i++)
                res.add(matrix[top][i]);
            for(int i = top; i < bottom; i++)
                res.add(matrix[i][right]);
            for(int i = right; i > left; i--)
                res.add(matrix[bottom][i]);
            for(int i = bottom; i > top; i--)
                res.add(matrix[i][left]);
            
            left++;
            right--;
            top++;
            bottom--;
        }
         if(left == right) {
            for(int i = top; i <= bottom; i++)
                res.add(matrix[i][right]);
        }
        else if(top == bottom) {
            for(int i = left; i <= right; i++)
                res.add(matrix[top][i]);
        }

        return res;
    }
}
