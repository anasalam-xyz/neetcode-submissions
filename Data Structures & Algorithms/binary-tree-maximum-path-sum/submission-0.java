/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxPathSum(TreeNode root) {
        int[] sum = new int[] {root.val};
        dfs(root, sum);
        return sum[0];
    }
    private int dfs(TreeNode root, int[] sum) {
        if(root==null) return 0;
        int leftMax = Math.max(dfs(root.left, sum), 0);
        int rightMax = Math.max(dfs(root.right, sum), 0);
        sum[0] = Math.max(sum[0], root.val+leftMax+rightMax);
        return root.val + Math.max(leftMax, rightMax);
    }
}
