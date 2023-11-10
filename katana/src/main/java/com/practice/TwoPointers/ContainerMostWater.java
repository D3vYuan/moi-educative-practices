package com.practice.TwoPointers;

public class ContainerMostWater {
    public static int containerWithMostWater(int[] height) {
        // Initialize max area as zero and the start and end pointers to the two ends
        // of the array
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            // Calculate the width between the lines
            int width = end - start;
            // Calculate the max area using the shortest height and the
            // distance between the two lines
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * width);

            // Move the start if it has the shorter height
            if (height[start] <= height[end]) {
                start++;
            }
            // Otherwise move the end
            else {
                end--;
            }
        }

        // Return the maximum area
        return maxArea;
    }
}
