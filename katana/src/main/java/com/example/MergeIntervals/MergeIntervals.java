package com.example.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;
    boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}

public class MergeIntervals {
    /**
     * We are given an array of closed intervals, intervals, where each interval has
     * a start time and an end time. The input array is sorted with respect to the
     * start times of each interval.
     * For example, intervals = [[1,4], [3,6], [7,9]] is sorted in terms of start
     * times 1, 3, and 7
     * Your task is to merge the overlapping intervals and return a new output array
     * consisting of only the non-overlapping intervals.
     * 
     * Strategy
     * [1] Insert the first interval from the input list into the output list.
     * [2] Start a loop to iterate over each interval of the input list, except for
     * the first.
     * [3] If the input interval is overlapping with the last interval in the output
     * list, merge these two intervals and replace the last interval of the output
     * list with this merged interval.
     * [4] Otherwise, if the input interval does not overlap with the last interval
     * in the output list, add the input interval to the output list.
     */

    public MergeIntervals() {

    }

    public List<Interval> mergeIntervals(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();

        if (intervals.size() <= 0){
            System.out.println("List is empty");
            return result;
        }

        // Add First Pair into result list
        Interval firstInterval = intervals.get(0);
        result.add(new Interval(firstInterval.getStart(), firstInterval.getEnd()));

        for (int i = 1; i < intervals.size(); i ++){
            Interval latestResultInterval = result.get(result.size() - 1);

            Interval currentInterval = intervals.get(i);
            int currentStart = currentInterval.getStart();
            int currentEnd = currentInterval.getEnd();

            int previousEnd = latestResultInterval.getEnd();

            // Overlapping
            if (previousEnd >= currentStart){
                int latestEnd = Math.max(currentEnd, previousEnd);
                latestResultInterval.setEnd(latestEnd);
            } else { // Non-overlapping
                result.add(new Interval(currentStart, currentEnd));
            }
        }

        return result;
    }

    private String intervalListToString(List<Interval> l1) {
        String resultStr = "[";
        for (int i = 0; i < l1.size() - 1; i++) {
            resultStr += "[" + l1.get(i).getStart() + ", " + l1.get(i).getEnd() + "], ";
        }
        resultStr += "[" + l1.get(l1.size() - 1).getStart() + ", " + l1.get(l1.size() - 1).getEnd() + "]";
        resultStr += "]";
        return resultStr;

    }
}
