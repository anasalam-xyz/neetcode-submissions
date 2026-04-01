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
        List<Integer> values = sorted(root, new ArrayList<>());
        return values.get(k-1);
    }
    private List<Integer> sorted(TreeNode root, List<Integer> list) {
        if(root==null) return list;
        sorted(root.left, list);
        list.add(root.val);
        sorted(root.right, list);
        return list;
    }
}
