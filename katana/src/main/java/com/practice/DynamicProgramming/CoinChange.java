package com.practice.DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    /**
     * Strategy
     * [1] Initialize a counter array that contains elements equal to our total.
     * Furthermore, initialize a variable to store the minimum number of coins
     * needed. The minimum variable can be initialized to infinity at the start of
     * each path.
     * [2] Traverse the coins array, and for each element, check the base cases. If
     * the remaining sum is equal to 0, return 0. If it is less than 0, return -1
     * and if it is greater than 0, return the target value stored at the ith index
     * of the counter array. Store this value into a separate variable called
     * result.
     * [3] Increment the value in result variable by one and add it to the minimum
     * variable. Repeat this process until the (rem-1)^{th} index of the counter is
     * not infinity.
     */
    public static int calculateMinimumCoins(int [] coins, int rem, int [] counter)
    {
        int result = 0;
        if(rem < 0)
            return -1;
        if(rem == 0)
            return 0;
        if(counter[rem - 1] != Integer.MAX_VALUE)
            return counter[rem - 1];
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++)
        {
            result = calculateMinimumCoins(coins, rem - coins[j], counter);
            if(result >= 0 && result < minimum)
                minimum = 1 + result;
        }
        if(minimum != Integer.MAX_VALUE)
            counter[rem - 1] = minimum;
        else
            counter[rem - 1] = -1;
        return counter[rem -1];
    }
    
    public static int coinChange(int [] coins, int total)  
    {
        if(total < 1)
            return 0;
        int [] l = new int[total];
        Arrays.fill(l, Integer.MAX_VALUE);
        
        return calculateMinimumCoins(coins, total, l);
    }
}
