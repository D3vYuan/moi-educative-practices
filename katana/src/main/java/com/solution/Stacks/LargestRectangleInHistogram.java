package com.solution.Stacks;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class LargestRectangleInHistogram {
    public static int largestRectangle(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            // Check if the current height is less than or equal to the height at the top of
            // the stack.
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                // Pop the stack to get the height of the rectangle.
                int currentHeight = heights[stack.pop()];

                // Calculate the right and left boundaries of the rectangle.
                int rightBoundary = i;
                int leftBoundary = stack.peek();
                int currentWidth = rightBoundary - leftBoundary - 1;

                // Calculate the area of the current rectangle.
                int currentArea = currentHeight * currentWidth;

                // Update the maximum area if the current area is greater.
                maxArea = Math.max(maxArea, currentArea);
            }
            // Push the current index onto the stack.
            stack.push(i);
        }

        // Calculate the length of the heights array.
        int n = heights.length;

        // Process any remaining elements in the stack.
        while (stack.peek() != -1) {
            // Pop the stack to get the height of the rectangle.
            int currentHeight = heights[stack.pop()];

            // Calculate the left boundary of the rectangle.
            int leftBoundary = stack.peek();
            int currentWidth = n - leftBoundary - 1;

            // Calculate the area of the current rectangle.
            int currentArea = currentHeight * currentWidth;

            // Update the maximum area if the current area is greater.
            maxArea = Math.max(currentArea, maxArea);
        }

        // Return the final maximum area of the largest rectangle.
        return maxArea;
    }

}
