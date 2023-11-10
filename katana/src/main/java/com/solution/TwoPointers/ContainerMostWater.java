package com.solution.TwoPointers;

import java.util.Arrays;

public class ContainerMostWater {
    /**
     * You’re given an integer array height of length n, and there are n vertical
     * lines drawn such that the two endpoints of the ith line are (i,0) and (i,
     * height[i]).
     * 
     * Find two lines from the input array that, together with the x-axis, form a
     * container that holds as much water as possible. Return the maximum amount of
     * water a container can store.
     * 
     * Strategy
     * 
     */

    public static int containerWithMostWater(int[] height) {
        Arrays.stream(height).forEach(System.out::print);
        System.out.println();

        int mostWater = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            int currentWater = Math.min(height[start], height[end]) * (end - start);
            System.out.println(String.format("Start: %d | End: %d| Current Water: %d", start, end, currentWater));
            if (currentWater > mostWater) {
                mostWater = currentWater;
            }

            // If start < end, move towards end
            if (height[start] < height[end]) {
                start++;
            }
            // Otherwise move towards start
            else {
                end--;
            }
            System.out.println(String.format("Start: %d | End: %d| Current Water: %d", start, end, currentWater));
        }

        // Compute the min between left and right and move the smaller towards the
        // higher
        return mostWater;
    }
}
