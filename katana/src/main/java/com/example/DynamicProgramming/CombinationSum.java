package com.example.DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    /**
     * Given an array of distinct integers, nums, and an integer, target, return a
     * list of all unique combinations of nums where the chosen numbers sum up to
     * the target. The combinations may be returned in any order.
     * An integer from nums may be chosen an unlimited number of times. Two
     * combinations are unique if the frequency of at least one of the chosen
     * integers is different.
     * 
     * Strategy
     * [1] Initialize an array, arr, to store the combinations.
     * [2] For each value i, from 0 to target, iterate over nums and use previous
     * results from arr to calculate all combinations that sum up to i
     * [3] Store all newly calculated combinations at arr[i].
     * [4] Return arr[target], which contains all the combinations that sum up to
     * target.
     */
    public CombinationSum() {

    }

    private String generateStringFromList(List<Integer> values) {
        if (values == null || values.isEmpty()) {
            return "";
        }

        String listString = "";
        for (Integer value : values) {
            String integerString = String.valueOf(value);
            if (listString.length() == 0) {
                listString = integerString;
            } else {
                listString += ", " + integerString;
            }
        }
        return listString;
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        if (nums.length <= 0) {
            return new ArrayList<>();
        }

        // Number Started From 0
        List<List<List<Integer>>> memo = new ArrayList<>(target + 1);
        memo.add(new ArrayList<>());
        memo.get(0).add(new ArrayList<>());

        for (int targetIndex = 1; targetIndex <= target; targetIndex++) {
            memo.add(new ArrayList<>());
            List<List<Integer>> currentNumMemo = memo.get(targetIndex);
            for (int numIndex = 0; numIndex < nums.length; numIndex++) {

                int currentNum = nums[numIndex];

                if (currentNum <= targetIndex) {
                    // Checking previous results from memo
                    int remainingIndex = targetIndex - currentNum;

                    // If there is a previous result, add current number to this previous result to
                    // form the current result
                    for (List<Integer> prev : memo.get(remainingIndex)) {
                        List<Integer> curr = new ArrayList<>(prev);
                        curr.add(currentNum);
                        curr.sort(null);

                        // String currCombination =
                        // curr.stream().map(String::valueOf).collect(Collectors.joining(","));
                        String currCombination = generateStringFromList(curr);
                        System.out.println(
                                String.format("Processing: Found match for %d - [%s]", targetIndex, currCombination));

                        // Store the current result into memo if it does not exists
                        if (!currentNumMemo.contains(curr)) {
                            currentNumMemo.add(curr);
                        }
                    }

                }
            }
        }

        return memo.get(target);
    }
}
