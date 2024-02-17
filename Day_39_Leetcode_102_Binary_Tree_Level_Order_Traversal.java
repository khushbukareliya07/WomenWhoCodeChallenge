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
 * tc: O(N)
 * SC: O(h)
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        // base case
        if (root == null)
            return result;

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int sizeQ = q.size();

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < sizeQ; i++) {
                TreeNode curr = q.poll();
                temp.add(curr.val);
                if (curr != null) {
                    if (curr.left != null)
                        q.add(curr.left);

                    if (curr.right != null)
                        q.add(curr.right);
                }
            }
            // level finsihed
            result.add(temp);
        }
        return result;
    }
}