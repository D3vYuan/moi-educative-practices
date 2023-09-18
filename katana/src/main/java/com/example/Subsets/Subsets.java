package com.example.Subsets;

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
}
