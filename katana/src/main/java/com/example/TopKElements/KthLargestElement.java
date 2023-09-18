package com.example.TopKElements;

public class KthLargestElement {
    /**
     * Given an infinite stream of integers (sorted or unsorted), nums, design a class to find the kth largest element in a stream.
     * 
     * Strategy
     * [1] Create a min heap from the elements in the input number stream
     * [2] Pop from the heap until the its size = k
     * [3] In the add function, push the incoming number to the stream
     * [4] If the size exceeds k, pop from the heap
     * [5] After iterating all of the numbers, return the top of the heap as the kth largest element
     */

     public KthLargestElement(){

     }
}
