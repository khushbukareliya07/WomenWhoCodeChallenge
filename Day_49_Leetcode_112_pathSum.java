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

/*
 * TC: O(n)
 * SC: O(h)
 */
class Solution {
    int target;
    boolean flag;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        this.target = targetSum;

        flag = false;
        dfs(root, 0);
        return flag;
    }

    private void dfs(TreeNode node, int ans) {
        // base case
        // System.out.println("Node : "+node.val);
        if (node.left == null && node.right == null) {
            if (ans + node.val == target)
                flag = true;
            return;
        }

        // logic
        int sum = ans + node.val;
        // System.out.println("Sum = "+sum+" ; ans : "+ans);

        // Recursion
        // left call
        if (!flag && node.left != null)
            dfs(node.left, sum);

        // right call
        if (!flag && node.right != null)
            dfs(node.right, sum);

        // backtracking
        ans = ans - node.val;
    }
}