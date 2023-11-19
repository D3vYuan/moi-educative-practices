package com.solution.DynamicProgramming;

public class MaximumSubarray {
    /**
     * 
     * 
     * Strategy
     * [1] Initialize two variables, currentSum and maxSum, with the value of the
     * first element in the input list. These variables are used to keep track of
     * the current sum of the subarray being considered, and the maximum sum found
     * so far.
     * [2] Iterate through the input list, starting from the second element to the
     * end of the list. Within the loop, perform the following steps:
     * - If currentSum + nums[i] is smaller than nums[i], this indicates that
     * starting a new subarray with nums[i] would yield a larger sum than extending
     * the previous subarray. In such cases, reset currentSum to nums[i].
     * - Compare the current maxSum with the updated currentSum. This step ensures
     * that the maxSum always stores the maximum sum encountered so far.
     * [3] After the loop completes, the function returns the maxSum, which
     * represents the maximum sum of any contiguous subarray within the input list.
     */

    public static int maxSubArray(int[] nums) {
        // Initialize variables to keep track of the current subarray sum and the
        // maximum subarray sum.

        int currentSum = nums[0];
        int maxSum = nums[0];

        // Iterate through the array starting from the second element.
        for (int i = 1; i < nums.length; i++) {
            // Calculate the current subarray sum by considering two possibilities:
            // 1. The current element creates a new subarray with a higher sum (nums[i]
            // itself).
            // 2. The current element extends the subarray ending at i-1 with the current
            // element.

            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum subarray sum seen so far.

            maxSum = Math.max(maxSum, currentSum);
        }

        // Return the maximum subarray sum.
        return maxSum;
    }
}
