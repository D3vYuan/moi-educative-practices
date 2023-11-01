package com.solution.ModifiedBinarySearch;

public class BinarySearch {
    /**
     * We are given an array of integers, nums, sorted in ascending order, and an
     * integer value, target.
     * If the target exists in the array, return its index.
     * If the target does not exist, return -1.
     * 
     * Strategy
     * [1] Find the middle element in the sorted array.
     * [2] Compare the middle element with the target element. If it matches, return
     * the index of the element.
     * [3] If the target element is smaller than the middle element, perform the
     * search on the left half of the array. Otherwise, perform the search on the
     * right half of the array.
     * [4] Repeat the process until the target value is found. Otherwise, return -1
     * if not found.
     */

    public BinarySearch() {

    }

    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            // Finding the mid using integer division
            int mid = low + (high - low) / 2;

            // Target value is present at the middle of the array
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            }
        }

        // Target value is not present in the array
        return -1;
    }
}
