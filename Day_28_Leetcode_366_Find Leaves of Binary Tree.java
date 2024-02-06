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

 //tc: O(n)
 //sc: O(h)
class Solution {
    int sum;
    List<List<Integer>> result;
    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();
        helper(root);
        return result;
    }
    private int helper(TreeNode root) {
        if(root == null)
            return 1;
             
       //recurse and get height of the root from both children
        int h1 = helper(root.left);
        int h2 = helper(root.right);
        
         //logic
        int height = Math.max(h1,h2); //For current Parent = max height from h1/h2 to add to level
        
        if(result.size() < height) {
            result.add(height-1, new ArrayList<>()); //if doesn't exist, we add new list
        }
        result.get(height-1).add(root.val);
        return height+1;
    }
}