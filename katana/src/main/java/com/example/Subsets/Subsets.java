package com.example.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    /**
     * Given an array of integers, nums, find all possible subsets of nums, including the empty set.
     * 
     * Strategy
     * [1] Compute the number of possible subsets of the given set using 2^n, where n is the number of elements.
     * [2] Start a loop from 0 to the count of subsets and add an empty list to the results list in the first iteration.
     * [3] In each iteration, create a bit mask of length n for each element in the input set. If the ith bit is set, set[i] will be present in the current subset.
     * [4] After iterating over all elements in the input set, append the current subset to the list of subsets.
     */

     public Subsets(){

     }

     private int getBit(int num, int bit){
        int temp = (1 << bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
     }

     public List<List<Integer>> findAllSubsets(int[] nums) {
        // Replace this placeholder return statement with your code
		
		List<List<Integer>> setsList = new ArrayList<>();
        if (nums.length != 0){
            int subsetCount = (int) (Math.pow(2, nums.length));
            for (int i = 0; i < subsetCount; i++) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < nums.length; j++) {
                    if (getBit(i, j) == 1){
                        int x = nums[j];
                        subset.add(x);
                    }
                }
                setsList.add(subset);
            }
        } else {
            List<Integer> emptySet = new ArrayList<>();
            setsList.add(emptySet);
        }
		return setsList;
	}
}
