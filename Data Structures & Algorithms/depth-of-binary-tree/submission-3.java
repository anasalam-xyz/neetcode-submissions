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
    public int maxDepth(TreeNode root) {
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair<>(root, 1));
        int res = 0;
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int depth = current.getValue();
            if(node!=null) {
                res = Math.max(res, depth);
                stack.push(new Pair<>(node.left, depth+1));
                stack.push(new Pair<>(node.right, depth+1));
            }
        }
        return res;
    }
}

private static class Pair<K, V> {
    private final K key;
    private final V value;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    K getKey() {
        return key;
    }
    V getValue() {
        return value;
    }
}
