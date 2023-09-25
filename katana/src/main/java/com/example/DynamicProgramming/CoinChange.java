package com.example.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    /**
     * You're given an integer total and a list of integers called coins. The variable coins hold a list of coin denominations, and total is the total amount of money.
     * You have to find the minimum number of coins that can make up the total amount by using any combination of the coins. If the amount can't be made up, return -1. If the total amount is 0, return 0.
     * 
     * Strategy
     * [1] Initialize a counter array that contains elements equal to our total. Furthermore, initialize a variable to store the minimum number of coins needed. The minimum variable can be initialized to infinity at the start of each path.
     * [2] Traverse the coins array, and for each element, check the base cases. If the remaining sum is equal to 0, return 0. If it is less than 0, return -1 and if it is greater than 0, return the target value stored at the - ith index of the counter array. Store this value into a separate variable called result.
     * [3] Increment the value in result variable by one and add it to the minimum variable. Repeat this process until the (rem-1)^{th} index of the counter is not infinity.
     */
    
    public CoinChange(){

    }

    private int calculateMinimumCoins(int [] coins, int remainingTotal, int [] memo)
    {
        // 0: No new coins need to be added because we have reached a viable solution.
        // -1: Our path can’t lead to this solution, so we need to backtrack.
        // otherwise, using the top-down approach, at each iteration, 
        // we either pick a coin or we don’t. 
        // This way we either solve a new sub-problem or look up the answer from the table if it is already computed.
        
        int result = 0;
        if (remainingTotal < 0){
            return -1;
        }

        if (remainingTotal == 0){
            return 0;
        }

        if (memo[remainingTotal - 1] != Integer.MAX_VALUE){
            return memo[remainingTotal - 1];
        }

        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++) {
            result = calculateMinimumCoins(coins, remainingTotal - coins[j], memo);
            System.out.println(String.format("Total: %d | Coin: %d - Returns [%d] minimum coin", remainingTotal, coins[j], result));
            if (result >= 0 && result < minimum){
                System.out.println(String.format("Updating: Result (%d) is smaller than current minimum (%d)...replace minimum with new value", result, minimum));
                minimum = 1 + result;
            }
        }

        System.out.println("--");
        if (minimum != Integer.MAX_VALUE)
            memo[remainingTotal - 1] = minimum;
        else
            memo[remainingTotal - 1] = -1;
        return memo[remainingTotal - 1];
    }

    public int coinChange(int [] coins, int total) {
        if (total < 1){
            return 0;
        }

        int[] memo = new int[total];
        Arrays.fill(memo, Integer.MAX_VALUE);

        return calculateMinimumCoins(coins, total, memo);
     }
}
