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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        sorted(root, values);
        return values.get(k-1);
    }
    private void sorted(TreeNode root, List<Integer> list) {
        if(root==null) return;
        sorted(root.left, list);
        list.add(root.val);
        sorted(root.right, list);
    }
}
