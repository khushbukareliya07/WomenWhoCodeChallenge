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
//1. recurse through the left tree, and find the 0 case and 1 case at each node.
//2. repeat step 1 for right subtree.
//3. when return, 0 case lies on the 1st index of both left and right array
//4. 1 case lies on the sum of (max value of left, and max value of right)
//TC: O(n)
//sc:O(h)

class Solution {
    public int rob(TreeNode root) {
        
        //base case
        if(root == null) return 0;
       
       int[] result = new int[2];
        result = helper(root);
        
        return Math.max(result[0], result[1]);
    }
    
    private int[] helper(TreeNode node)
    {
        //base case
        if(node ==null) return new int[2];
        
        //logic
        
        //left tree
        int[] left = helper(node.left);
        //right tree
        int[] right = helper(node.right);
        
        //------------recursion ends----------
        
        int[] amount = new int[2];
        
        // 0case
        amount[0] = left[1] + right[1] + node.val;
        
        //1 case
        amount[1] = Math.max(left[0], left[1]) +  Math.max(right[0], right[1]);
        return amount;
        
    }
}