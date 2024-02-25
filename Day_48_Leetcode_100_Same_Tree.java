//tc: O(2n)
//sc: O(2n)

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;

        Queue<TreeNode> q1 = new LinkedList<>();

        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode curr1 = q1.poll();
            TreeNode curr2 = q2.poll();

            if (curr1 != null && curr2 != null && curr1.val != curr2.val) {
                return false;
            } else if (curr1 != null && curr2 == null)
                return false;
            else if (curr1 == null && curr2 != null)
                return false;

            if (curr1 != null) {
                q1.add(curr1.left);
                q1.add(curr1.right);
            }
            if (curr2 != null) {
                q2.add(curr2.left);
                q2.add(curr2.right);
            }

        }
        return true;
    }
}
