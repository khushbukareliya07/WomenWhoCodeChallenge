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

//Level Order traversal
//add the final list at the 0th Index!
//Tc: O(n)
//SC: O(n)
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //base case
        if(root ==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> level = new ArrayList<>(); 
            for(int i=0; i<size; i++)
            {
                TreeNode curr = q.poll();
                level.add(curr.val);
                
                if(curr.left != null)
                    q.add(curr.left);
                if(curr.right != null)
                    q.add(curr.right);
            }
            result.add(0,level);
        }
        return result;
    }
}