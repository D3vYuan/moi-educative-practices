package com.solution.SlidingWindow;

public class BestTimeToBuyAndSellStock {

    /**
     * 
     * 
     * Strategy
     * [1] Initialize buy and sell pointers to 0 and 1, respectively, and set the
     * maximum profit variable to
     * [2] Iterate the sell pointer over the prices, computing the current profit by
     * subtracting the prices[buy] from the prices[sell].
     * [3] If prices[buy] is less than prices[sell], choose the maximum value from
     * current profit or maximum profit and store it in the maximum profit.
     * Otherwise, update buy to be equal to sell.
     * [4] Once the sell pointer reaches the end, return the maximum profit.
     */

    public static int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while (sell < prices.length) {
            // Calculating the current profit
            int currentProfit = prices[sell] - prices[buy];

            // Setting the maximum profit if price at sell pointer is greater than buy
            if (prices[buy] < prices[sell]) {
                maxProfit = Math.max(currentProfit, maxProfit);
            } else {
                // Otherwise, update buy to be equal to sell
                buy = sell;
            }

            // Moving sell pointer to the next index of the prices array
            sell++;
        }

        return -1;
    }
}
