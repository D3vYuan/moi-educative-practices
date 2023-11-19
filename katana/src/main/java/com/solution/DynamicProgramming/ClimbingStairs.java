package com.solution.DynamicProgramming;

public class ClimbingStairs {
    /**
     * Strategy
     * [1] Initialize a lookup table and fill in the indexes far the base cases af 1
     * and 2 jumps.
     * [2] Iterate over the lookup table and add the two previous values from the
     * lookup table to fill the next index.
     * [3] Repeat the process until the lookup table is filled.
     * [4] Return the nth index value from the lookup table, which is the number of
     * ways to climb n stairs.
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] lookupTable = new int[n + 1];

        // Setting the initial values for the first two steps
        lookupTable[1] = 1;
        lookupTable[2] = 2;

        // Starting from the third step up to the target step 'n'.
        for (int i = 3; i < lookupTable.length; i++) {
            lookupTable[i] = lookupTable[i - 1] + lookupTable[i - 2];
        }

        return lookupTable[n];
    }
}
