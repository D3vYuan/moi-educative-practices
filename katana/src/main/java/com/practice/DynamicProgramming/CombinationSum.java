package com.practice.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /**
     * 
     * 
     * Strategy
     * [1] Initialize an array, arr, to store the combinations.
     * [2] For each value i, from 0 to target, iterate over nums and use previous
     * results from arr to calculate all combinations that sum up to i.
     * [3] Store all newly calculated combinations at arr[i].
     * [4] Return arr[target], which contains all the combinations that sum up to
     * target.
     */
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        // Initialize dp
        List<List<List<Integer>>> dp = new ArrayList<>(target + 1);
        dp.add(new ArrayList<>());
        dp.get(0).add(new ArrayList<>()); // For index = 9

        // For each value from 1 to target
        for (int i = 1; i <= target; i++) {
            dp.add(new ArrayList<>());

            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    // Checking previous results from dp
                    for (List<Integer> prev : dp.get(i - nums[j])) {
                        List<Integer> temp = new ArrayList<>(prev);
                        temp.add(nums[j]);
                        temp.sort(null);

                        // If the new combination is not already in dp
                        if (!dp.get(i).contains(temp)) {
                            dp.get(i).add(temp);
                        }
                    }
                }
            }
        }

        return dp.get(target);
    }
}
