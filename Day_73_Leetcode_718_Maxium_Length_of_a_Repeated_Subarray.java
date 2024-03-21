//TC: O(M*N)
//SC: O(M*N)

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        // Base case
        if (nums1 == null || nums2 == null)
            return 0;

        int m = nums1.length, n = nums2.length, maxLen = 0;
        int[][] dp = new int[m + 1][n + 1];
        int endIndex = -1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                dp[i][j] = (nums1[i - 1] == nums2[j - 1]) ? dp[i - 1][j - 1] + 1 : 0;
                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    // endIndex =i-1; - to fidn the max subArray!
                }
            }
        }
        // int startIndex = (maxLen >endIndex) ? maxLen-endIndex +1 : endIndex - maxLen
        // +1;
        // System.out.println("Start: "+startIndex+ " End: "+endIndex+ " LEngth:
        // "+maxLen);

        return maxLen;
    }
}