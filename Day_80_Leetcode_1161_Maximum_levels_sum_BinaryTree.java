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

//Simple BFS traversal
//max sum, when it's tie - return the smallest level.
class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        
        int level=1;
        int maxSum =0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        level =1;
        maxSum = root.val;
        int currLevel =1;
        while(!q.isEmpty())
        {
            int size = q.size();
            
            int sum =0;
            for(int i=0;i < size; i++)
            {
                TreeNode curr = q.poll();
                sum+= curr.val;
                
                if(curr.left != null)
                    q.add(curr.left);
                
                if(curr.right != null)
                    q.add(curr.right);
            }
            // System.out.print("Sum : "+sum+ " level: "+level);
            if(sum >maxSum) {
                level = currLevel;
                maxSum = sum;
            }
            currLevel++;
        }
        return level;
    }
}