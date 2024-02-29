
//Exhausted approach with PrevBuy Parameter that holds the price of the stock bought!
class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, -1, 0);
    }

    private int helper(int[] prices, int idx, int prevBuy, int profit) {

        // base case
        if (idx >= prices.length)
            return profit;

        // logic
        // buy states
        if (prevBuy == -1) {
            // dont choose
            int dontBuy = helper(prices, idx + 1, -1, profit);
            // choose
            int buy = helper(prices, idx + 1, prices[idx], profit);
            return Math.max(dontBuy, buy);

        } else // sell state
        {
            // don't sell
            int dontsell = helper(prices, idx + 1, prevBuy, profit);
            // sell
            int sell = helper(prices, idx + 2, -1, profit + prices[idx] - prevBuy);

            return Math.max(dontsell, sell);
        }
    }
}

// Exhausted approach with Flag parameter

class Solution {
    public int maxProfit(int[] prices) {
        return helper(prices, 0, false, 0);
    }

    private int helper(int[] prices, int idx, boolean flag, int profit) {

        // base case
        if (idx >= prices.length)
            return profit;

        // logic
        // buy states
        if (!flag) {
            // dont choose
            int dontBuy = helper(prices, idx + 1, false, profit);
            // choose
            int buy = helper(prices, idx + 1, true, profit - prices[idx]);
            return Math.max(dontBuy, buy);

        } else // sell state
        {
            // don't sell
            int dontsell = helper(prices, idx + 1, true, profit);
            // sell
            int sell = helper(prices, idx + 2, false, profit + prices[idx]);

            return Math.max(dontsell, sell);
        }
    }
}
