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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        boolean[] flag = { true };
        dfs(root, flag);
        return flag[0];
    }
    public int dfs(TreeNode root, boolean[] flag) {
        if(root==null) return 0;
        int left = dfs(root.left, flag);
        int right = dfs(root.right, flag);
        if(Math.abs(left-right)>1)
            flag[0] = false;
        return 1+Math.max(left, right);
    }
}
