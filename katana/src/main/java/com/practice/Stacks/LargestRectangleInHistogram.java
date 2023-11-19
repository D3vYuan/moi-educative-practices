package com.practice.Stacks;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

public class LargestRectangleInHistogram {
    public static int largestRectangle(int[] heights) {
        int start = 0;
        int end = heights.length - 1;

        int maximumArea = Integer.MIN_VALUE;
        while (start < end) {
            int left = heights[start];
            int right = heights[end];

            // int minBar = Arrays.stream(heights, start, end + 1).min().getAsInt();
            int minBar = Math.min(left, right);
            int currentArea = (end - start + 1) * minBar;

            System.out.println(String.format("Left: @{%d} (%d) | Right: @{%d} (%d) | Min: (%d) | Area: (%d)", start,
                    left, end, right, minBar, currentArea));
            if (currentArea > maximumArea) {
                maximumArea = currentArea;
            }

            if (left > right) { // Move pointer towards left
                end--;
            } else {
                start++;
            }

        }

        return maximumArea;
    }

}
