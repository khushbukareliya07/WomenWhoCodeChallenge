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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // base case
        if (preorder.length == 0 || inorder.length == 0)
            return null;

        int rootVal = preorder[0];
        // look for root index in inorder
        int rIdx = -1;

        // tc: O(n)
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal)
                rIdx = i;
        }
        // build a root node
        TreeNode root = new TreeNode(rootVal);

        // constructing left and right subtrree arrays
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rIdx + 1, inorder.length);

        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, inLeft.length + 1, preorder.length);

        // assign left and right subtree with recursive calls
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);

        return root;
    }
}