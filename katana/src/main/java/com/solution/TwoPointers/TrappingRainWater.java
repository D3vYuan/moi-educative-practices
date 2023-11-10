package com.solution.TwoPointers;

public class TrappingRainWater {
    /**
     * Given a sequence of non-negative integers representing the heights of bars in
     * an elevation map, the goal is to determine the amount of rainwater that can
     * be trapped between the bars after rain.
     * 
     * Strategy
     * [1] Initialize two pointers, left and right to iterate the given heights
     * array.
     * [2] Iterate the array and at each iteration, based on the lower maximum
     * height among the two sides, start computing the amount of rain water that can
     * be trapped.
     * [3] For each bar in the heights array, find the difference between the
     * maximum height of that side and the current bar’s height.
     * [4] Add this amount to the storedWater variable and update the maximum of the
     * respective side to ensure the correct calculations for the subsequent
     * iterations.
     * [5] Repeat this process until left becomes greater than right. Return the
     * cumulative sum stored in the storedWater variable.
     */

    public static int rainWater(int[] heights) {
        // Replace this placeholder return statement with your code

        int start = 0;
        int end = heights.length - 1;

        int leftMax = heights[start];
        int rightMax = heights[end];

        int collectedWater = 0;

        while (start < end) {
            int currentLeft = heights[start];
            int currentRight = heights[end];

            if (currentLeft > leftMax) {
                leftMax = currentLeft;
            } else if (currentRight > rightMax) {
                rightMax = currentRight;
            } else {
                int currentHeight = leftMax > rightMax ? currentRight : currentLeft;
                int currentWater = Math.min(leftMax, rightMax) - currentHeight < 0 ? 0
                        : Math.min(leftMax, rightMax) - currentHeight;
                System.out.println(String.format(
                        "Current Left: %d | Left Max: %d | Current Right: %d | Right Max: %d | Current Water: %d",
                        currentLeft, leftMax, currentRight, rightMax, currentWater));

                collectedWater += currentWater;
                System.out.println(String.format("Start: %d | End: %d | Water: %d", start, end, collectedWater));
            }

            if (leftMax > rightMax && rightMax != Integer.MIN_VALUE) {
                // Left side bigger, move right nearer to left
                end--;
            } else if (leftMax <= rightMax && leftMax != Integer.MIN_VALUE) {
                // Right side bigger, move left nearer to right
                start++;
            }
        }

        return collectedWater;
    }
}
