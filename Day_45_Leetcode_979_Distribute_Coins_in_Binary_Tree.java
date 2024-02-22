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
/*
Approach : 
1. To get the coins available we have go to the leaf nodes and find the available coins
2. Once we reach the null, we return zero. 
3. UCrrent Node will have 1 coin, so extra coins will be node.val -1
4. Now, when we go back from child to parent, whatever available coins are shows the total coins, but that is smething also shows the moves we are doing. 
5. If we are passing down 2 extra coins from child to parent, we' make two moves. 
TC: O(n)
SC: O(h)
*/
class Solution {
    int moves =0;
    public int distributeCoins(TreeNode root) {
        if(root == null) return 0;
        
        dfs(root);
        return moves;
    }
    private int dfs(TreeNode node)
    {
        //base case
        if(node == null) return 0;
       
        //logic
        //take current value of the node
        int coins = node.val -1;
        
        //recursion
        int coinsFromLeft = dfs(node.left);
        int coinsFromRight = dfs(node.right);
        
        int total = coinsFromLeft + coinsFromRight + coins;
        moves += Math.abs(total);
        
        return total;
    }
}