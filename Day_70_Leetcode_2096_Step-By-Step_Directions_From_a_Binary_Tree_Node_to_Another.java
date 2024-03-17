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
1. Traverse from Root to start value and mark it as path1
2. Traverse from Root to desvalue and mark it as path2
3. Now traverse on path1 and path2
4. if their directions are same, "LRLL" and "LL" -> traverse until two character are different, change all direction to U in path1; and append the 2nd path from changedIndex to len.
5. path direction is anyway different from the begining, just change all characters to U and then append path2. 

TC: O(n) - 3 pass
sc: O(h) + O(n) - stack  + Strinbuilder 
*/
class Solution {
    StringBuilder path1, path2;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        //base case
        if(root ==null) return "";
        path1 = new StringBuilder();
        path2 = new StringBuilder();
        
        //step1 : find path1 to start value
        inOrder(root, startValue, new StringBuilder(), true, false);
        //step2: find path2 : dest value
        inOrder(root, destValue, new StringBuilder(), false, true);
        
//         System.out.println("path 1: "+path1.toString());
//         System.out.println("path 2: "+path2.toString());
        
        StringBuilder path =new StringBuilder();
        
        int i =0; 
        while(i<path1.length() && i < path2.length())
        {
            if(path1.charAt(i) != path2.charAt(i)) break;
            i++;
        }
        for(int j=i; j<path1.length(); j++)
        {
            path.append('U');
        }
        path.append(path2.substring(i));
        return path.toString().trim();
        
    }
    private void inOrder(TreeNode node, int value, StringBuilder path, boolean findPath1, boolean findPath2)
    {
        //System.out.println("CurrPath: "+path.toString());
        //base case
        if(node ==null) return;
        if(node.val == value)
        {
            if(findPath1)
            {
                path1 = new StringBuilder(path);
                
            }else
            {
                path2 = new StringBuilder(path);
            }
            return;
        }
        
       // int len = path.length();
        
        //logic
        inOrder(node.left, value, path.append("L"), findPath1, findPath2);
        //backtrackfrom left
        path.setLength(path.length() -1);
        
        inOrder(node.right, value, path.append("R"),findPath1, findPath2);
        //backtrack
        path.setLength(path.length() -1);
       
    }
}