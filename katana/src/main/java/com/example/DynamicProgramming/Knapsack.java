package com.example.DynamicProgramming;

import java.util.Arrays;

public class Knapsack {
    /**
     * You are given n items whose weights and values are known, as well as a
     * knapsack to carry these items. The knapsack cannot carry more than a certain
     * maximum weight, known as its capacity.
     * You need to maximize the total value of the items in your knapsack, while
     * ensuring that the sum of the weights of the selected items does not exceed
     * the capacity of the knapsack.
     * If there is no combination of weights whose sum is within the capacity
     * constraint, return
     * 
     * Strategy
     * [1] Create a 2D table to store the maximum profit for each item and capacity.
     * [2] Initialize the table with 0s for the first row and column to handle base
     * cases.
     * [3] Iterate over the remaining rows and columns of the table, filling them in
     * based on whether the weight of an item is less than or equal to the current
     * capacity.
     * [4] If the weight is less than or equal to the current capacity, use the
     * maximum value that can be obtained by either including or excluding the item.
     * Otherwise, exclude the item and use the previous best value at that capacity.
     * [5] Return the value in the last row and column of the table, which
     * represents the maximum value that can be obtained with the given capacity and
     * items.
     */

    int[][] memo;

    public Knapsack() {

    }

    private int findMaxBottomUp(int capacity, int[] weights, int[] values) {
        // Create a table to hold intermediate values
        int itemsAvailable = weights.length;
        int[][] dp = new int[itemsAvailable + 1][capacity + 1];
        for(int[] row:dp) {
            Arrays.fill(row, 0);
        }

        for (int row = 1; row <= itemsAvailable; row++) {
            for (int col = 1; col <= capacity; col++) {
                // Check if the weight of the current item is less than the current capacity
                if (weights[row - 1] <= col){
                    dp[row][col] = Math.max(values[row - 1] + dp[row - 1][col - weights[row - 1]], 
                        dp[row - 1][col]);
                } else {
                    dp[row][col] = dp[row - 1][col];
                }
            }
        }
        return dp[itemsAvailable][capacity];
    }

    private int findMaxTopDown(int remainingCapacity, int itemsAvailable, int[] weights, int[] values) {
        // Base Case
        if (remainingCapacity == 0 || itemsAvailable == 0) {
            return 0;
        }

        // Case already exists in memo
        if (memo[itemsAvailable][remainingCapacity] != -1) {
            return memo[itemsAvailable][remainingCapacity];
        }

        // If the weight of the nth item is less than capacity, then:
        // We either include the item and deduct the weight of the item from the
        // knapsack capacity (to get the remaining capacity)
        // or we don't include the item at all.
        // We pick the option that yields the highest value.
        if (weights[itemsAvailable - 1] <= remainingCapacity) {
            memo[itemsAvailable][remainingCapacity] = Math.max(
                    values[itemsAvailable - 1] + findMaxTopDown(remainingCapacity - weights[itemsAvailable - 1],
                            itemsAvailable - 1, weights, values),
                    findMaxTopDown(remainingCapacity, itemsAvailable - 1, weights, values));

            return memo[itemsAvailable][remainingCapacity];
        }

        memo[itemsAvailable][remainingCapacity] = findMaxTopDown(remainingCapacity, itemsAvailable - 1, weights,
                values);
        return memo[itemsAvailable][remainingCapacity];
    }

    public int findMaxKnapsackProfit(int capacity, int[] weights, int[] values) {
        // Replace this placeholder return statement with your code
        int itemsAvailable = values.length;
        memo = new int[values.length + 1][capacity + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return findMaxTopDown(capacity, itemsAvailable, weights, values);
    }
}
