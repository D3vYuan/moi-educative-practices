package com.example.CyclicSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

     public MissingNumber(){

     }

     public int findMissingNumber(int[] nums) {
        List<Integer> parms;
        int lenNums = nums.length;
        int index = 0;
        int value = 0;

        while (index < lenNums) {
            parms = new ArrayList<>(Collections.nCopies(2, -88));
            parms.set(0, index);
            value = nums[index];

            if (value < lenNums && value != nums[value]) {
                parms.set(1, value);
                int temp = nums[index];
                nums[index] = nums[value];
                nums[value] = temp;
            } else if (value >= lenNums){
                index += 1;
            } else {
                index += 1;
            }
        }
        parms = new ArrayList<>(Collections.nCopies(2, -88));

        for (int x = 0; x < lenNums; x++){
            parms.set(0, x);

            if (x != nums[x]){
                return x;
            }
        }

        return lenNums;
     }
}
