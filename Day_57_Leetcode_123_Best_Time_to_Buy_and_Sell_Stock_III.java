/*
Approach
Brute force:
1. Calculate two profits from 0 to i and i to n;save it to max.
2. ow perform same iteration from 1 to i+1; i+1 to n
3. Basically to find profit1 - n^2 loop && to find profit2 - n^2 loop
TC: O(n^4) SC: O(1)


//Optimized: 
Calculate transaction in one go
1. Calculate profit1, that will be in sell1. 
2. while purchasing for buy 2,consider investing previous profit ito buying price, 
3. now when we finally sell, the prices would have already covered the previous profit. 

TC: O(n)
SC: O(1)
*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length ==0) return 0;
        
        int buy1 = Integer.MAX_VALUE;
        int sell1 = 0;
        
        int buy2 = Integer.MAX_VALUE;
        int sell2 = 0;
        
        for(int i=0; i< prices.length; i++)
        {
            buy1 = Math.min(buy1, prices[i]); //incoming value and prev value
            sell1 = Math.max(sell1, prices[i]-buy1); //previous profit , or curent profit - take max value
            
            buy2 = Math.min(buy2, prices[i]-sell1); //prev buy2 or current - prev sold value/(curr - profit)
            sell2 =Math.max(sell2, prices[i]- buy2);
        }
        
        return sell2;
        
    }
}