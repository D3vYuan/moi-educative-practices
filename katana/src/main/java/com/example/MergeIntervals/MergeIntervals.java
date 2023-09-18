package com.example.MergeIntervals;

public class MergeIntervals {
    /**
     * We are given an array of closed intervals, intervals, where each interval has a start time and an end time. The input array is sorted with respect to the start times of each interval. 
     * For example, intervals = [[1,4], [3,6], [7,9]] is sorted in terms of start times 1, 3, and 7
     * Your task is to merge the overlapping intervals and return a new output array consisting of only the non-overlapping intervals.
     * 
     * Strategy
     * [1] Insert the first interval from the input list into the output list.
     * [2] Start a loop to iterate over each interval of the input list, except for the first.
     * [3] If the input interval is overlapping with the last interval in the output list, merge these two intervals and replace the last interval of the output list with this merged interval.
     * [4] Otherwise, if the input interval does not overlap with the last interval in the output list, add the input interval to the output list.
     */

     public MergeIntervals(){

     }
}
