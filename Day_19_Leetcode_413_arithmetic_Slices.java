//Brute-force Approach
//take two for loops run over until found a breach, parallely, take a count variable
//increment the count
//TC: O(n*n)
//sc: O(1)

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // base case
        if (nums == null)
            return 0;
        int n = nums.length;
        int count = 0;

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] - nums[i - 1] == nums[j] - nums[j - 1]) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}

// DP Approach:
// Optimized DP Approach
// Start i running at 3rd element, index =2; check the diff; if matches, we
// bring the prev value, add 1, and add all to count!
// tc: O(n); sc: O(n)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // base case
        if (nums == null)
            return 0;
        int n = nums.length;

        // dp array
        int[] dp = new int[n];
        int count = 0;

        for (int i = 2; i < n; i++) // start the loop from 2nd index
        {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                count += dp[i];
            }
        }
        return count;
    }
}

// Optimized DP Approach
// Start i running at 3rd element, index =2; check the diff; if matches, we
// bring the prev value, add 1, and add all to count!
// same above approach with pace optimization, using just count and curr.
// tc: O(n); sc: O(1)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // base case
        if (nums == null)
            return 0;
        int n = nums.length;

        // dp array
        int count = 0;
        int curr = 0;

        for (int i = 2; i < n; i++) // start the loop from 2nd index
        {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                curr = curr + 1;
                count += curr;
            } else
                curr = 0;
        }
        return count;
    }
}