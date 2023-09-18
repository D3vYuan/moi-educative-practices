package com.example.KWayMerge;

public class MergeSortedArray {
    /**
     * Given two sorted integer arrays, nums1 and nums2, 
     * and the number of data elements in each array, m and n, 
     * implement a function that merges the second array into the first one. 
     * You have to modify nums1 in place.
     * 
     * Strategy
     * [1] Initialize two pointers, p1 and p2, 
     * that point to the last data elements in nums1 and  nums2, respectively.
     * [2] Initialize a pointer p, that points to the last element of nums1.
     * [3] If the value at p1 is greater than the value at p2, set the value at p equal to  p1 and decrement p1 and p by 1.
     * [4] Else, if the value at  p2 is greater than the value at p1, set the value at p equal to p2 and decrement p2 and p by 1.
     * [5] Continue the traversal until nums2 is merged with nums1.
     */

     public MergeSortedArray(){

     }
}
