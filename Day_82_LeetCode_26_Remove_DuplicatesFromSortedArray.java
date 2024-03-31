class Solution {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 1)
            return nums.length;

        int left = 0;
        // 1 2 2 3 4 5 6
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != nums[left]) {
                left++;
                nums[left] = nums[right];
            }
            // System.out.print("left : "+left+ " val: " +nums[left]);
        }
        return left + 1;
    }
}
// TC: O(n)
// SC:O(1)