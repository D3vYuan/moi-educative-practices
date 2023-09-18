package com.example.CyclicSort;

public class MissingNumber {
    /**
     * Given an array, nums, containing n distinct numbers in the range [0,n], 
     * return the only number in the range that is missing from the array.
     * 
     * Strategy
     * [1] Start the list traversal from the first element.
     * [2] If the list element isn’t equal to its index, swap it with the number on the correct index.
     * [3] Else, if the element is at the correct index or greater than the length of the array, skip it and move one step forward.
     * [4] Once you’ve iterated over the entire array, compare each number with its index.
     * [5] The first occurrence of an index that’s not equal to its list element is the missing number.
     */
}
