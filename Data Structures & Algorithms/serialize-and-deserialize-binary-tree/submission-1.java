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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            String s = "";
            if(node==null) {
                s = "N";
            }
            else {
                s = String.valueOf(node.val);
                q.offer(node.left);
                q.offer(node.right);
            }
            str.append(s).append('-');
        }
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        String[] tokens = data.split("-");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        q.offer(root);
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(!tokens[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(curr.left);
            }
            i++;
            if(!tokens[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(tokens[i]));
                q.offer(curr.right);
            }
            i++;
        }
        return root;
    }
}
