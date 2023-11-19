package com.solution.DynamicProgramming;

public class PartitionEqualSubsetSum {
    /*
     * 
     * Strategy
     * [1] Create a matrix of appropriate size and initialize all cells with FALSE.
     * [2] Place TRUE in the first row of the matrix.
     * [3] Traverse the input array, element by element.
     * [4] Fill the cells of matrix either TRUE or FALSE depending upon their
     * inclusion in the subset sum.
     * [5] The value present at the last row and last column indicates whether the
     * array can be partitioned.
     * 
     * Explanation
     * [1] First, we calculate the sum of the array, nums. If the sum of the array
     * is odd, there can’t be two subsets with an equal sum, so we return FALSE.
     * [2] Create a lookup table, dp, of size (((s/2)+1)×(n+1)), where s is the sum,
     * and n is the size of the array. The dp[0][0] represents that the sum is 0,
     * and none of the elements is included in the sum. Therefore, (s/2+1) rows and
     * (n+1) columns are needed. Initialize all cells of dp with FALSE.
     * [3] Since each element in the array is a positive number, therefore the sum
     * of elements can’t be 0. Hence, each element of the first row in dp is set to
     * TRUE to represent the solution of the smallest sub-problem.
     * [4] The FALSE in the first column except [0][0] location indicates that an
     * empty array has no subset whose sum is greater than 0.
     * [5] Fill the table in a bottom-up approach where [i][j] represents the
     * current row and column entry.
     * - If the jth element of the array is greater than i, it will make the sum
     * greater than i, which means we cannot include this element in our subset.
     * Therefore, we copy the previous column’s value, which is dp[i][j-1], into
     * dp[i][j].
     * - If the jth element of the array is less than or equal to i, we have two
     * choices: either include it in our subset or exclude it. Here, we want to find
     * out if it is possible to form a subset with a sum of i using the first j
     * elements of the array.
     * * In the first choice, we need to find a subset that adds up to i - nums[j-1]
     * using the first j-1 elements of the nums array. That means we are looking at
     * the value of dp[i - nums[j - 1]][j - 1].
     * * In the second choice, we exclude the jth element from our subset and find a
     * subset that adds up to i using the first j-1 elements of the nums array. This
     * means we are looking at the value of dp[i][j - 1].
     * * Finally, we set dp[i][j] to the logical OR of these two choices: dp[i][j] =
     * dp[i - nums[j - 1]][j - 1] OR dp[i][j - 1].
     * [6] Return the value present at the last row and last column of the dp, which
     * denotes whether the array can be partitioned or not.
     * - If we get TRUE, then the array can be partitioned.
     * - If we get FALSE, then the array can not be partitioned.
     */

    public static boolean canPartitionArray(int[] nums) {
        int arraySum = 0;

        // Calculate Sum of Array
        for (Integer num : nums) {
            arraySum += num;
        }

        // If total sum is odd, it cannot be partitioned into equal sum subsets.
        if (arraySum % 2 != 0) {
            return false;
        }

        // Calculate the subset sum.
        int subsetSum = arraySum / 2;

        // Create a lookup table and fill all entries with FALSE.
        boolean[][] dp = new boolean[subsetSum + 1][nums.length + 1];

        // Initialize the first row as TRUE as each array has a subset whose sum is zero
        for (int i = 0; i <= nums.length; i++) {
            dp[0][i] = true;
        }

        // Fill the lookup table in a bottom-up manner.
        for (int i = 1; i <= subsetSum; i++) {
            for (int j = 1; j <= nums.length; j++) {
                if (nums[j - 1] > i) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i - nums[j - 1]][j - 1] || dp[i][j - 1];
                }
            }
        }

        // Return the last index of the matrix, which is our answer.
        return dp[subsetSum][nums.length];
    }
}
