//TC:O(2 ^n)
//SC:O(h)

class Solution {
    int cap;

    public int minCapability(int[] nums, int k) {
        cap = Integer.MAX_VALUE;

        helper(nums, 0, k, max);
        return cap;
    }

    private void helper(int[] nums, int index, int steps, int max) {
        // base case
        if (index >= nums.length || steps == 0) {
            if (steps == 0)
                cap = Math.min(cap, max);
            return;
        }
        // logic
        // 0-case
        helper(nums, index + 1, steps, max);

        // 1 case
        helper(nums, index + 2, steps - 1, Math.max(max, nums[index]));
    }
}