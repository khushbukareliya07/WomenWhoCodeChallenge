// TC: O(N)
// SC: O(h)    
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int count;

    public int goodNodes(TreeNode root) {

        // base case
        if (root == null)
            return 0;

        count = 0;
        // int max = root.val;
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode node, int max) {
        // base case

        if (node == null)
            return;

        // logic
        if (node.val >= max) {
            count++;
            max = node.val;
        }

        // left
        dfs(node.left, max);
        // right
        dfs(node.right, max);
    }
}