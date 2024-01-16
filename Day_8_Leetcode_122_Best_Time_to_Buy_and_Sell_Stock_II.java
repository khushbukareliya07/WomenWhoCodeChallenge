class Solution {
    public int maxProfit(int[] prices) {
        // base case
        if (prices == null || prices.length == 0)
            return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // compare with the prev calue
            if (prices[i] > prices[i - 1]) {
                int diff = prices[i] - prices[i - 1];
                profit += diff;
            }
        }
        return profit;
    }
}
