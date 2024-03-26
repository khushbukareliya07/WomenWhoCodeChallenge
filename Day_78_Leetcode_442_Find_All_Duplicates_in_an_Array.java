/*Optimized
problem has occurrence of number as once or twice only.
For 0-based index array - we look t he value, go to index = value-1; and check if it's already -ve? add it to result, else mark it -ve!
TC: O(n)
SC: O(1)
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        if (nums.length <= 1)
            return result;

        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;

            // check index value is already negative?
            if (nums[index] < 0)
                result.add(index + 1);
            else
                nums[index] *= -1;
        }
        return result;
    }
}